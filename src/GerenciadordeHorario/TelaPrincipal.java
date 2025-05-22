package GerenciadordeHorario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaPrincipal extends JFrame {

    private Usuario usuario;

    public TelaPrincipal() {
        usuario = new Usuario("Caique Esquivel", "202512345");
        setTitle("Gerenciador de Disciplinas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza na tela

        // Criando componentes
        JButton btnAdicionar = new JButton("Adicionar Disciplina");
        JButton btnVerGrade = new JButton("Visualizar Grade");

        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(2, 1, 10, 10));
        painel.add(btnAdicionar);
        painel.add(btnVerGrade);

        add(painel);

        // Ações dos botões
        btnAdicionar.addActionListener(e -> adicionarDisciplina());
        btnVerGrade.addActionListener(e -> exibirGrade());
    }

    private void adicionarDisciplina() {
        String nome = JOptionPane.showInputDialog("Nome da disciplina:");
        String codigo = JOptionPane.showInputDialog("Código:");
        String professor = JOptionPane.showInputDialog("Professor:");
        int creditos = Integer.parseInt(JOptionPane.showInputDialog("Créditos:"));

        String dia = JOptionPane.showInputDialog("Dia da semana:");
        String horaInicio = JOptionPane.showInputDialog("Hora início (HH:MM):");
        String horaFim = JOptionPane.showInputDialog("Hora fim (HH:MM):");
        String sala = JOptionPane.showInputDialog("Sala:");

        Disciplina d = new Disciplina(nome, codigo, professor);
        Horario h = new Horario(dia, horaInicio, horaFim, sala);

        boolean sucesso = usuario.getGrade().adicionarDisciplina(d, h);

        if (sucesso)
            JOptionPane.showMessageDialog(this, "Disciplina adicionada com sucesso!");
        else
            JOptionPane.showMessageDialog(this, "Conflito de horário!");
    }

    private void exibirGrade() {
        StringBuilder sb = new StringBuilder();
        for (var entry : usuario.getGrade().grade.entrySet()) {
            Disciplina d = entry.getKey();
            Horario h = entry.getValue();
            sb.append(d.getNome()).append(" - ").append(d.getCodigo()).append("\n")
                    .append(h.getDiaSemana()).append(" das ")
                    .append(h.getHoraInicio()).append(" às ").append(h.getHoraFim())
                    .append(" | Sala ").append(h.getSala()).append("\n\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString(), "Grade Horária", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
}
