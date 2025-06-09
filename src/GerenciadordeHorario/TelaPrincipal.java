import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class TelaPrincipal extends JFrame {
    private Usuario usuario;

    public TelaPrincipal(Usuario usuario) {
        this.usuario = usuario;
        setTitle("Gerenciador de Disciplinas");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnAdicionar = new JButton("Adicionar Disciplina");
        JButton btnRemover = new JButton("Remover Disciplina");
        JButton btnVisualizar = new JButton("Visualizar Grade");

        btnAdicionar.addActionListener(e -> adicionarDisciplina());
        btnRemover.addActionListener(e -> removerDisciplina());
        btnVisualizar.addActionListener(e -> visualizarGrade());

        add(btnAdicionar);
        add(btnRemover);
        add(btnVisualizar);
        setVisible(true);
    }

    private void adicionarDisciplina() {
        String nome = JOptionPane.showInputDialog("Nome da disciplina:");
        String codigo = JOptionPane.showInputDialog("Código:");
        String professor = JOptionPane.showInputDialog("Professor:");
        String dia = JOptionPane.showInputDialog("Dia da semana:");
        String inicio = JOptionPane.showInputDialog("Hora início:");
        String fim = JOptionPane.showInputDialog("Hora fim:");
        String sala = JOptionPane.showInputDialog("Sala:");

        Disciplina d = new Disciplina(nome, codigo, professor);
        Horario h = new Horario(dia, inicio, fim, sala);
        usuario.adicionarDisciplina(d, h);
    }

    private void removerDisciplina() {
        String codigo = JOptionPane.showInputDialog("Digite o código da disciplina a remover:");
        boolean removido = usuario.removerDisciplina(codigo);
        if (removido) {
            JOptionPane.showMessageDialog(this, "Disciplina removida.");
        } else {
            JOptionPane.showMessageDialog(this, "Disciplina não encontrada.");
        }
    }

    private void visualizarGrade() {
        Map<Disciplina, Horario> gradeMap = usuario.getGrade().getGrade();

        if (gradeMap.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhuma disciplina cadastrada na grade.");
            return;
        }

        StringBuilder sb = new StringBuilder("------ GRADE DE HORÁRIOS ------\n\n");
        for (Map.Entry<Disciplina, Horario> entry : gradeMap.entrySet()) {
            Disciplina d = entry.getKey();
            Horario h = entry.getValue();

            sb.append("Código: ").append(d.getCodigo()).append("\n")
              .append("Nome: ").append(d.getNome()).append("\n")
              .append("Professor: ").append(d.getProfessor()).append("\n")
              .append("Horário: ").append(h.getDiaSemana()).append(" | ")
              .append(h.getHoraInicio()).append(" - ").append(h.getHoraFim()).append("\n")
              .append("Sala: ").append(h.getSala()).append("\n")
              .append("------------------------------\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString(), "Grade Horária", JOptionPane.INFORMATION_MESSAGE);
    }
}