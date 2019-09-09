package com.antipov.singleactivity.utils.util;

import android.app.Activity;
import com.antipov.singleactivity.di.scopes.PerActivity;

import javax.inject.Inject;

/**
 * Utility class that is provided using PerActivity scope in order to test this scope.
 */
@PerActivity
public final class PerActivityUtil {

    private final Activity activity;

    @Inject
    PerActivityUtil(Activity activity) {
        this.activity = activity;
    }

    public String doSomething() {
        return "PerActivityUtil: " + hashCode() + ", Activity: " + activity.hashCode();
    }
}
