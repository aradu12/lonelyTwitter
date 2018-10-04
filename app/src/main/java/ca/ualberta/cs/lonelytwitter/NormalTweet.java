package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/** A class representing a normal, non- important tweet
 *  @author Aida Radu
 */

public class NormalTweet extends Tweet {

    /** @return false - the tweet is mot important*/
    @Override
    public Boolean isImportant() {
        return false;
    }
}
