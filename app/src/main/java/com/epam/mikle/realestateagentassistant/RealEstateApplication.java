package com.epam.mikle.realestateagentassistant;

import android.app.Application;
import android.content.Context;

public class RealEstateApplication extends Application {

    private static Context context;

    public RealEstateApplication() {
        super();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
