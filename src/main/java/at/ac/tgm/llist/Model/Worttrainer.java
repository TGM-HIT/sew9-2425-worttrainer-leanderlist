package at.ac.tgm.llist.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Worttrainer {
    private List<WordPicturePair> pairList;
    private int currentPairIndex;
    private int correctCount = 0;
    private int wrongCount = 0;
    private int answerCount = 0;

    public Worttrainer() {
        this.pairList = new ArrayList<>(Arrays.asList(
                new WordPicturePair("https://img.freepik.com/fotos-premium/ein-baum-mit-einem-gruenen-stamm-und-den-wurzeln_889779-1050.jpg", "Baum"),
                new WordPicturePair("https://media.istockphoto.com/id/136754725/de/foto/rote-gerbera-auf-einem-gebeugt-st%C3%A4ngel.jpg?s=612x612&w=0&k=20&c=6V2xxt_Ia99X2EzKUKUEiyfdrb8zqbLrSYSEexzvYFU=", "Blume")
        ));
        this.selectRandomPair();
    }

    public void selectPair(int index) {
        if (index < 0 || index >= this.pairList.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        this.currentPairIndex = index;
    }

    public void selectRandomPair() {
        this.currentPairIndex =  (int) (Math.random() * (this.pairList.size()));
    }

    public boolean checkAnswer(String answer) {
        return this.pairList.get(currentPairIndex).getWord().equals(answer);
    }

    public int getCorrectCount() {
        return this.correctCount;
    }

    public int getWrongCount() {
        return this.wrongCount;
    }

    public int getAnswerCount() {
        return this.answerCount;
    }

    public int getSelectedPair() {
        return this.currentPairIndex;
    }

    public void setCorrectCount(int count) {
        if(count < 0)
            throw new IllegalArgumentException("Negative Count is not possible");
        this.correctCount = count;
    }

    public void setWrongCount(int count) {
        if(count < 0)
            throw new IllegalArgumentException("Negative Count is not possible");
        this.wrongCount = count;
    }

    public void setAnswerCount(int count) {
        if(count < 0)
            throw new IllegalArgumentException("Negative Count is not possible");
        this.answerCount = count;
    }

    public void setPairList(List<WordPicturePair> list) {
        if(list == null)
            throw new IllegalArgumentException("List is null");
        this.pairList = list;
    }
}
