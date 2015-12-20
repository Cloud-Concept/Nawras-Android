package activity;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cloudconcept.BaseActivity;

import fragment.ObjectivesFragment;

/**
 * Created by Abanoub Wagdy on 12/20/2015.
 */
public class ObjectivesActivity extends BaseActivity{

    @Override
    public Fragment GetFragment() {
        Fragment fragment = new ObjectivesFragment();
        return fragment;
    }

    @Override
    public String GetHeaderTitle() {
        return "Objectives";
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
