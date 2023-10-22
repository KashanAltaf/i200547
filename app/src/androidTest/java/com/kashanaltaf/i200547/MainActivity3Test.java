package com.kashanaltaf.i200547;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivity3Test {

    // Specify the activity to be launched before the test and allow it to be finished after the test
    @Rule
    public ActivityScenarioRule<MainActivity3> activityRule = new ActivityScenarioRule<>(MainActivity3.class);

    @Test
    public void testSignUpSuccess() {
        // Input valid sign-up information
        Espresso.onView(ViewMatchers.withId(R.id.txtName)).perform(ViewActions.typeText("name"));
        Espresso.onView(ViewMatchers.withId(R.id.txtEmail)).perform(ViewActions.typeText("email"));
        Espresso.onView(ViewMatchers.withId(R.id.txtNum)).perform(ViewActions.typeText("password"));
        Espresso.onView(ViewMatchers.withId(R.id.txtCtry)).perform(ViewActions.typeText("country"));
        Espresso.onView(ViewMatchers.withId(R.id.txtCty)).perform(ViewActions.typeText("city"));


        // Close the soft keyboard
        Espresso.closeSoftKeyboard();

        // Perform a click action on the sign-up button
        Espresso.onView(ViewMatchers.withId(R.id.but1)).perform(ViewActions.click());

    }

    @Test
    public void testSignUpFailure() {
        // Input invalid sign-up information
        Espresso.onView(ViewMatchers.withId(R.id.txtName)).perform(ViewActions.typeText("name"));
        Espresso.onView(ViewMatchers.withId(R.id.txtEmail)).perform(ViewActions.typeText("email"));
        Espresso.onView(ViewMatchers.withId(R.id.txtNum)).perform(ViewActions.typeText("password"));
        Espresso.onView(ViewMatchers.withId(R.id.txtCtry)).perform(ViewActions.typeText("country"));
        Espresso.onView(ViewMatchers.withId(R.id.txtCty)).perform(ViewActions.typeText("city"));

        // Close the soft keyboard
        Espresso.closeSoftKeyboard();

        // Perform a click action on the sign-up button
        Espresso.onView(ViewMatchers.withId(R.id.but1)).perform(ViewActions.click());
    }
}
