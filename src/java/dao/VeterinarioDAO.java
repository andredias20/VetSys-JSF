package dao;

import IO_Storage.IO_Veterinarios;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.model.SelectItem;
import model.Veterinario;

/**
 *
 * @author andre
 */

public final class VeterinarioDAO implements Serializable {

    private static LinkedList<Veterinario> veterinarioList = null;
    private static LinkedList<SelectItem> veterinarioSelectItems = null;

    public VeterinarioDAO() {
        veterinarioList = new LinkedList<Veterinario>();
    }

    public Veterinario searchVeterinario(int id) {
        return veterinarioList
                .stream()
                .filter(vet -> vet.getId() == id)
                .findFirst()
                .get();
    }

    public List<Veterinario> searchVeterinariosByAnimalType(int id) {
       return veterinarioList
                .stream()
                .filter(vet -> vet.getTipo_animal_id() == id)
                .collect(Collectors.toList());
        
        
    }

    public LinkedList<SelectItem> getSelectItems(int id) {
        List<Veterinario> vetList = searchVeterinariosByAnimalType(id);
        return processSelectItems(vetList);
    }

    public LinkedList<Veterinario> getVeterinarioList() {
        return veterinarioList;
    }

    public void setVeterinarioList(LinkedList<Veterinario> veterinarioList) {
        this.veterinarioList = veterinarioList;
        processSelectItems();
    }

    private void processSelectItems() {
        veterinarioSelectItems = new LinkedList<SelectItem>();

        veterinarioSelectItems.add(new SelectItem(null, "Selecione um Veterinario"));
        veterinarioList.forEach(vet
                -> veterinarioSelectItems.add(new SelectItem(vet, vet.getNome())));
    }

    private LinkedList<SelectItem> processSelectItems(List<Veterinario> list) {
        LinkedList<SelectItem> vetSelectItems = new LinkedList<SelectItem>();
        
        vetSelectItems.add(new SelectItem(null, "Selecione um Veterinario"));
        list.forEach(vet
                -> vetSelectItems.add(new SelectItem(vet, vet.getNome())));

        return vetSelectItems;
    }
    
    public void addVeterinario(Veterinario vet){
        if(vet.getId() == null)
        vet.setId(veterinarioList.size());
        veterinarioList.add(vet);
        System.out.println("Processando itens | Valor Adicionado: "+vet);
        processSelectItems();
    }

    
    public void start(){
        veterinarioList = IO_Veterinarios.readItems();
        processSelectItems();
    }
    
    public void end(){
        IO_Veterinarios.writeItems(veterinarioList);
    }
}
