package activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cloudconcept.BaseActivity;

import fragment.CallReportsFragment;
import utilities.ExceptionHandler;
import utilities.TitleConstants;

/**
 * Created by Abanoub Wagdy on 12/15/2015.
 */
public class CallReportsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
    }


    @Override
    public Fragment GetFragment() {
        Fragment fragment = CallReportsFragment.newInstance();
        return fragment;
    }

    @Override
    public String GetHeaderTitle() {
        return TitleConstants.CALL_REPORTS_TITLE;
    }
}
