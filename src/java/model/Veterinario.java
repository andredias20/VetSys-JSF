package model;

import java.io.Serializable;

/**
 *
 * @author andre
 */
public class Veterinario implements Serializable{

    private Integer id;
    private String nome;
    private Integer tipo_animal_id;

    public Veterinario() {
    }

    public Veterinario(String nome, int tipo_animal_id){
        this.nome = nome;
        this.tipo_animal_id = tipo_animal_id;
    }

    public Veterinario(int id, String nome, int tipo_animal_id) {
        this.id = id;
        this.nome = nome;
        this.tipo_animal_id = tipo_animal_id;
    }

    public Veterinario(int id, String nome, TipoAnimal tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo_animal_id = tipo.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo_animal_id() {
        return tipo_animal_id;
    }

    public void setTipo_animal_id(int tipo_animal_id) {
        this.tipo_animal_id = tipo_animal_id;
    }

    @Override
    public String toString() {
        return "Veterinario{" + "id=" + id + ", nome=" + nome + ", tipo_animal_id=" + tipo_animal_id + '}';
    }
    
    

}
