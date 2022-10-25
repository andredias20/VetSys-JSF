/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author alice
 */
@Named("agendamentoDateValidator")
@Dependent
public class DateValitador implements Validator {

    List<Integer> daysOfWeek = List.of(
            Calendar.TUESDAY,
            Calendar.WEDNESDAY,
            Calendar.THURSDAY
    );

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        var date = (Date) value;
        Calendar time = Calendar.getInstance();
        time.setTime(date);

        int getWeek = time.get(Calendar.DAY_OF_WEEK);
        int hour = time.get(Calendar.HOUR);
        int minute = time.get(Calendar.MINUTE);
        boolean inTime = false;

        var week = daysOfWeek.stream()
                .filter(a -> a == getWeek)
                .findAny();

        if ((hour >= 8 && minute >= 0) && (hour <= 17 && minute <= 45)) {
            inTime = true;
        }

        if (week.isEmpty() || !inTime) {
            throw new ValidatorException(new FacesMessage("O dia da semana não é válido!\n São aceitos somente Terça, Quata e Quinta das 08:00 as 17:45"));
        }

    }

}
