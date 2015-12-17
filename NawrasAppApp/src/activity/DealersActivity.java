package activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.cloudconcept.BaseActivity;

import fragment.DealersFragment;
import utilities.ExceptionHandler;
import utilities.TitleConstants;

/**
 * Created by Abanoub Wagdy on 12/15/2015.
 */
public class DealersActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
    }

    @Override
    public Fragment GetFragment() {
        Fragment fragment = DealersFragment.newInstance();
        return fragment;
    }

    @Override
    public String GetHeaderTitle() {
        return TitleConstants.DEALERS_TITLE;
    }

    @Override
    public int GetCalendarVisibillity() {
        return View.GONE;
    }

    @Override
    public int GetAddVisibillity() {
        return View.GONE;
    }
}
