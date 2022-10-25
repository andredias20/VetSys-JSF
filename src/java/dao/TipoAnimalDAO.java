package dao;

import IO_Storage.IO_TipoAnimal;
import java.io.Serializable;
import java.util.LinkedList;
import javax.faces.model.SelectItem;
import model.TipoAnimal;

/**
 *
 * @author andre
 */
public final class TipoAnimalDAO implements Serializable {

    private static LinkedList<TipoAnimal> tipoAnimalList = null;
    private static LinkedList<SelectItem> tipoAnimalSelectItem = null;

    public TipoAnimalDAO() {
        System.out.println("Criando TipoAnimalDAO");

        

    }

    public TipoAnimal searchTipoAnimal(int id) {
        return tipoAnimalList
                .stream()
                .filter(tipo -> tipo.getId() == id)
                .findFirst()
                .get();
    }

    public void addTipoAnimal(TipoAnimal t) {
        t.setId(tipoAnimalList.size() + 1);
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

    public void start() {
        tipoAnimalList = IO_TipoAnimal.readItems();
        processSelectItems();
    }

    public void end() {
        IO_TipoAnimal.writeItems(tipoAnimalList);
    }

}
