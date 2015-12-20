package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.cloudconcept.R;

import utilities.LayoutResource;

/**
 * Created by Abanoub Wagdy on 12/15/2015.
 */
public class AboutFragment extends Fragment {


    public static Fragment newInstance() {
        AboutFragment fragment = new AboutFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutResource.getAboutResource(), container, false);
        return view;
    }
}
