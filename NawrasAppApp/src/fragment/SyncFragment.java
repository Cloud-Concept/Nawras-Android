package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import utilities.ActivitiesLauncher;
import com.cloudconcept.R;

import utilities.LayoutResource;

/**
 * Created by Abanoub Wagdy on 12/15/2015.
 */
public class SyncFragment extends Fragment {

    Button btnSync;

    public static Fragment newInstance() {
        SyncFragment fragment = new SyncFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutResource.getSyncResource(), container, false);
        btnSync = (Button)view.findViewById(R.id.btnSync);
        btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openHomeActivity(getActivity().getApplicationContext());
                getActivity().finish();
            }
        });
        return view;
    }
}
