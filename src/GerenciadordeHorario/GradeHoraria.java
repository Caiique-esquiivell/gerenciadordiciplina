import java.util.*;

public class GradeHoraria {
    private Map<Disciplina, Horario> grade = new HashMap<>();

    public void adicionar(Disciplina d, Horario h) {
        grade.put(d, h);
    }

    public boolean removerPorCodigo(String codigo) {
        Disciplina disciplinaParaRemover = null;
        for (Disciplina d : grade.keySet()) {
            if (d.getCodigo().equals(codigo)) {
                disciplinaParaRemover = d;
                break;
            }
        }
        if (disciplinaParaRemover != null) {
            grade.remove(disciplinaParaRemover);
            return true;
        }
        return false;
    }

    public Map<Disciplina, Horario> getGrade() {
        return grade;
    }
}