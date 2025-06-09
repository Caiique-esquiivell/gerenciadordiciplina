public class Usuario {
    private String nome;
    private GradeHoraria grade;

    public Usuario(String nome) {
        this.nome = nome;
        this.grade = new GradeHoraria();
    }

    public void adicionarDisciplina(Disciplina d, Horario h) {
        grade.adicionar(d, h);
    }

    public boolean removerDisciplina(String codigo) {
        return grade.removerPorCodigo(codigo);
    }

    public GradeHoraria getGrade() {
        return grade;
    }
}