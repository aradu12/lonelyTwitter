package ca.ualberta.cs.lonelytwitter;
import com.robotium.solo.Solo;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import junit.framework.TestCase;


public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {


    private Solo solo;
    public LonelyTwitterActivityTest() {
        super(LonelyTwitterActivity.class);
    }

    @Override
    public void setUp(){
        solo = new Solo(getInstrumentation(),getActivity());

    }

    @Override public void tearDown(){
        solo.finishOpenedActivities();
    }

    public void testTweet(){
        solo.assertCurrentActivity("wrong activity","LonelyTwitterActivity");
    }

    public void testEquals(){
        assertEquals("not equal","4","5");
    }

    public void testAddTweet(){
        solo.enterText((EditText) solo.getView(R.id.body),"DEF");

        solo.clickOnButton("Save");
        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue(solo.waitForText("DEF"));
    }

}