package exercicio;

import part3.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    String msgErro = "Erro ao executar consulta!";

    public List<Curso> list() {
        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {
            String query = "SELECT id, nome, duracao_horas FROM curso";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("duracao_horas")
                );

                cursos.add(curso);
            }

        } catch (SQLException ex) {
            System.out.println(msgErro);
            ex.printStackTrace();
        }

        return cursos;
    }

    public Curso getById(int id) {
        Curso curso = null;

        try(Connection conn = ConnectionFactory.getConnection()) {
            String query = "SELECT id, nome, duracao_horas FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                curso = new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("duracao_horas")
                );
            }
        } catch (SQLException ex) {
            System.out.println(msgErro);
            ex.printStackTrace();
        }
        return curso;
    }

    public void create(Curso curso) {
        try(Connection conn = ConnectionFactory.getConnection()) {
            String query = "INSERT INTO curso (nome, duracao_horas) VALUES (?, ?)";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());

            int rowsAffected = stmt.executeUpdate();
            System.out.printf("Sucesso! %d linhas afetadas.", rowsAffected);
        } catch (SQLException ex) {
            System.out.println(msgErro);
            ex.printStackTrace();
        }
    }

    public void update(Curso curso) {
        try(Connection conn = ConnectionFactory.getConnection()) {
            String query = "UPDATE curso SET nome = ?, duracao_horas = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());
            stmt.setInt(3, curso.getId());

            int rowsAffected = stmt.executeUpdate();
            System.out.printf("Sucesso! %d linhas afetadas.", rowsAffected);
        } catch (SQLException ex) {
            System.out.println(msgErro);
            ex.printStackTrace();
        }
    }

    public void delete(int id) {
        try(Connection conn = ConnectionFactory.getConnection()) {
            String query = "DELETE FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            System.out.printf("Sucesso! %d linhas afetadas.\n", rowsAffected);
        } catch (SQLException ex) {
            System.out.println(msgErro);
            ex.printStackTrace();
        }
    }

}
