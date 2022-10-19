package bean;

import dao.AgendamentoDAO;
import dao.TipoAnimalDAO;
import dao.VeterinarioDAO;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import model.Agendamento;
import model.TipoAnimal;
import model.Veterinario;

/**
 *
 * @author andre
 */
@Named(value = "agendaBean")
@ApplicationScoped
public class AgendaBean implements Serializable {

    @Inject
    TipoAnimalDAO tiposDAO;
    
    @Inject
    VeterinarioDAO vetDAO;
    
    @Inject
    AgendamentoDAO agendaDAO;
    
    LinkedList<Agendamento> listAgendamento = null;
    
    public AgendaBean() {}

    public List<SelectItem> getSelectItemsTipoAnimal() {
        return tiposDAO.getSelectItems();
    }

    public LinkedList<Agendamento> getListAgendamento() {
        return listAgendamento;
    }
    
    public Veterinario getVeterinarioById(int id){
        return vetDAO.searchVeterinario(id);
    }
    
    public TipoAnimal getTipoAnimalById(int id){
        return tiposDAO.searchTipoAnimal(id);
    }

    public void setListAgendamento(LinkedList<Agendamento> listAgendamento) {
        this.listAgendamento = listAgendamento;
    }
    
    @PostConstruct
    public void postInstance(){
        listAgendamento = agendaDAO.getAll();
    }
    
}
