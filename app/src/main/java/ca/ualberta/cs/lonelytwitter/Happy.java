/**
 * Child MoodModel class representing a happy mood 
 * @author Aida Radu
*/

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Happy extends MoodModel {

    public Happy(Date date_in) {
        super(date_in);
    }

    public Happy() {
        super();
    }

    /**
     * @return a string representation of the mood */
    @Override
    public String getMood() {
        return "I am Happy";
    }
}
