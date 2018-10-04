package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedWriter
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * An android activity that handles loading ans saving tweets
 * @author Aida Radu adapted from Joshua Charles Campbell
 */

public class LonelyTwitterActivity extends Activity {

    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView oldTweetsList;
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private ArrayAdapter<Tweet> adapter;
    private Button saveButton;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.save);
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

    /*    saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String text = bodyText.getText().toString();
                try {
                    ImportantTweet importantTweet1 = new ImportantTweet(text);
                    saveInFile(importantTweet1, new Date(System.currentTimeMillis()));

                }
                catch (TooLongTweetException e) {

                }


            }
        });*/
    }
	
    /**
    * Called when the activity starts
    */
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<Tweet>(this,
                R.layout.list_item, tweets);
        oldTweetsList.setAdapter(adapter);
    }

    /**
     * loads a list of tweets from a file
     */
    private void loadFromFile() {

        try {
	        FileInputStream fis = openFileInput(FILENAME);
       	        InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(isr);
		Gson gson = new Gson();
		Type listTweetType = new TypeToken<ArrayList<ImportantTweet>>(){}.getType();
		tweets = gson.fromJson(reader,listTweetType);

        }
        catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		tweets = new ArrayList<Tweet>();
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
	}
}
 
    
    /**
     * Saves a tweet to a file
     * @param  Tweet - the tweet to save
     * @param  Date -  the date of the tweet to save
     */
    private void saveInFile(Tweet tweet, Date date) {
        try {
		FileOutputStream fos = openFileOutput(FILENAME,0);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter writer = new BufferedWriter(osw);
		Gson gson = new Gson();
		gson.toJson(tweets,writer);
		writer.flush();
		fos.close()
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

/**
 * Saves a tweet
 * @param View - the view clicked
 */
 public void saveOnClick(View view) {
         String text = bodyText.getText().toString();
             ImportantTweet newTweet = new ImportantTweet();
             try {
                 newTweet.setMessage(text);
                 newTweet.setDate(new Date());
                 //saveInFile(text, new Date(System.currentTimeMillis()));
                 tweets.add(newTweet);
                 adapter.notifyDataSetChanged();
                 saveInFile();
             }
             catch (TweetTooLongException e){


             }
     }

}
