/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.time.Instant;
import java.util.Date;
import java.util.LinkedList;
import model.Agendamento;
import model.Paciente;

/**
 *
 * @author andre
 */
public class AgendamentoDAO {

    private LinkedList<Agendamento> agendamentosList;

    public AgendamentoDAO() {
        if (agendamentosList == null) {
            //Puxar itens gravados no 'arquivos/database'
            agendamentosList = new LinkedList<>();
            agendamentosList.add(new Agendamento(1,
                    1,
                    Date.from(Instant.MIN), 
                    new Paciente("Cachorrinho", "Probleminhas", "Carlos", "(45) 9 9833-8540"))
            );
        }
    }
    
    public LinkedList<Agendamento> getAll(){
        return agendamentosList;
    }
    
    public void addAll(LinkedList<Agendamento> list){
        agendamentosList.addAll(list);
    }

    public void addAgendamento(Agendamento e) {
        if (agendamentosList.contains(e)) {
            return;
        } else {
            agendamentosList.add(e);
        }
    }
    
    public void removeAgendamento(Agendamento e){
        agendamentosList.remove(e);
    }

}