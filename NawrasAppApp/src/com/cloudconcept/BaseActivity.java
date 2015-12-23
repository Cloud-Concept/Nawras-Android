package com.cloudconcept;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.ui.sfnative.SalesforceActivity;

import java.util.ArrayList;

import activity.AboutActivity;
import activity.CallReportsActivity;
import activity.DealersActivity;
import activity.HomeActivity;
import activity.ProductsActivity;
import activity.PromotionalItemsActivity;
import activity.SamplesActivity;
import activity.SyncActivity;
import adapter.NavDrawerListAdapter;
import custom.BadgeButton;
import model.NavDrawerItem;
import utilities.ExceptionHandler;
import utilities.LayoutResource;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 6/22/2015.
 */

public abstract class BaseActivity extends SalesforceActivity {

    public FragmentManager fragmentManager;
    public ImageView imageMenu, imageAdd, imageBack;
    BadgeButton imageCalendar;
    public Button btnMenuTransparent;
    public TextView tvTitle;
    public DrawerLayout drawerLayout;
    public static RestClient client;
    Activity activity;

//    private View.OnClickListener listenerOk1 = new View.OnClickListener() {
//
//        @Override
//        public void onClick(View v) {
//            SmartSyncSDKManager.getInstance().logout(BaseActivity.this);
//        }
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        setContentView(LayoutResource.getBaseLayout());
        InitializeViews();
    }

    private void InitializeViews() {
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        imageCalendar = (BadgeButton) findViewById(R.id.imageCalendar);
        imageAdd = (ImageView) findViewById(R.id.imageAdd);
        imageBack = (ImageView) findViewById(R.id.imageBack);

        imageCalendar.setBadgeDrawable(getResources().getDrawable(
                R.mipmap.notification_image3));

        imageCalendar.setBadgeText("3" + "");
        imageCalendar.showBadge();



//        btnLogout = (Button) findViewById(R.id.btnLogout);
//        btnLogout.setOnClickListener(listenerOk1);
        activity = this;
        btnMenuTransparent = (Button) findViewById(R.id.btnMenuTransparent);
        imageMenu = (ImageView) findViewById(R.id.imageMenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ListView list = (ListView) findViewById(R.id.left_drawer);
        ArrayList<NavDrawerItem> _drawerItems = new ArrayList<NavDrawerItem>();
        String[] TITLES = getResources().getStringArray(R.array.drawer_list);
        int[] Icons = new int[]{R.mipmap.home, R.mipmap.dealers, R.mipmap.call_reports, R.mipmap.products, R.mipmap.samples, R.mipmap.promotional_items, R.mipmap.sync, R.mipmap.about};
        for (int i = 0; i < TITLES.length; i++) {
            NavDrawerItem _item = new NavDrawerItem();
            _item.setTitle(TITLES[i]);
            _item.setIcon(Icons[i]);
            _drawerItems.add(_item);
        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        if (!(activity instanceof HomeActivity)) {
                            ActivitiesLauncher.openHomeActivity(getApplicationContext());
                            finish();
                        }
                        break;
                    case 1:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        if (!(activity instanceof DealersActivity)) {
                            ActivitiesLauncher.openDealersActivity(getApplicationContext());
                            finish();
                        }

                        break;
                    case 2:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        if (!(activity instanceof CallReportsActivity)) {
                            ActivitiesLauncher.openCallReportsActivity(getApplicationContext());
                            finish();
                        }
                        break;

                    case 3:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        if (!(activity instanceof ProductsActivity)) {
                            ActivitiesLauncher.openProductsActivity(getApplicationContext(), 1);
                            finish();
                        }
                        break;
                    case 4:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        if (!(activity instanceof SamplesActivity)) {
                            ActivitiesLauncher.openSamplesActivity(getApplicationContext(), 1);
                            finish();
                        }
                        break;
                    case 5:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        if (!(activity instanceof PromotionalItemsActivity)) {
                            ActivitiesLauncher.openPromotionalItemsActivity(getApplicationContext(), 1);
                            finish();
                        }
                        break;
                    case 6:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        if (!(activity instanceof SyncActivity)) {
                            ActivitiesLauncher.openSyncActivity(getApplicationContext());
                            finish();
                        }
                        break;
                    case 7:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        if (!(activity instanceof AboutActivity)) {
                            ActivitiesLauncher.openAboutActivity(getApplicationContext());
                            finish();
                        }
                        break;
                }
            }
        });

        list.setAdapter(new NavDrawerListAdapter(getApplicationContext(), _drawerItems));

        tvTitle.setText(GetHeaderTitle());
        getFragment(GetFragment());
        if (GetAddVisibillity() == View.GONE) {
            imageAdd.setVisibility(View.GONE);
        } else if (GetAddVisibillity() == View.INVISIBLE) {
            imageAdd.setVisibility(View.INVISIBLE);
        } else {
            imageAdd.setVisibility(View.VISIBLE);
            imageAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Utilities.showLongToast(BaseActivity.this, "Add Item");
                }
            });
        }

        if (GetBackVisibillity() == View.GONE) {
            imageBack.setVisibility(View.GONE);
        } else if (GetBackVisibillity() == View.INVISIBLE) {
            imageBack.setVisibility(View.INVISIBLE);
        } else {
            imageBack.setVisibility(View.VISIBLE);
            imageBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

        if (GetMenuVisibillity() == View.GONE) {
            imageMenu.setVisibility(View.GONE);
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        } else if (GetBackVisibillity() == View.INVISIBLE) {
            imageMenu.setVisibility(View.INVISIBLE);
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        } else {
            imageMenu.setVisibility(View.VISIBLE);
            imageMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                        drawerLayout.openDrawer(Gravity.LEFT);
                    } else {
                        drawerLayout.closeDrawer(Gravity.LEFT);
                    }
                }
            });

            btnMenuTransparent.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                        drawerLayout.openDrawer(Gravity.LEFT);
                    } else {
                        drawerLayout.closeDrawer(Gravity.LEFT);
                    }
                }
            });
        }

        if (GetCalendarVisibillity() == View.GONE) {
            imageCalendar.setVisibility(View.GONE);
        } else if (GetCalendarVisibillity() == View.INVISIBLE) {
            imageCalendar.setVisibility(View.INVISIBLE);
        } else {
            imageCalendar.setVisibility(View.VISIBLE);
            imageCalendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(Intent.ACTION_EDIT);
//                    intent.setType("vnd.android.cursor.item/event");
//                    intent.putExtra("title", "Some title");
//                    intent.putExtra("description", "Some description");
//                    startActivity(intent);
                    long startMillis = System.currentTimeMillis();
                    Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
                    builder.appendPath("time");
                    ContentUris.appendId(builder, startMillis);
                    Intent intent = new Intent(Intent.ACTION_VIEW).setData(builder.build());
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onResume(RestClient client) {
        this.client = client;
    }

    private void getFragment(Fragment targetFragment) {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, targetFragment, "test")
                .commitAllowingStateLoss();
    }

    public abstract Fragment GetFragment();

    public abstract String GetHeaderTitle();

    public abstract int GetCalendarVisibillity();

    public abstract int GetAddVisibillity();

    public abstract int GetBackVisibillity();

    public abstract int GetMenuVisibillity();

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            super.onBackPressed();
        }
    }
}
