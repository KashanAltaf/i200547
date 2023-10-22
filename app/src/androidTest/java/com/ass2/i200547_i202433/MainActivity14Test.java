package com.ass2.i200547_i202433;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivity14Test {

    // Specify the activity to be launched before the test and allow it to be finished after the test
    @Rule
    public ActivityScenarioRule<MainActivity14> activityRule = new ActivityScenarioRule<>(MainActivity14.class);

    @Test
    public void testSubmitFeedback() {
        // Input feedback text
        Espresso.onView(ViewMatchers.withId(R.id.e2)).perform(ViewActions.typeText("give_feedback"));

        // Close the soft keyboard
        Espresso.closeSoftKeyboard();

        // Perform a click action on the submit button
        Espresso.onView(ViewMatchers.withId(R.id.e3)).perform(ViewActions.click());
    }
}
