package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.cloudconcept.R;

import adapter.MyListAdapter;
import utilities.LayoutResource;

/**
 * Created by Abanoub Wagdy on 12/15/2015.
 */
public class SamplesFragment extends Fragment {

    ListView lstSamples;
    String[] samples = new String[]{"Ooredoo 4G+ My-Fi", "Ooredoo 4G+ Smart Cradle", "Ooredoo 300 Mbps My-Fi", "Huawei Car Fi E8377 Hilink LTE Hotspot", "HUAWEI E5878S-32 - White", "Slim My-Fi"};


    public static Fragment newInstance() {
        SamplesFragment fragment = new SamplesFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutResource.getSamplesResource(), container, false);
        lstSamples = (ListView) view.findViewById(R.id.lstSamples);
        lstSamples.setAdapter(new MyListAdapter(samples, getActivity().getApplicationContext()));
        return view;
    }
}
