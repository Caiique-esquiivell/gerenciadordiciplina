package GerenciadordeHorario;

public class Usuario {
    private String nome;
    private String matricula;
    private GradeHoraria grade;

    public Usuario(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.grade = new GradeHoraria();
    }

    public GradeHoraria getGrade() {
        return grade;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }
}
