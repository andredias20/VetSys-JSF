package model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author andre
 */
public class Agendamento {
    
    private int id;
    private int veterinario_id;
    private Date horario;
    private Paciente paciente;

    public Agendamento() {
    }

    public Agendamento(int id, int veterinario_id, Date horario, Paciente paciente) {
        this.id = id;
        this.veterinario_id = veterinario_id;
        this.horario = horario;
        this.paciente = paciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVeterinario_id() {
        return veterinario_id;
    }

    public void setVeterinario_id(int veterinario_id) {
        this.veterinario_id = veterinario_id;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Agendamento{" + "id=" + id + ", veterinario_id=" + veterinario_id + ", horario=" + horario + ", paciente=" + paciente + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.veterinario_id;
        hash = 83 * hash + Objects.hashCode(this.horario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agendamento other = (Agendamento) obj;
        if (this.veterinario_id != other.veterinario_id) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        return true;
    }
    
    
    
}
