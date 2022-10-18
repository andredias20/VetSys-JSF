/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package converter;

import dao.VeterinarioDAO;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import model.Veterinario;

/**
 *
 * @author andre
 */
@Named(value = "veterinarioConverter")
@ApplicationScoped
public class VeterinarioConverter implements Converter {

    @Inject
    VeterinarioDAO vetDAO;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            int cod = Integer.parseInt(value);
            return vetDAO.searchVeterinario(cod);
        } catch (NumberFormatException e) {
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        Veterinario t = (Veterinario) value;
        return String.valueOf(t.getId());
    }

}
