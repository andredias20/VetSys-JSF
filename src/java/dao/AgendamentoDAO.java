/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import model.Agendamento;
import model.Paciente;

/**
 *
 * @author andre
 */


public class AgendamentoDAO implements Serializable{

    private static LinkedList<Agendamento> agendamentosList;

    public AgendamentoDAO() {
    }
    
    public boolean contains(int veterinario_id, Date horario){
//        new Agendamento(veterinario_id, veterinario_id, horario, );
//        agendamentosList.contains()
//        
        return false;
    }

    public LinkedList<Agendamento> getAll() {
        return agendamentosList;
    }

    public void addAll(LinkedList<Agendamento> list) {
        agendamentosList.addAll(list);
    }

    public void addAgendamento(Agendamento e) {
        if (agendamentosList.contains(e)) {
            return;
        } else {
            if (e.getId() == 0) {
                e.setId(agendamentosList.size() + 1);
            }
            agendamentosList.add(e);
        }
    }

    public void removeAgendamento(Agendamento e) {
        agendamentosList.remove(e);
    }
    
    
    public void start(){
        
    }
    
    public void end(){
        
    }

    @PostConstruct
    public void post() {
        if (agendamentosList == null) {
            //Puxar itens gravados no 'arquivos/database'
            agendamentosList = new LinkedList<>();
            agendamentosList.add(new Agendamento(
                    1,
                    1,
                    1,
                    new Date(),
                    new Paciente("Cachorrinho", "Probleminhas", "Carlos", "(45) 9 9833-8540"))
            );
        }
    }

}
