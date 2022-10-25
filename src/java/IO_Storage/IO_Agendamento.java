package IO_Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import model.Agendamento;
import model.Paciente;

/**
 *
 * @author andre.dias
 */
public class IO_Agendamento {

    private static final File file = new File("Agendamento.tmp");

    public static LinkedList<Agendamento> readItems() {
        LinkedList<Agendamento> lista = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
                LinkedList<Agendamento> list = fillList();
                flushNewList(list);
                return list;
            }
            FileInputStream fis = new FileInputStream(file);

            ObjectInputStream ois = new ObjectInputStream(fis);

            lista = (LinkedList<Agendamento>) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static void writeItems(List<Agendamento> list) {
        flushNewList(list);
    }

    private static void flushNewList(List<Agendamento> list) {
        try {
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(out);

            oos.writeObject(list);

            oos.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static LinkedList<Agendamento> fillList() {
        LinkedList<Agendamento> agendamentos = new LinkedList<>();
        agendamentos.add(new Agendamento(
                1, 
                1, 
                1, 
                new Date(),
                new Paciente(1, "Animalzinho Name", "Motivação Descrição", "Tutor Name", "(45) 9 9999-9999")));
        return agendamentos;
    }
}
