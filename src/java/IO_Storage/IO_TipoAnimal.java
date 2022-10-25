package IO_Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import model.TipoAnimal;

/**
 *
 * @author andre.dias
 */
public class IO_TipoAnimal {
    
    private static final File file = new File("TipoAnimal.tmp");

    public static LinkedList<TipoAnimal> readItems() {
        LinkedList<TipoAnimal> lista = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
                LinkedList<TipoAnimal> list = fillList();
                flushNewList(list);
                return list;
            }
            FileInputStream fis = new FileInputStream(file);

            ObjectInputStream ois = new ObjectInputStream(fis);

            lista = (LinkedList<TipoAnimal>) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static void writeItems(List<TipoAnimal> list) {
        flushNewList(list);
    }

    private static void flushNewList(List<TipoAnimal> list) {
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

    private static LinkedList<TipoAnimal> fillList() {
        LinkedList<TipoAnimal> AnimalList = new LinkedList<>();
        
        AnimalList.add(new TipoAnimal(1,"Cachorro", "Cachorros de todas as raças"));
        AnimalList.add(new TipoAnimal(2,"Gato", "Gato de todas as raças"));
        AnimalList.add(new TipoAnimal(3,"Aves", "Aves de todas as raças"));
        
        return AnimalList;
    }
}
