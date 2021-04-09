package exercicio;

import java.util.List;

public class CursoMain {

    public static void main(String[] args) {
        CursoDAO dao = new CursoDAO();

        // Lista
        List<Curso> cursos = dao.list();
        cursos.forEach(System.out::println);

        // Busca por id
        System.out.println();
        System.out.println(dao.getById(2));

        // Inserção
        System.out.println();
        dao.create(new Curso("Introdução ao Linux", 10));
        cursos.forEach(System.out::println);

        // Atualização
        System.out.println();
        Curso curso = dao.getById(6);
        curso.setNome("ShellScript");
        curso.setDuracaoHoras(2);

        dao.update(curso);
        cursos.forEach(System.out::println);

        //Exclusão
        System.out.println();
        dao.delete(6);
        cursos.forEach(System.out::println);

    }

}
