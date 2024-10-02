package at.ac.tgm.llist.Controller;

import at.ac.tgm.llist.Model.Persistence.JsonPersistence;
import at.ac.tgm.llist.Model.Persistence.Persistence;
import at.ac.tgm.llist.Model.Worttrainer;
import at.ac.tgm.llist.View.WorttrainerView;

import javax.swing.*;

/**
 * @author Leander-List
 * @version 02-10-2024
 * This class is responsible for the communication between the model and the view
 */
public class WorttrainerController {
    private WorttrainerView view;
    private Worttrainer model;
    private Persistence persistence;

    /**
     * Constructor for the WorttrainerController
     */
    public WorttrainerController() {
        this.persistence = new JsonPersistence();
        this.model = new Worttrainer();
        this.view = new WorttrainerView(this);
    }

    /**
     * Constructor for the WorttrainerController
     * @param persistence the persistence object to use
     */
    public WorttrainerController(Persistence persistence) {
        if(persistence == null) {
            throw new IllegalArgumentException("Persistence must not be null");
        }

        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(null);
        String path = null;
        if(choice == JFileChooser.APPROVE_OPTION) {
            path = fileChooser.getSelectedFile().getAbsolutePath();
        } else if(choice == JFileChooser.CANCEL_OPTION) {
            this.model = new Worttrainer();
        }
        if(path != null) {
            try {
                this.model = this.persistence.load(path);
            } catch (Exception e) {
                this.model = new Worttrainer();
            }
        }
        this.persistence = persistence;
        try {
            this.model = this.persistence.load(path);
        } catch (Exception e) {
            this.model = new Worttrainer();
        }
        this.view = new WorttrainerView(this);
        this.view.setImage(this.model.getPairList().get(this.model.getSelectedPair()).getUrl());
    }

    /**
     * Saves the model to a file
     * @param path the path to save the file
     */
    public void save(String path) {
        try {
            this.persistence.save(this.model, path);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error saving file");
        }
    }

    /**
     * Checks the input and updates the view
     * @param input the input to check
     */
    public void check(String input) {
        if(this.model.checkAnswer(input)) {
            this.view.setCorrectCount(this.model.getCorrectCount());
            this.view.setLastWord(true);
            this.view.setImage(this.model.getPairList().get(this.model.getSelectedPair()).getUrl());
        } else {
            this.view.setWrongCount(this.model.getWrongCount());
            this.view.setLastWord(false);
        }
        this.view.setTotalCount(this.model.getAnswerCount());
    }
}
