package activity;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cloudconcept.BaseActivity;

import fragment.StocksFragment;
import utilities.TitleConstants;

/**
 * Created by Abanoub Wagdy on 12/16/2015.
 */
public class StockActivity extends BaseActivity {
    @Override
    public Fragment GetFragment() {
        Fragment fragment = new StocksFragment();
        return fragment;
    }

    @Override
    public String GetHeaderTitle() {
        return TitleConstants.STOCK_TITLE;
    }

    @Override
    public int GetCalendarVisibillity() {
        return View.GONE;
    }

    @Override
    public int GetAddVisibillity() {
        return View.VISIBLE;
    }
}
