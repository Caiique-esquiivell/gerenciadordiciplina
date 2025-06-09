package GerenciadordeHorario;

import java.util.*;

public class GradeHoraria {
    private Map<Disciplina, Horario> grade;

    public GradeHoraria() {
        this.grade = new HashMap<>();
    }

    public boolean adicionarDisciplina(Disciplina disciplina, Horario horario) {
        for (Horario h : grade.values()) {
            if (h.conflitaCom(horario)) return false;
        }
        grade.put(disciplina, horario);
        return true;
    }

    public boolean removerDisciplinaPorCodigo(String codigo) {
        Disciplina alvo = null;
        for (Disciplina d : grade.keySet()) {
            if (d.getCodigo().equalsIgnoreCase(codigo)) {
                alvo = d;
                break;
            }
        }
        if (alvo != null) {
            grade.remove(alvo);
            return true;
        }
        return false;
    }

    public Map<Disciplina, Horario> getGrade() {
        return grade;
    }
}
