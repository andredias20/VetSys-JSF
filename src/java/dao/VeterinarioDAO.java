/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.LinkedList;
import java.util.stream.Collectors;
import javax.faces.model.SelectItem;
import model.Veterinario;

/**
 *
 * @author andre
 */
public class VeterinarioDAO {
    
    private LinkedList<Veterinario> veterinarioList;
    private LinkedList<SelectItem> veterinarioSelectItems;
    
    public VeterinarioDAO(){
        System.out.println("Criando VeterinarioDAO");
        System.out.flush();
        
        if(veterinarioList == null){
            veterinarioList = new LinkedList<>();
            
            veterinarioList.add(new Veterinario(1, "Dr. Carlos", 1));
            veterinarioList.add(new Veterinario(2, "Dra. Vanessa", 1));
            veterinarioList.add(new Veterinario(3, "Dra. Thais", 2));
            veterinarioList.add(new Veterinario(4, "Dr. Gabriel", 2));
            
            processSelectItems();
        }
    }
    
    public Veterinario searchVeterinario(int id){
        return veterinarioList
                .stream()
                .filter(vet -> vet.getId() == id)
                .findFirst()
                .get();
    }
    
    public LinkedList<Veterinario> searchVeterinariosByAnimalType(int id){
        return (LinkedList) veterinarioList
                .stream()
                .filter(vet -> vet.getId() == id)
                .collect(Collectors.toList());
    }
    
    public LinkedList<SelectItem> getSelectItems(int id){
        LinkedList<Veterinario> vetList = searchVeterinariosByAnimalType(id);
        return processSelectItems(vetList);
    }

    public LinkedList<Veterinario> getVeterinarioList() {
        return veterinarioList;
    }

    public void setVeterinarioList(LinkedList<Veterinario> veterinarioList) {
        this.veterinarioList = veterinarioList;
        processSelectItems();
    }
    
    
    
    private void processSelectItems(){
        veterinarioSelectItems = new LinkedList<>();
        
        veterinarioSelectItems.add(new SelectItem(null, "Selecione um Veterinario"));
        veterinarioList.forEach(vet -> 
                veterinarioSelectItems.add(new SelectItem(vet, vet.getNome())));
    }
    private LinkedList<SelectItem> processSelectItems(LinkedList<Veterinario> list){
        LinkedList<SelectItem> vetSelectItems = new LinkedList<>();
        
        vetSelectItems.add(new SelectItem(null, "Selecione um Veterinario"));
        list.forEach(vet -> 
                vetSelectItems.add(new SelectItem(vet, vet.getNome())));
        
        return vetSelectItems;
    }
}
