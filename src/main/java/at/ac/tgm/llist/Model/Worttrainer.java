package at.ac.tgm.llist.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Leander-List
 * @version 30-09-2024
 * This class represents a trainer for words and pictures.
 */

public class Worttrainer {
    private List<WordPicturePair> pairList;
    private int currentPairIndex;
    private int correctCount = 0;
    private int wrongCount = 0;
    private int answerCount = 0;

    /*
     * Constructor for Worttrainer
     */
    public Worttrainer() {
        this.pairList = new ArrayList<>(Arrays.asList(
                new WordPicturePair("https://img.freepik.com/fotos-premium/ein-baum-mit-einem-gruenen-stamm-und-den-wurzeln_889779-1050.jpg", "Baum"),
                new WordPicturePair("https://media.istockphoto.com/id/136754725/de/foto/rote-gerbera-auf-einem-gebeugt-st%C3%A4ngel.jpg?s=612x612&w=0&k=20&c=6V2xxt_Ia99X2EzKUKUEiyfdrb8zqbLrSYSEexzvYFU=", "Blume")
        ));
        this.selectRandomPair();
    }

    /*
     * Selects a pair by index
     */
    public void selectPair(int index) {
        if (index < 0 || index >= this.pairList.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        this.currentPairIndex = index;
    }

    /*
     * Selects a random pair
     */
    public void selectRandomPair() {
        this.currentPairIndex =  (int) (Math.random() * (this.pairList.size()));
    }

    /*
     * Checks if the answer is correct
     */
    public boolean checkAnswer(String answer) {
        this.answerCount++;
        boolean isCorrect = this.pairList.get(currentPairIndex).getWord().equals(answer);
        if (isCorrect) {
            this.correctCount++;
            this.selectRandomPair();
            return true;
        } else {
            this.wrongCount++;
            return false;
        }
    }

    /*
     * Getter for correctCount
     */
    public int getCorrectCount() {
        return this.correctCount;
    }

    /*
     * Getter for wrongCount
     */
    public int getWrongCount() {
        return this.wrongCount;
    }

    /*
     * Getter for answerCount
     */
    public int getAnswerCount() {
        return this.answerCount;
    }

    /*
     * Getter for currentPairIndex
     */
    public int getSelectedPair() {
        return this.currentPairIndex;
    }

    /*
     * Setter for correctCount
     */
    public void setCorrectCount(int count) {
        if(count < 0)
            throw new IllegalArgumentException("Negative Count is not possible");
        this.correctCount = count;
    }

    /*
     * Setter for wrongCount
     */
    public void setWrongCount(int count) {
        if(count < 0)
            throw new IllegalArgumentException("Negative Count is not possible");
        this.wrongCount = count;
    }

    /*
     * Setter for answerCount
     */
    public void setAnswerCount(int count) {
        if(count < 0)
            throw new IllegalArgumentException("Negative Count is not possible");
        this.answerCount = count;
    }

    /*
     * Setter for currentPairIndex
     */
    public void setPairList(List<WordPicturePair> list) {
        if(list == null)
            throw new IllegalArgumentException("List is null");
        this.pairList = list;
    }

    /*
     * Getter for pairList
     */
    public List<WordPicturePair> getPairList() {
        return this.pairList;
    }
}
