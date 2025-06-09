public class Horario {
    private String diaSemana;
    private String horaInicio;
    private String horaFim;
    private String sala;

    public Horario(String diaSemana, String horaInicio, String horaFim, String sala) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.sala = sala;
    }

    public String getDiaSemana() { return diaSemana; }
    public String getHoraInicio() { return horaInicio; }
    public String getHoraFim() { return horaFim; }
    public String getSala() { return sala; }
}