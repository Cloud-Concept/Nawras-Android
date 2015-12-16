package com.cloudconcept;

import android.content.Context;
import android.content.Intent;

import activity.AboutActivity;
import activity.CallReportsActivity;
import activity.DealersActivity;
import activity.HomeActivity;
import activity.ProductsActivity;
import activity.PromotionalItemsActivity;
import activity.SamplesActivity;
import activity.SyncActivity;


/**
 * Created by Abanoub Wagdy on 6/14/2015.
 */

/**
 * ActivitiesLauncher is class that represents laucher of any activity inside the application
 */
public class ActivitiesLauncher {

    private static Intent intent;

    public static void openHomeActivity(Context applicationContext) {
        intent = new Intent(applicationContext, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);
    }

    public static void openDealersActivity(Context applicationContext) {
        intent = new Intent(applicationContext, DealersActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);
    }

    public static void openCallReportsActivity(Context applicationContext) {
        intent = new Intent(applicationContext, CallReportsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);
    }

    public static void openProductsActivity(Context applicationContext) {
        intent = new Intent(applicationContext, ProductsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);
    }

    public static void openSamplesActivity(Context applicationContext) {
        intent = new Intent(applicationContext, SamplesActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);
    }

    public static void openPromotionalItemsActivity(Context applicationContext) {
        intent = new Intent(applicationContext, PromotionalItemsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);
    }

    public static void openSyncActivity(Context applicationContext) {
        intent = new Intent(applicationContext, SyncActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);
    }

    public static void openAboutActivity(Context applicationContext) {
        intent = new Intent(applicationContext, AboutActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);
    }
}
