package dao;

import java.io.Serializable;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import model.TipoAnimal;

/**
 *
 * @author andre
 */
public class TipoAnimalDAO implements Serializable {

    private static LinkedList<TipoAnimal>  tipoAnimalList = null;
    private static LinkedList<SelectItem> tipoAnimalSelectItem = null;

    public TipoAnimalDAO() {
        System.out.println("Criando TipoAnimalDAO");
        System.out.flush();

        tipoAnimalList = new LinkedList<>();
        tipoAnimalList.add(new TipoAnimal(1, "Cachorro", "Cachorros de todas as raças"));
        tipoAnimalList.add(new TipoAnimal(2, "Gato", "Gato de todas as raças"));
        tipoAnimalList.add(new TipoAnimal(3, "Aves", "Aves de todas as raças"));

        processSelectItems();

    }

    public TipoAnimal searchTipoAnimal(int id) {
        return tipoAnimalList
                .stream()
                .filter(tipo -> tipo.getId() == id)
                .findFirst()
                .get();
    }

    public void addTipoAnimal(TipoAnimal t) {
        t.setId(tipoAnimalList.size()+1);
        tipoAnimalList.add(t);
        processSelectItems();
    }

    public LinkedList<TipoAnimal> getTipoAnimalList() {
        return tipoAnimalList;
    }

    public LinkedList<SelectItem> getSelectItems() {
        processSelectItems();
        return tipoAnimalSelectItem;
    }

    public void setTipoAnimalList(LinkedList<TipoAnimal> tipos) {
        tipoAnimalList = tipos;
        processSelectItems();
    }

    private void processSelectItems() {
        System.out.println("Processando seletores");
        tipoAnimalSelectItem = new LinkedList<SelectItem>();
        tipoAnimalSelectItem.add(new SelectItem(null, "Selecione um tipo"));
        tipoAnimalList.forEach(tipoAnimal -> {
            tipoAnimalSelectItem.add(new SelectItem(tipoAnimal, tipoAnimal.getNome()));
        });
    }
    

    public void start(){
        
    }
    
    public void end(){
        
    }

}
