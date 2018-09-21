package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class NormalTweet extends Tweet {

    public NormalTweet(String message, Date date) throws TooLongTweetException{
        super(message,date);
    }

    public NormalTweet(String message) throws TooLongTweetException {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return false;
    }
}
