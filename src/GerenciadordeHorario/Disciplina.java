package GerenciadordeHorario;

public class Disciplina {
    private String nome;
    private String codigo;
    private String professor;


    public Disciplina(String nome, String codigo, String professor) {
        this.nome = nome;
        this.codigo = codigo;
        this.professor = professor;
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



    public void exibirDetalhes() {
        System.out.println("Disciplina: " + nome + " | Código: " + codigo +
                " | Professor: " + professor);
    }
}

