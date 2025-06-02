package gerenciadordisciplinas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaPrincipal extends JFrame {
    private Usuario usuario;

    public TelaPrincipal() {
        usuario = new Usuario("Aluno", "123456");

        setTitle("Gerenciador de Disciplinas");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 1));

        JButton btnAdicionar = new JButton("Adicionar Disciplina");
        btnAdicionar.addActionListener(e -> adicionarDisciplina());
        painel.add(btnAdicionar);

        JButton btnVisualizar = new JButton("Visualizar Grade");
        btnVisualizar.addActionListener(e -> visualizarGrade());
        painel.add(btnVisualizar);

        JButton btnRemover = new JButton("Remover Disciplina");
        btnRemover.addActionListener(e -> removerDisciplina());
        painel.add(btnRemover);

        add(painel);
        setVisible(true);
    }

    private void adicionarDisciplina() {
        String nome = JOptionPane.showInputDialog("Nome da disciplina:");
        String codigo = JOptionPane.showInputDialog("Código:");
        String professor = JOptionPane.showInputDialog("Professor:");
        int creditos = Integer.parseInt(JOptionPane.showInputDialog("Créditos:"));
        String dia = JOptionPane.showInputDialog("Dia da semana:");
        String inicio = JOptionPane.showInputDialog("Hora início (HH:mm):");
        String fim = JOptionPane.showInputDialog("Hora fim (HH:mm):");
        String sala = JOptionPane.showInputDialog("Sala:");

        Disciplina d = new Disciplina(nome, codigo, professor, creditos);
        Horario h = new Horario(dia, inicio, fim, sala);
        boolean sucesso = usuario.getGrade().adicionarDisciplina(d, h);

        JOptionPane.showMessageDialog(this, sucesso ? "Adicionada com sucesso!" : "Conflito de horário.");
    }

    private void visualizarGrade() {
        StringBuilder sb = new StringBuilder();
        for (var entry : usuario.getGrade().getGrade().entrySet()) {
            Disciplina d = entry.getKey();
            Horario h = entry.getValue();
            sb.append(d.getCodigo()).append(" - ").append(d.getNome())
              .append(" | ").append(h.getDiaSemana())
              .append(" ").append(h.getHoraInicio()).append("-").append(h.getHoraFim())
              .append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void removerDisciplina() {
        String codigo = JOptionPane.showInputDialog("Código da disciplina a remover:");
        boolean sucesso = usuario.getGrade().removerDisciplinaPorCodigo(codigo);
        JOptionPane.showMessageDialog(this, sucesso ? "Removida com sucesso!" : "Disciplina não encontrada.");
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}