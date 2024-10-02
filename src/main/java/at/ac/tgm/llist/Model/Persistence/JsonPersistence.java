package at.ac.tgm.llist.Model.Persistence;

import at.ac.tgm.llist.Model.Worttrainer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

/**
 * @author Leander-List
 * @version 01-10-2024
 * This class is responsible for saving and loading the Worttrainer object as a JSON file
 */
public class JsonPersistence implements Persistence {

    /**
     * Saves the Worttrainer object as a JSON file
     * @param wt the Worttrainer object to save
     * @param path the path to save the file
     */
    @Override
    public void save(Worttrainer wt, String path) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String wtAsJson = gson.toJson(wt);

        try (OutputStream out = new FileOutputStream(path)) {
            out.write(wtAsJson.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the Worttrainer object from a JSON file
     * @param path the path to load the file
     * @return the loaded Worttrainer object
     */
    @Override
    public Worttrainer load(String path) {
        Gson gson = new GsonBuilder().create();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return gson.fromJson(reader, Worttrainer.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
