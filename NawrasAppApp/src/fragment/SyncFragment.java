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
public class SyncFragment extends Fragment {

    public static Fragment newInstance() {
        SyncFragment fragment = new SyncFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutResource.getSyncResource(), container, false);
        return view;
    }
}
