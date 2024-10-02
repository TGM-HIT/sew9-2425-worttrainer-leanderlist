package at.ac.tgm.llist;

import at.ac.tgm.llist.Controller.WorttrainerController;
import at.ac.tgm.llist.Model.Persistence.JsonPersistence;

public class Main {
    public static void main(String[] args) {
        new WorttrainerController(new JsonPersistence());
    }
}
