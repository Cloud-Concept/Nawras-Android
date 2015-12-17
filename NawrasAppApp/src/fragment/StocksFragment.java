package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import utilities.LayoutResource;

/**
 * Created by Abanoub Wagdy on 12/16/2015.
 */
public class StocksFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutResource.getStocksResource(), container, false);
        return view;
    }
}
