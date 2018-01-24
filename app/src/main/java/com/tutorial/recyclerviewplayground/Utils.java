package com.tutorial.recyclerviewplayground;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by joedsantiago on 24/01/2018.
 */

public class Utils {

    public static <A extends Activity> void hideKeyboard(final A activityReference) {
        if (activityReference != null
                && activityReference.getCurrentFocus() != null
                && activityReference.getCurrentFocus().getWindowToken() != null) {

            InputMethodManager imm = (InputMethodManager) activityReference.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activityReference.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static <A extends Activity> void showKeyboard(final A activityReference, View v) {

        InputMethodManager imm = (InputMethodManager) activityReference.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(v, InputMethodManager.SHOW_FORCED);
    }

}
