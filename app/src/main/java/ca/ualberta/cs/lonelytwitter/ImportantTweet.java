package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/** A class representing an important tweet
 *  @author Aida Radu
 */

public class ImportantTweet extends Tweet {

    /** @return true - the tweet is important */
    @Override
    public Boolean isImportant() {
        return true;
    }
}
