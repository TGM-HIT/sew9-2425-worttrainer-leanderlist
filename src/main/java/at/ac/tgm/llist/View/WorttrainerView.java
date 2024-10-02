package at.ac.tgm.llist.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import at.ac.tgm.llist.Controller.WorttrainerController;
import at.ac.tgm.llist.Model.WordPicturePair;

/**
 * This class is responsible for the view of the Worttrainer application
 */
public class WorttrainerView extends JFrame {

    private WorttrainerController controller;

    private int correctCount = 0;
    private JLabel correctCountLabel = new JLabel("Correct: " + this.correctCount);
    private int wrongCount = 0;
    private JLabel wrongCountLabel = new JLabel("Wrong: " + this.wrongCount);
    private int totalCount = 0;
    private JLabel totalCountLabel = new JLabel("Total: " + this.totalCount);
    private JLabel lastWord = new JLabel("Last: Incorrect");
    private JLabel imageLabel = new JLabel();
    private JTextField inputField = new JTextField();


    /**
     * Constructor for the WorttrainerView
     * @param controller the controller to use
     */
    public WorttrainerView(WorttrainerController controller) {
        super("Worttrainer");
        this.setPreferredSize(new Dimension(800, 600));
        this.controller = controller;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.add(mainPanel);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,4));

        mainPanel.add(topPanel, BorderLayout.NORTH);

        this.correctCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.wrongCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.totalCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.lastWord.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(this.correctCountLabel);
        topPanel.add(this.wrongCountLabel);
        topPanel.add(this.totalCountLabel);
        topPanel.add(this.lastWord);

        this.imageLabel = new JLabel();
        this.imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(imageLabel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,3));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JButton addButton = new JButton("Add Entry");
        addButton.addActionListener(
                (listener) -> {
                    String word = JOptionPane.showInputDialog("Enter the word");
                    if(word != null && !word.isEmpty()) {
                        String url = JOptionPane.showInputDialog("Enter the url");
                        if(url != null && !url.isEmpty() && WordPicturePair.checkUrl(url)) {
                            controller.addEntry(url, word);
                        }
                    }
                }
        );

        JLabel inputLabel = new JLabel("Input:");
        this.inputField.setPreferredSize(new Dimension(200, 20));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        inputPanel.add(inputLabel);
        inputPanel.add(this.inputField);

        bottomPanel.add(addButton);
        bottomPanel.add(inputPanel);
        bottomPanel.add(new JLabel());

        this.add(bottomPanel, BorderLayout.SOUTH);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                JFileChooser fileChooser = new JFileChooser();
                int choice = fileChooser.showSaveDialog(null);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    controller.save(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        inputField.addActionListener(
                (listener) -> {
                    controller.check(inputField.getText());
                    inputField.setText("");
                }
        );


        this.pack();
        this.setVisible(true);
    }

    /**
     * Sets the correct count
     * @param correctCount the correct count
     */
    public void setCorrectCount(int correctCount) {
        if (correctCount < 0) {
            throw new IllegalArgumentException("Correct count must be greater or equal to 0");
        }
        this.correctCount = correctCount;
        this.correctCountLabel.setText("Correct: " + this.correctCount);
    }

    /**
     * Gets the correct count
     * @return the correct count
     */
    public int getCorrectCount() {
        return this.correctCount;
    }

    /**
     * Sets the wrong count
     * @param wrongCount the wrong count
     */
    public void setWrongCount(int wrongCount) {
        if (wrongCount < 0) {
            throw new IllegalArgumentException("Wrong count must be greater or equal to 0");
        }
        this.wrongCount = wrongCount;
        this.wrongCountLabel.setText("Wrong: " + this.wrongCount);
    }

    /**
     * Gets the wrong count
     * @return the wrong count
     */
    public int getWrongCount() {
        return this.wrongCount;
    }

    /**
     * Sets the total count
     * @param totalCount the total count
     */
    public void setTotalCount(int totalCount) {
        if (totalCount < 0) {
            throw new IllegalArgumentException("Total count must be greater or equal to 0");
        }
        this.totalCount = totalCount;
        this.totalCountLabel.setText("Total: " + this.totalCount);
    }

    /**
     * Gets the total count
     * @return the total count
     */
    public int getTotalCount() {
        return this.totalCount;
    }

    /**
     * Sets the last word
     * @param isCorrect if the last word was correct
     */
    public void setLastWord(boolean isCorrect) {
        if(isCorrect)
            this.lastWord.setText("Last: Correct");
        else
            this.lastWord.setText("Last: Incorrect");
    }

    /**
     * Sets the image
     * @param url the url of the image
     */
    public void setImage(String url) {
        if(url != null && !url.isEmpty() && WordPicturePair.checkUrl(url)) {
            try {
                this.imageLabel.setIcon(new ImageIcon(ImageIO.read(new URL(url))));
            } catch (Exception ignored) {}
        }
    }

    /**
     * Gets the input
     * @return the input
     */
    public String getInput() {
        String text = this.inputField.getText();
        this.inputField.setText("");
        return text;
    }
}
