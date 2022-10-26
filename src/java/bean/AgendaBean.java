package bean;

import dao.AgendamentoDAO;
import dao.TipoAnimalDAO;
import dao.VeterinarioDAO;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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
    
    public static LinkedList<Agendamento> listAgendamento = null;
    
    public AgendaBean() {}

    public List<SelectItem> getSelectItemsTipoAnimal() {
        return tiposDAO.getSelectItems();
    }

    public LinkedList<Agendamento> getListAgendamento() {
        listAgendamento = agendaDAO.getAll();
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
    
    @Produces
    VeterinarioDAO instanceVeterinario() {
        if (vetDAO == null) {
            vetDAO = new VeterinarioDAO();
        }
        return vetDAO;
    }

    @Produces
    TipoAnimalDAO instanceTipoAnimal() {
        if (tiposDAO == null) {
            tiposDAO = new TipoAnimalDAO();
        }

        return tiposDAO;
    }

    @Produces
    AgendamentoDAO instanceAgendamentoDAO() {
        if (agendaDAO == null) {
            agendaDAO = new AgendamentoDAO();
        }

        return agendaDAO;
    }
    
    @PostConstruct
    public void postInstance(){
        tiposDAO.start();
        vetDAO.start();
        agendaDAO.start();
    }
    
    @PreDestroy
    public void preDestroy(){
        tiposDAO.end();
        vetDAO.end();
        agendaDAO.end();
    }
    
}
