/**
 * Child MoodModel class representing a sad mood
 * @author Aida Radu
 */


package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Sad extends MoodModel {

    public Sad(Date date_in) {
        super(date_in);
    }

    public Sad() {
        super();
    }

    /** 
     * @return a string representation of the mood */
    @Override
    public String getMood() {
        return "I am Sad";
    }
}
