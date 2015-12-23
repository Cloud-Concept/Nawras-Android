package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.cloudconcept.ActivitiesLauncher;
import com.cloudconcept.R;

import activity.StockActivity;
import adapter.MyRequestSpinnerAdapter;
import utilities.LayoutResource;

/**
 * Created by Abanoub Wagdy on 12/16/2015.
 */
public class StocksFragment extends Fragment {

    LinearLayout linearLayout;
    Button btnSave;
    StockActivity activity;
    static String[] products = new String[]{"Ooredoo 4G+ My-Fi", "Ooredoo 4G+ Smart Cradle", "Ooredoo 300 Mbps My-Fi", "Huawei Car Fi E8377 Hilink LTE Hotspot", "HUAWEI E5878S-32 - White", "Slim My-Fi"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutResource.getStocksResource(), container, false);
        InitializeViews(view);
        return view;
    }

    private void InitializeViews(View view) {

        activity = (StockActivity) getActivity();
        activity.GetImageAdd().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addViewToLayout();
            }
        });

        linearLayout = (LinearLayout) view.findViewById(R.id.linear);

        btnSave = (Button) view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openHomeActivity(getActivity().getApplicationContext());
                getActivity().finish();
            }
        });

        addViewToLayout();
    }

    public void addViewToLayout() {

        EditText etQTYAvailability, etOfFacing;
        Spinner spinnerProduct;
        View layout2 = LayoutInflater.from(getActivity()).inflate(R.layout.stocks_item, null, false);

        spinnerProduct = (Spinner) layout2.findViewById(R.id.spinnerProduct);

        etQTYAvailability = (EditText) layout2.findViewById(R.id.etQTYAvailabillity);
        etOfFacing = (EditText) layout2.findViewById(R.id.etOfFacing);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,products);
//        spinnerProduct.setAdapter(adapter);

        MyRequestSpinnerAdapter dataAdapter = new MyRequestSpinnerAdapter(getActivity(), R.layout.spinner_item, 0, products);
        spinnerProduct.setAdapter(dataAdapter);

        linearLayout.addView(layout2);

    }
}
