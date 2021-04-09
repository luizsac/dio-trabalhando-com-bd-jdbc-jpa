package exercicio;

public class Curso {

    private int id;
    private String nome;
    private int duracaoHoras;

    public Curso(String nome, int duracaoHoras) {
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso(int id, String nome, int duracaoHoras) {
        this.id = id;
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(int duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    @Override
    public String toString() {
        return new StringBuilder("Curso: ")
                .append("Id = ").append(id).append(", ")
                .append("Nome = ").append(nome).append(", ")
                .append("Duração = ").append(duracaoHoras).append("h")
                .toString();
    }
}
