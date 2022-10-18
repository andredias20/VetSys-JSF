package bean;

import dao.TipoAnimalDAO;
import dao.VeterinarioDAO;
import java.io.Serializable;
import java.util.LinkedList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import model.TipoAnimal;
import model.Veterinario;

/**
 *
 * @author andre
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    TipoAnimal tipoSelecionado;
    Veterinario veterinarioSelecionado;

    @Inject
    TipoAnimalDAO tiposDAO;
    
    @Inject
    VeterinarioDAO vetDAO;

    LinkedList<SelectItem> veterinarioSelectItems;

    public UserBean() {
    }

    public TipoAnimal getTipoSelecionado() {
        return tipoSelecionado;
    }

    public void setTipoSelecionado(TipoAnimal tipoSelecionado) {
        System.out.println("Setou o valor TipoAnimal");
        this.tipoSelecionado = tipoSelecionado;
    }

    public Veterinario getVeterinarioSelecionado() {
        return veterinarioSelecionado;
    }

    public void setVeterinarioSelecionado(Veterinario veterinarioSelecionado) {
        this.veterinarioSelecionado = veterinarioSelecionado;
    }

    public LinkedList<SelectItem> getVeterinarioSelectItems() {
        System.out.println("Puxou o valor do SelectItems");
        if (tipoSelecionado == null) {
            veterinarioSelectItems = new LinkedList<>();
            veterinarioSelectItems.add(
                    new SelectItem(
                            null,
                            "Selecione um tipo de Animal"
                    ));
            return veterinarioSelectItems;
        }

        return veterinarioSelectItems
                = vetDAO.getSelectItems(
                        tipoSelecionado.getId());
    }

    public void setVeterinarioSelectItems(LinkedList<SelectItem> veterinarioSelectItems) {
        this.veterinarioSelectItems = veterinarioSelectItems;
    }

    @Produces
    public VeterinarioDAO instanceVeterinario() {
        if (vetDAO == null) {
            vetDAO = new VeterinarioDAO();
        }
        return vetDAO;
    }
    
    @Produces
    public TipoAnimalDAO instanceTipoAnimal() {
        if (tiposDAO == null) {
            tiposDAO = new TipoAnimalDAO();
        }

        return tiposDAO;
    }

}
