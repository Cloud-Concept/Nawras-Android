package fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.cloudconcept.R;

import java.util.ArrayList;

import activity.SamplesActivity;
import adapter.MyListAdapter;
import model.GenericItem;
import utilities.LayoutResource;
import utilities.TitleConstants;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 12/15/2015.
 */
public class SamplesFragment extends Fragment {

    private static EditText etProductName;
    private static EditText etQuantity;
    private static Button btnOk;
    private static Button btnCancel;
    ListView lstSamples;
    String[] samples = new String[]{"Ooredoo 4G+ My-Fi", "Ooredoo 4G+ Smart Cradle", "Ooredoo 300 Mbps My-Fi", "Huawei Car Fi E8377 Hilink LTE Hotspot", "HUAWEI E5878S-32 - White", "Slim My-Fi"};
    private static ArrayList<GenericItem> items;
    private SamplesActivity activity;
    private static MyListAdapter adapter;


    public static Fragment newInstance() {
        SamplesFragment fragment = new SamplesFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutResource.getSamplesResource(), container, false);
        lstSamples = (ListView) view.findViewById(R.id.lstSamples);
        items = new ArrayList<>();

        items = new ArrayList<>();

        activity = (SamplesActivity) getActivity();

        activity.GetAddControl().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog(getActivity(),"Add Sample Item");
            }
        });

        for (int i=0;i<samples.length;i++){
            GenericItem item = new GenericItem();
            item.setProductName(samples[i]);
            item.setQuantity(i+1+"");
            item.setFacing(i+3+"");
            items.add(item);
        }

        adapter = new MyListAdapter(items, getActivity().getApplicationContext(), TitleConstants.SAMPLES_TITLE);

        lstSamples.setAdapter(adapter);
        return view;
    }


//    public static void showAlertDialog(final Activity activity, String title) {
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity, AlertDialog.THEME_HOLO_LIGHT);
//        builder.setTitle(title);
//
//        builder.setIcon(R.drawable.ic_launcher);
//        builder.setView(R.layout.dialog_product);
//
//        builder.setCancelable(true);
//
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
//
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                GenericItem item = new GenericItem();
//                item.setProductName(etProductName.getText().toString());
//                item.setQuantity(etQuantity.getText().toString());
//                item.setFacing("8");
//                items.add(item);
//                adapter.notifyDataSetChanged();
//                Utilities.showLongToast(activity, "Success");
//            }
//        });
//
//        AlertDialog alertDialog = builder.create();
//
//        etProductName = (EditText) alertDialog.findViewById(R.id.etProductName);
//        etQuantity = (EditText) alertDialog.findViewById(R.id.etQuantity);
//
//        alertDialog.show();
//    }

    public static void showAlertDialog(final Activity activity, String title) {

        final Dialog dialog = new Dialog(activity);
        dialog.setTitle(title);

        dialog.setContentView(R.layout.dialog_product);

        etProductName = (EditText) dialog.findViewById(R.id.etProductName);
        etQuantity = (EditText) dialog.findViewById(R.id.etQuantity);
        btnOk = (Button)dialog.findViewById(R.id.btnOk);
        btnCancel = (Button)dialog.findViewById(R.id.btnCancel);

        dialog.setCancelable(true);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GenericItem item = new GenericItem();
                item.setProductName(etProductName.getText().toString());
                item.setQuantity(etQuantity.getText().toString());
                item.setFacing("8");
                items.add(item);
                adapter.notifyDataSetChanged();
                Utilities.showLongToast(activity, "Success");
                dialog.cancel();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();
    }


//    private void showAlert(LayoutInflater inflater) {
//
//        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
//        LinearLayout layout = new LinearLayout(getActivity());
//        TextView tvProductName = new TextView(getActivity());
//        final EditText etProductName = new EditText(getActivity());
//        layout.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
//
//        TextView tvQuantity = new TextView(getActivity());
//        final EditText etQuantity = new EditText(getActivity());
//
////        TextView tvFacing = new TextView(getActivity());
////        final EditText etFacing = new EditText(getActivity());
//
//        tvProductName.setText("Product Name");
//        tvProductName.setTextColor(getActivity().getResources().getColor(R.color.white));
//        etProductName.setSingleLine();
//        tvProductName.setTextColor(getActivity().getResources().getColor(R.color.black));
//
//        tvQuantity.setText("Quantity");
//
//        tvQuantity.setTextColor(getActivity().getResources().getColor(R.color.white));
//        etQuantity.setSingleLine();
//        tvQuantity.setTextColor(getActivity().getResources().getColor(R.color.black));
////
////        tvFacing.setText("Pieces");
////        tvFacing.setTextColor(getActivity().getResources().getColor(R.color.white));
////        etFacing.setSingleLine();
////        tvFacing.setTextColor(getActivity().getResources().getColor(R.color.black));
//
//        layout.setOrientation(LinearLayout.VERTICAL);
//        layout.addView(tvProductName);
//        layout.addView(etProductName);
//        layout.addView(tvQuantity);
//        layout.addView(etQuantity);
////        layout.addView(tvFacing);
////        layout.addView(etFacing);
//        alert.setView(layout);
//
//        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
//
//        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                GenericItem item = new GenericItem();
//                item.setProductName(etProductName.getText().toString());
//                item.setQuantity(etQuantity.getText().toString());
//                item.setFacing("8");
//                items.add(item);
//                adapter.notifyDataSetChanged();
//                Utilities.showLongToast(getActivity(), "Success");
//            }
//        });
//        View headerView = inflater.inflate(R.layout.header_dialog, null, false);
//        alert.setCustomTitle(headerView);
//
//
//        alert.show();
//    }
}
