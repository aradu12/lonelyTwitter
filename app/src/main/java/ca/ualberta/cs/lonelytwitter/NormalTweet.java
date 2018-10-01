package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class NormalTweet extends Tweet {


    @Override
    public Boolean isImportant() {
        return false;
    }
}
