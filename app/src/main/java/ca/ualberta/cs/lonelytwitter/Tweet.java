package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents a single Tweet, with a message and a list of moods
 *
 * @author      Aida Radu - adapted from Joshua Charles Campbell
 * @see         ImportantTweet, NormalTweet
 */
public abstract class Tweet {

    protected String message;
    protected Date date;
    private ArrayList<MoodModel> moods;


    /**
     * Assigns a new message to the Tweet
     *
     * @param       message - the message to be tweeted 
     * @throws      TooLongTweetException if the tweet is over 140 chars
     */


    public void setMessage(String message) throws TooLongTweetException {
        if (message.length() > 140) {
            throw new TooLongTweetException();
        }
        
        this.message = message;
    }


    /**
    * Assigns a new date to the Tweet
    * @param       date - the date to be assigned 
    */

    public void setDate(Date date) {
        this.date = date;
    }


    /**
     * Gives the current date assigned to the tweet
     * @return     Date - the tweet's date
     */

    public Date getDate() {
        return date;
    }


    /**
     * Gives the current message assigned to the tweet
     * @return     String - the tweet's message
     */

    public String getMessage() {
        return message;
    }

    public abstract Boolean isImportant();

  
    /**
     * Gives the list of moods assigned to the tweet
     * @return     ArrayList<MoodModel> - the list of different types of moods
     */

    public ArrayList<MoodModel> getMoods() {
        return moods;
    }



    /**
     * Adds a new mood to the tweet's list of moods
     * @param     mood - the new mood to add
     */

    public void addMood(MoodModel mood) {
        moods.add(mood);
    }

    /**
     * @return a text representation of the tweet
     */

    public String toString(){
    	return this.date.toString()+" | "+this.message;
}
}
