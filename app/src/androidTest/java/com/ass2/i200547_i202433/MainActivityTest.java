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
public class MainActivityTest {

    // Specify the activity to be launched before the test and allow it to be finished after the test
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testLoginSuccess() {
        // Input valid username and password
        Espresso.onView(ViewMatchers.withId(R.id.f)).perform(ViewActions.typeText("your_username"));
        Espresso.onView(ViewMatchers.withId(R.id.sx)).perform(ViewActions.typeText("your_password"));

        // Close the soft keyboard
        Espresso.closeSoftKeyboard();

        // Perform a click action on the login button
        Espresso.onView(ViewMatchers.withId(R.id.nin)).perform(ViewActions.click());
    }

    @Test
    public void testLoginFailure() {
        // Input invalid username and password
        Espresso.onView(ViewMatchers.withId(R.id.e1)).perform(ViewActions.typeText("invalid_username"));
        Espresso.onView(ViewMatchers.withId(R.id.e2)).perform(ViewActions.typeText("invalid_password"));

        // Close the soft keyboard
        Espresso.closeSoftKeyboard();

        // Perform a click action on the login button
        Espresso.onView(ViewMatchers.withId(R.id.nin)).perform(ViewActions.click());
    }
}

