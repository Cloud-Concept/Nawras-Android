package activity;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cloudconcept.BaseActivity;

import fragment.CallReportDetailsFragment;

/**
 * Created by Abanoub Wagdy on 12/20/2015.
 */
public class CallReportDetailsActivity extends BaseActivity {
    @Override
    public Fragment GetFragment() {
        Fragment fragment = CallReportDetailsFragment.newInstance(getIntent().getExtras().getString("item"));
        return fragment;
    }

    @Override
    public String GetHeaderTitle() {
        return "Call Report Details";
    }

    @Override
    public int GetCalendarVisibillity() {
        return View.GONE;
    }

    @Override
    public int GetAddVisibillity() {
        return View.GONE;
    }

    @Override
    public int GetBackVisibillity() {
        return View.VISIBLE;
    }

    @Override
    public int GetMenuVisibillity() {
        return View.GONE;
    }
}
