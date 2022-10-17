/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.TipoAnimalDAO;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import model.TipoAnimal;

/**
 *
 * @author andre
 */
@Named(value = "tipoAnimalConverter")
@ApplicationScoped
public class TipoAnimalConverter implements Converter {

    @Inject
    TipoAnimalDAO mBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try{
            int cod = Integer.parseInt(value);
            return mBean.searchTipoAnimal(cod);
        }catch(NumberFormatException e){
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
            return null;
        }
        TipoAnimal t = (TipoAnimal) value;
        return String.valueOf(t.getId());
    }
    
}
