package GerenciadordeHorario;

import java.util.*;

public class GradeHoraria {
    // Alterado de private para protected (ou pode usar um getter se preferir encapsulamento total)
    protected Map<Disciplina, Horario> grade = new HashMap<>();

    public boolean adicionarDisciplina(Disciplina disciplina, Horario horario) {
        for (Horario h : grade.values()) {
            if (h.conflitaCom(horario)) {
                return false;
            }
        }
        grade.put(disciplina, horario);
        return true;
    }

    public boolean removerDisciplina(String codigo) {
        for (Disciplina d : grade.keySet()) {
            if (d.getCodigo().equals(codigo)) {
                grade.remove(d);
                return true;
            }
        }
        return false;
    }

    public Map<Disciplina, Horario> getGrade() {
        return grade;
    }
}

