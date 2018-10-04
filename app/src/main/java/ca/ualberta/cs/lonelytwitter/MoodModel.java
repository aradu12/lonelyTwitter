package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Base class representing the current mood
 * 
 * @author Aida Radu
 * @see Happy, Sad
 */
public abstract class MoodModel {
    protected Date date;

    /**
     * Constructor that creates a new mood model
     *
     * @param 	Date - the date to init the mood with
     */
    public MoodModel(Date date_in) {
        this.date = date_in;
    }

    /**
     * Constructor with default date creation
     */
    public MoodModel() {
        this.date = new Date();
    }

    /** 
     * @return 	date the date currently assigned to the mood
     */

    public Date getDate() {
        return this.date;
    }


    /**
     * Assigns a new date to the mood
     * @param 	Date - the new date to assign
     */
    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String getMood();
}
