package gerenciadordisciplinas;

public class Disciplina {
    private String nome;
    private String codigo;
    private String professor;
    private int creditos;

    public Disciplina(String nome, String codigo, String professor, int creditos) {
        this.nome = nome;
        this.codigo = codigo;
        this.professor = professor;
        this.creditos = creditos;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getProfessor() {
        return professor;
    }

    public int getCreditos() {
        return creditos;
    }
}