package bean;

import dao.VeterinarioDAO;
import java.io.Serializable;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import model.TipoAnimal;
import model.Veterinario;

/**
 *
 * @author andre
 */
@Named(value = "userBean")
@Dependent
public class UserBean implements Serializable {

    TipoAnimal tipoSelecionado;
    Veterinario veterinarioSelecionado;
    
    @Inject 
    VeterinarioDAO vetDAO;
    
    LinkedList<SelectItem> veterinarioSelectItems;
    
    public UserBean() {
    }
    
    @PostConstruct
    public void post(){
        veterinarioSelectItems.add(
                new SelectItem(
                        null, 
                        "Selecione um tipo de Animal"
                ));
    }

    public TipoAnimal getTipoSelecionado() {
        return tipoSelecionado;
    }

    public void setTipoSelecionado(TipoAnimal tipoSelecionado) {
        this.tipoSelecionado = tipoSelecionado;
    }

    public Veterinario getVeterinarioSelecionado() {
        return veterinarioSelecionado;
    }

    public void setVeterinarioSelecionado(Veterinario veterinarioSelecionado) {
        this.veterinarioSelecionado = veterinarioSelecionado;
    }

    public LinkedList<SelectItem> getVeterinarioSelectItems() {
        return veterinarioSelectItems;
    }

    public void setVeterinarioSelectItems(LinkedList<SelectItem> veterinarioSelectItems) {
        this.veterinarioSelectItems = veterinarioSelectItems;
    }
    
    
    
    public void updateVeterinarios(){
        if(tipoSelecionado != null){
            veterinarioSelectItems = vetDAO.getSelectItems(tipoSelecionado.getId());
        }
    }
    
}
