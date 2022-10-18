package bean;

import dao.TipoAnimalDAO;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 * @author andre
 */
@Named(value = "agendaBean")
@ApplicationScoped
public class AgendaBean implements Serializable {

    @Inject
    TipoAnimalDAO tiposDAO;
    
    public AgendaBean() {

    }

    public List<SelectItem> getSelectItemsTipoAnimal() {
        return tiposDAO.getSelectItems();
    }
}
