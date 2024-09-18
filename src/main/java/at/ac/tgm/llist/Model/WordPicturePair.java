package at.ac.tgm.llist.Model;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author Leander-List
 * @version 18-09-2024
 * This class represents a pair of a word and a picture.
 */

public class WordPicturePair {
    private String url;
    private String word;

    /**
    * Constructor for WordPicturePair
    * @param url the URL of the picture
     * @param word the word
     **/
    WordPicturePair(String url, String word) {
        if(word == null || word.isEmpty())
            throw new IllegalArgumentException("word is empty or null");
        if(url == null || !checkUrl(url))
            throw new IllegalArgumentException("Invalid URL");
        this.url = url;
        this.word = word;

    }

    /**
     * Checks if the URL is valid
     * @param url the URL to check
     * @return true if the URL is valid, false otherwise
     */
    public static boolean checkUrl(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }

    /**
     * Getter for url
     * @return the url of the picture
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Getter for word
     * @return the word
     */
    public String getWord() {
        return this.word;
    }

    /**
     * Setter for word
     * @param word the word to set
     */
    public void setWord(String word) {
        if(word == null || word.isEmpty())
            throw new IllegalArgumentException("word is empty or null");
        this.word = word;
    }

    /**
     * Setter for url
     * @param url the url to set
     */
    public void setUrl(String url) {
        if(url == null || !checkUrl(url))
            throw new IllegalArgumentException("Invalid URL");
        this.url = url;
    }

}
