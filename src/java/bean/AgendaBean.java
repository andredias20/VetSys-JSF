package bean;

import dao.TipoAnimalDAO;
import dao.VeterinarioDAO;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import model.TipoAnimal;

/**
 *
 * @author andre
 */
@Named(value = "agendaBean")
@ApplicationScoped
public class AgendaBean implements Serializable{
    
    @Inject
    TipoAnimalDAO tiposDAO;
    
    @Inject
    VeterinarioDAO vetDAO;
    
    public AgendaBean() {  
            
    }
    
    public List<TipoAnimal> getTipos() {
        return tiposDAO.getTipoAnimalList();
    }
    
    public List<SelectItem> getSelectItemsTipoAnimal(){
        return tiposDAO.getSelectItems();
    }
    
    @Produces
    public TipoAnimalDAO instanceTipoAnimal(){
        if(tiposDAO == null)
            tiposDAO = new TipoAnimalDAO();
        
        return tiposDAO;
    }
    
    @Produces
    public VeterinarioDAO instanceVeterinario(){
        if(vetDAO == null)
            vetDAO = new VeterinarioDAO();
        return vetDAO;
    }
}
