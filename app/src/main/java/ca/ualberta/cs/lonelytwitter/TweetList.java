package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetList {
    private final ArrayList<Tweet> tweets = new ArrayList<Tweet>(); // lab 8 - changed to final

    private TweetList(){ // lab 8 - changed to package private

    }

    private Tweet getTweet(int index){
        return tweets.get(index);
    }
    // lab 8 - changed to package private

    private boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }
    // lab 8 - changed to package private

    private void add(Tweet tweet) {
        tweets.add(tweet);
    }
    // lab 8 - changed to package private

    private void delete(Tweet tweet) {
        tweets.remove(tweet);
    }
    // lab 8 - changed to package private
}