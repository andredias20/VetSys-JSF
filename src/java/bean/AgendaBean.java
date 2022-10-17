package bean;

import dao.TipoAnimalDAO;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 *
 * @author andre
 */
@Named(value = "agendaBean")
@ApplicationScoped
public class AgendaBean implements Serializable{
    
    @Inject
    TipoAnimalDAO tiposDAO;
    
    public AgendaBean() {  
            
    }
    
    public TipoAnimalDAO getTipos() {
        return tiposDAO;
    }
    
    @Produces
    public TipoAnimalDAO instanceTipoAnimal(){
        if(tiposDAO == null){
            tiposDAO = new TipoAnimalDAO();
        }
        return tiposDAO;
    }
}
