package at.ac.tgm.llist;

import at.ac.tgm.llist.Controller.WorttrainerController;
import at.ac.tgm.llist.Model.Persistence.JsonPersistence;

/**
 * @author Leander-List
 * @version 02-10-2024
 * Main class to start the application
 */
public class Main {
    /**
     * Main method to start the application
     * @param args the arguments
     */
    public static void main(String[] args) {
        new WorttrainerController(new JsonPersistence());
    }
}
