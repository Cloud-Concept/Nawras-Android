package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cloudconcept.ActivitiesLauncher;
import com.cloudconcept.R;

import utilities.LayoutResource;

/**
 * Created by Abanoub Wagdy on 12/16/2015.
 */
public class StocksFragment extends Fragment {

    EditText etProduct, etQTYAvailability,etOfFacing;
    Button btnSave;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutResource.getStocksResource(), container, false);
        InitializeViews(view);
        return view;
    }

    private void InitializeViews(View view) {
        etProduct = (EditText)view.findViewById(R.id.etProduct);
        etQTYAvailability = (EditText)view.findViewById(R.id.etQTYAvailabillity);
        etOfFacing = (EditText)view.findViewById(R.id.etOfFacing);

        btnSave = (Button)view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openHomeActivity(getActivity().getApplicationContext());
                getActivity().finish();
            }
        });
    }
}
