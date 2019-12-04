package com.example.myunittesting;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)

public class MainActivityEspressoTest {

    private String dummyVolume = "504.0";
    private String dummyCircumference = "2016.0";
    private String dummySurfaceArea = "396.0";
    private String dummyLength = "12.0";
    private String dummyWidth = "7.0";
    private String dummyHeight = "6.0";
    private String emptyInput = "";
    private String fieldEmpty = "Field ini tidak boleh kosong";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void getCircumference() {
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        onView(withId(R.id.btn_calculate_circumference)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_calculate_circumference)).perform(click());
        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummyCircumference)));
    }

    @Test
    public void getSurfaceArea() {
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        onView(withId(R.id.btn_calculate_surface_area)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_calculate_surface_area)).perform(click());
        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummySurfaceArea)));
    }

    @Test
    public void getVolume() {
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        onView(withId(R.id.btn_calculate_volume)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_calculate_volume)).perform(click());
        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummyVolume)));
    }

    @Test
    public void emptyInput() {
        onView(withId(R.id.edt_length)).perform(typeText(emptyInput), closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        onView(withId(R.id.edt_length)).check(matches(hasErrorText(fieldEmpty)));
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.edt_width)).perform(typeText(emptyInput), closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        onView(withId(R.id.edt_width)).check(matches(hasErrorText(fieldEmpty)));
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.edt_height)).perform(typeText(emptyInput), closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        onView(withId(R.id.edt_height)).check(matches(hasErrorText(fieldEmpty)));
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
    }
}