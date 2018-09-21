package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class ImportantTweet extends Tweet {

    public ImportantTweet(String message, Date date) throws TooLongTweetException{
        super(message,date);
    }

    public ImportantTweet(String message) throws TooLongTweetException {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return true;
    }
}
