package bean;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import model.TipoAnimal;

/**
 *
 * @author andre
 */
@Named(value = "userBean")
@Dependent
public class UserBean implements Serializable {

    TipoAnimal tipoSelecionado;
    
    public UserBean() {
    }

    public TipoAnimal getTipoSelecionado() {
        return tipoSelecionado;
    }

    public void setTipoSelecionado(TipoAnimal tipoSelecionado) {
        this.tipoSelecionado = tipoSelecionado;
    }
    
}
