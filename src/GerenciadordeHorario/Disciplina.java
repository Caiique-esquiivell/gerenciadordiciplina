import java.util.Objects;

public class Disciplina {
    private String nome;
    private String codigo;
    private String professor;

    public Disciplina(String nome, String codigo, String professor) {
        this.nome = nome;
        this.codigo = codigo;
        this.professor = professor;
    }

    public String getNome() { return nome; }
    public String getCodigo() { return codigo; }
    public String getProfessor() { return professor; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disciplina)) return false;
        Disciplina d = (Disciplina) o;
        return Objects.equals(codigo, d.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}