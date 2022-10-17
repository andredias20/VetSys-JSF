package model;

/**
 *
 * @author andre
 */
public class Paciente {
    
    private int id;
    private String nomeAnimal;
    private String descricaoMotivo;
    private String nomeTutor;
    private String telefoneTutor;

    public Paciente() {
    }

    public Paciente(String nomeAnimal, String descricaoMotivo, String nomeTutor, String telefoneTutor) {
        this.nomeAnimal = nomeAnimal;
        this.descricaoMotivo = descricaoMotivo;
        this.nomeTutor = nomeTutor;
        this.telefoneTutor = telefoneTutor;
    }

    public Paciente(int id, String nomeAnimal, String descricaoMotivo, String nomeTutor, String telefoneTutor) {
        this.id = id;
        this.nomeAnimal = nomeAnimal;
        this.descricaoMotivo = descricaoMotivo;
        this.nomeTutor = nomeTutor;
        this.telefoneTutor = telefoneTutor;
    }

    public int getId() {
        return id;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getDescricaoMotivo() {
        return descricaoMotivo;
    }

    public void setDescricaoMotivo(String descricaoMotivo) {
        this.descricaoMotivo = descricaoMotivo;
    }

    public String getNomeTutor() {
        return nomeTutor;
    }

    public void setNomeTutor(String nomeTutor) {
        this.nomeTutor = nomeTutor;
    }

    public String getTelefoneTutor() {
        return telefoneTutor;
    }

    public void setTelefoneTutor(String telefoneTutor) {
        this.telefoneTutor = telefoneTutor;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nomeAnimal=" + nomeAnimal + ", descricaoMotivo=" + descricaoMotivo + ", nomeTutor=" + nomeTutor + ", telefoneTutor=" + telefoneTutor + '}';
    }
    
}
