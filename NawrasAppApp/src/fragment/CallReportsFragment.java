package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import utilities.LayoutResource;

/**
 * Created by Abanoub Wagdy on 12/15/2015.
 */
public class CallReportsFragment extends Fragment {

    public static Fragment newInstance() {
        CallReportsFragment fragment = new CallReportsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutResource.getCallReportsResource(), container, false);
        return view;
    }
}
