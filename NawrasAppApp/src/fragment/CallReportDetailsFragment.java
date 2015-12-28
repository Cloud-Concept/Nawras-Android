package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import utilities.ActivitiesLauncher;

import com.cloudconcept.R;

import utilities.LayoutResource;

/**
 * Created by Abanoub Wagdy on 12/20/2015.
 */
public class CallReportDetailsFragment extends Fragment implements View.OnClickListener {

    static String item;
    RelativeLayout relativeProducts, relativeSamples, relativePromotionalItems, relativeObjectives, relativeStocks;
    TextView tvDealerName;
    Button btnCheckin, btnCancel;

    public static Fragment newInstance(String item) {
        CallReportDetailsFragment fragment = new CallReportDetailsFragment();
        CallReportDetailsFragment.item = item;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutResource.getCallReportsDetailsResource(), container, false);
        InitializeViews(view);
        if (item.equals("1")) {
            tvDealerName.setText("Basma Al Kawn Trading");
        } else {
            tvDealerName.setText("Rahaf Al Khair");
        }
        return view;
    }

    private void InitializeViews(View view) {
        tvDealerName = (TextView) view.findViewById(R.id.tvDealerName);
        relativeObjectives = (RelativeLayout) view.findViewById(R.id.relativeObjectives);
        relativeProducts = (RelativeLayout) view.findViewById(R.id.relativeProducts);
        relativeSamples = (RelativeLayout) view.findViewById(R.id.relativeSamples);
        relativePromotionalItems = (RelativeLayout) view.findViewById(R.id.relativePromotionalItems);
        relativeStocks = (RelativeLayout) view.findViewById(R.id.relativeStocks);
        btnCheckin = (Button) view.findViewById(R.id.btnCheckin);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnCheckin.setOnClickListener(this);
        btnCancel.setOnClickListener(this);


        relativeObjectives.setOnClickListener(this);
        relativeProducts.setOnClickListener(this);
        relativeSamples.setOnClickListener(this);
        relativePromotionalItems.setOnClickListener(this);
        relativeStocks.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == relativeProducts) {

            ActivitiesLauncher.openProductsActivity(getActivity().getApplicationContext(), 2, 1);

        } else if (v == relativePromotionalItems) {

            ActivitiesLauncher.openPromotionalItemsActivity(getActivity().getApplicationContext(), 2, 1);

        } else if (v == relativeSamples) {

            ActivitiesLauncher.openSamplesActivity(getActivity().getApplicationContext(), 2, 1);

        } else if (v == relativeStocks) {

            ActivitiesLauncher.openStockActivity(getActivity().getApplicationContext(), 2);

        } else if (v == relativeObjectives) {

            ActivitiesLauncher.openObjectivesActivity(getActivity().getApplicationContext());

        } else if (v == btnCheckin) {

            if (btnCheckin.getText().toString().contains("In")) {
                btnCheckin.setText("Check Out");
            } else {
                btnCheckin.setText("Check In");
            }

        } else if (v == btnCancel) {
            getActivity().finish();
        }
    }
}
