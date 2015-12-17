package com.cloudconcept;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.ui.sfnative.SalesforceActivity;

import java.util.ArrayList;

import activity.AboutActivity;
import activity.CallReportsActivity;
import activity.DealersActivity;
import activity.HomeActivity;
import activity.ProductsActivity;
import activity.PromotionalItemsActivity;
import activity.SamplesActivity;
import activity.StockActivity;
import activity.SyncActivity;
import adapter.NavDrawerListAdapter;
import model.NavDrawerItem;
import utilities.ExceptionHandler;
import utilities.LayoutResource;

/**
 * Created by Abanoub Wagdy on 6/22/2015.
 */

public abstract class BaseActivity extends SalesforceActivity {

    private FragmentManager fragmentManager;
    private ImageView imageMenu, imageCalendar, imageAdd;
    private Button btnMenuTransparent;
    private TextView tvTitle;
    private DrawerLayout drawerLayout;
    protected static RestClient client;
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
        imageCalendar = (ImageView) findViewById(R.id.imageCalendar);
        imageAdd = (ImageView) findViewById(R.id.imageAdd);
//        btnLogout = (Button) findViewById(R.id.btnLogout);
//        btnLogout.setOnClickListener(listenerOk1);
        activity = this;
        btnMenuTransparent = (Button) findViewById(R.id.btnMenuTransparent);
        imageMenu = (ImageView) findViewById(R.id.imageMenu);
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
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ListView list = (ListView) findViewById(R.id.left_drawer);
        ArrayList<NavDrawerItem> _drawerItems = new ArrayList<NavDrawerItem>();
        String[] TITLES = getResources().getStringArray(R.array.drawer_list);
        int[] Icons = new int[]{R.mipmap.home, R.mipmap.dealers, R.mipmap.call_reports, R.mipmap.stocks, R.mipmap.products, R.mipmap.samples, R.mipmap.promotional_items, R.mipmap.sync, R.mipmap.about};
        for (int i = 0; i < TITLES.length; i++) {
            NavDrawerItem _item = new NavDrawerItem();
            _item.setTitle(TITLES[i]);
            _item.setIcon(Icons[i]);
            _drawerItems.add(_item);
        }

//        LayoutInflater mInflater = (LayoutInflater)
//                getApplicationContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//        View v = mInflater.inflate(R.layout.header, null);
//        list.addHeaderView(v);
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
                        if (!(activity instanceof StockActivity)) {
                            ActivitiesLauncher.openStockActivity(getApplicationContext());
                            finish();
                        }
                        break;
                    case 4:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        if (!(activity instanceof ProductsActivity)) {
                            ActivitiesLauncher.openProductsActivity(getApplicationContext());
                            finish();
                        }
                        break;
                    case 5:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        if (!(activity instanceof SamplesActivity)) {
                            ActivitiesLauncher.openSamplesActivity(getApplicationContext());
                            finish();
                        }
                        break;
                    case 6:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        if (!(activity instanceof PromotionalItemsActivity)) {
                            ActivitiesLauncher.openPromotionalItemsActivity(getApplicationContext());
                            finish();
                        }
                        break;
                    case 7:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        if (!(activity instanceof SyncActivity)) {
                            ActivitiesLauncher.openSyncActivity(getApplicationContext());
                            finish();
                        }
                        break;
                    case 8:
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
        }
        if (GetCalendarVisibillity() == View.GONE) {
            imageCalendar.setVisibility(View.GONE);
        } else if (GetCalendarVisibillity() == View.INVISIBLE) {
            imageCalendar.setVisibility(View.INVISIBLE);
        } else {
            imageCalendar.setVisibility(View.VISIBLE);
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

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            super.onBackPressed();
        }
    }
}
