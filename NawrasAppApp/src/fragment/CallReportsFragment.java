package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cloudconcept.ActivitiesLauncher;
import com.cloudconcept.R;

import adapter.ScheduledVisitsAdapter;
import utilities.LayoutResource;

/**
 * Created by Abanoub Wagdy on 12/15/2015.
 */
public class CallReportsFragment extends Fragment {

    ListView lstCallReports;

    public static Fragment newInstance() {
        CallReportsFragment fragment = new CallReportsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutResource.getCallReportsResource(), container, false);
        lstCallReports = (ListView) view.findViewById(R.id.lstCallReports);
        lstCallReports.setAdapter(new ScheduledVisitsAdapter(getActivity().getApplicationContext()));
        lstCallReports.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ActivitiesLauncher.openCallReportDetailsActivity(getActivity().getApplicationContext(), "1");
                } else {
                    ActivitiesLauncher.openCallReportDetailsActivity(getActivity().getApplicationContext(), "2");
                }

            }
        });
        return view;
    }
}
