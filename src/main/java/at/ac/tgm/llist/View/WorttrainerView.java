package at.ac.tgm.llist.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

import at.ac.tgm.llist.Model.WordPicturePair;

public class WorttrainerView extends JFrame {

    private int correctCount = 0;
    private JLabel correctCountLabel = new JLabel("Correct: " + this.correctCount);
    private int wrongCount = 0;
    private JLabel wrongCountLabel = new JLabel("Wrong: " + this.wrongCount);
    private int totalCount = 0;
    private JLabel totalCountLabel = new JLabel("Total: " + this.totalCount);
    private JLabel lastWord = new JLabel("Last: Incorrect");
    private ImageIcon image = new ImageIcon();
    private JTextField inputField = new JTextField();


    public WorttrainerView() {
        super("Worttrainer");
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

        JLabel imageLabel = new JLabel(this.image); //TODO add image
        mainPanel.add(imageLabel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        JLabel inputLabel = new JLabel("Input:");
        this.inputField.setPreferredSize(new Dimension(200, 20));

        bottomPanel.add(inputLabel);
        bottomPanel.add(this.inputField);

        this.add(bottomPanel, BorderLayout.SOUTH);



        this.pack();
        this.setVisible(true);
    }

    public void setCorrectCount(int correctCount) {
        if (correctCount < 0) {
            throw new IllegalArgumentException("Correct count must be greater or equal to 0");
        }
        this.correctCount = correctCount;
        this.correctCountLabel.setText("Correct: " + this.correctCount);
    }

    public int getCorrectCount() {
        return this.correctCount;
    }

    public void setWrongCount(int wrongCount) {
        if (wrongCount < 0) {
            throw new IllegalArgumentException("Wrong count must be greater or equal to 0");
        }
        this.wrongCount = wrongCount;
        this.wrongCountLabel.setText("Wrong: " + this.wrongCount);
    }

    public int getWrongCount() {
        return this.wrongCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount < 0) {
            throw new IllegalArgumentException("Total count must be greater or equal to 0");
        }
        this.totalCount = totalCount;
        this.totalCountLabel.setText("Total: " + this.totalCount);
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setLastWord(boolean isCorrect) {
        if(isCorrect)
            this.lastWord.setText("Last: Correct");
        else
            this.lastWord.setText("Last: Incorrect");
    }

    public void setImage(String url) {
        if(url != null && !url.isEmpty() && WordPicturePair.checkUrl(url)) {
            try {
                this.image.setImage(ImageIO.read(new URL(url)));
            } catch (Exception ignored) {}
        }
    }

    public String getInput() {
        String text = this.inputField.getText();
        this.inputField.setText("");
        return text;
    }

    public static void main(String[] args) {
        WorttrainerView wtv = new WorttrainerView();
        wtv.setImage("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");

    }
}
