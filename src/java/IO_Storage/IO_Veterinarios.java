package IO_Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import model.Veterinario;

/**
 *
 * @author andre.dias
 */
public class IO_Veterinarios {

    private static final File file = new File("Veterinario.tmp");

    public static LinkedList<Veterinario> readItems() {
        LinkedList<Veterinario> lista = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
                LinkedList<Veterinario> list = fillList();
                flushNewList(list);
                return list;
            }
            FileInputStream fis = new FileInputStream(file);

            ObjectInputStream ois = new ObjectInputStream(fis);

            lista = (LinkedList<Veterinario>) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static void writeItems(List<Veterinario> list) {
        flushNewList(list);
    }

    private static void flushNewList(List<Veterinario> list) {
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

    private static LinkedList<Veterinario> fillList() {
        LinkedList<Veterinario> veterinarioList = new LinkedList<>();
        veterinarioList.add(new Veterinario(1, "Dr. Carlos", 1));
        veterinarioList.add(new Veterinario(2, "Dra. Vanessa", 1));
        veterinarioList.add(new Veterinario(3, "Dra. Thais", 2));
        veterinarioList.add(new Veterinario(4, "Dr. Gabriel", 2));
        return veterinarioList;
    }
}
