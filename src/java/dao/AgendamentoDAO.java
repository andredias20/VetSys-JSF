/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import IO_Storage.IO_Agendamento;
import java.io.Serializable;
import java.util.LinkedList;
import model.Agendamento;

/**
 *
 * @author andre
 */


public class AgendamentoDAO implements Serializable{

    private static LinkedList<Agendamento> agendamentosList = null;

    public AgendamentoDAO() {
    }
   
    public LinkedList<Agendamento> getAll() {
        return agendamentosList;
    }

    public void addAll(LinkedList<Agendamento> list) {
        agendamentosList.addAll(list);
    }

    public void addAgendamento(Agendamento e) {
        System.out.println("Passou pela adicao");
        if (agendamentosList.contains(e)) {
            return;
        } else {
            if (e.getId() == 0) {
                e.setId(agendamentosList.size());
            }
            System.out.println("Executou o metodo");
            agendamentosList.add(e);
        }
    }

    public void removeAgendamento(Agendamento e) {
        agendamentosList.remove(e);
    }
    
    
    public void start(){
        agendamentosList = IO_Agendamento.readItems();
    }
    
    public void end(){
        IO_Agendamento.writeItems(agendamentosList);
    }

}
