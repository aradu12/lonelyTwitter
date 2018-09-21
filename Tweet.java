package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

public abstract class Tweet {

    protected String message;
    protected Date date;
    private ArrayList<MoodModel> moods;

    public Tweet(String message,Date date) throws TooLongTweetException{
        if (message.length() > 140) {
            throw new TooLongTweetException();
        }
        this.message = message;
        this.date = date;
    }

    public Tweet(String message) throws TooLongTweetException{
        if (message.length() > 140) {
            throw new TooLongTweetException();
        }
        this.message = message;
        this.date = new Date();
    }

    public void setMessage(String message) throws TooLongTweetException {
        if (message.length() > 140) {
            throw new TooLongTweetException();
        }
        
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public abstract Boolean isImportant();

    public ArrayList<MoodModel> getMoods() {
        return moods;
    }

    public void addMood(MoodModel mood) {
        moods.add(mood);
    }
}
