package dao;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.inject.Model;
import javax.faces.model.SelectItem;
import model.Veterinario;

/**
 *
 * @author andre
 */

public class VeterinarioDAO implements Serializable {

    private static LinkedList<Veterinario> veterinarioList = null;
    private static LinkedList<SelectItem> veterinarioSelectItems = null;

    public VeterinarioDAO() {
        System.out.println("Criando VeterinarioDAO");
        System.out.flush();

        veterinarioList = new LinkedList<Veterinario>();
        veterinarioList.add(new Veterinario(1, "Dr. Carlos", 1));
        veterinarioList.add(new Veterinario(2, "Dra. Vanessa", 1));
        veterinarioList.add(new Veterinario(3, "Dra. Thais", 2));
        veterinarioList.add(new Veterinario(4, "Dr. Gabriel", 2));

        processSelectItems();
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
                .filter(vet -> vet.getId() == id)
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
        vet.setId(veterinarioList.size()+1);
        veterinarioList.add(vet);
        processSelectItems();
    }

    
    public void start(){
        
    }
    
    public void end(){
        
    }
}
