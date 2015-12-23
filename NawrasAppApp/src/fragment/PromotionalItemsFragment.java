package fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudconcept.R;

import java.util.ArrayList;

import activity.PromotionalItemsActivity;
import adapter.MyListAdapter;
import model.GenericItem;
import utilities.LayoutResource;
import utilities.TitleConstants;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 12/15/2015.
 */
public class PromotionalItemsFragment extends Fragment {

    ListView lstPromotions;
    String[] promotions = new String[]{"Agenda", "Pens", "Calculators", "Cups", "Note Books"};
    private static ArrayList<GenericItem> items;
    static MyListAdapter adapter;
    PromotionalItemsActivity activity;


    public static Fragment newInstance() {
        PromotionalItemsFragment fragment = new PromotionalItemsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutResource.getPromotionsResource(), container, false);
        lstPromotions = (ListView)view.findViewById(R.id.lstPromotions);

        items = new ArrayList<>();

        activity = (PromotionalItemsActivity) getActivity();

        activity.GetAddControl().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(inflater);
            }
        });

        for (int i=0;i<promotions.length;i++){
            GenericItem item = new GenericItem();
            item.setProductName(promotions[i]);
            item.setQuantity(i+4+"");
            item.setFacing(i + 6 + "");
            items.add(item);
        }

        adapter = new MyListAdapter(items,getActivity().getApplicationContext(), TitleConstants.PROMOTIONAL_ITEMS_TITLE);
        lstPromotions.setAdapter(adapter);
        return view;
    }


    private void showAlert(LayoutInflater inflater) {

        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        LinearLayout layout = new LinearLayout(getActivity());
        TextView tvProductName = new TextView(getActivity());
        final EditText etProductName = new EditText(getActivity());
        layout.setBackgroundColor(getActivity().getResources().getColor(R.color.white));

        TextView tvQuantity = new TextView(getActivity());
        final EditText etQuantity = new EditText(getActivity());

//        TextView tvFacing = new TextView(getActivity());
//        final EditText etFacing = new EditText(getActivity());

        tvProductName.setText("Product Name");
        tvProductName.setTextColor(getActivity().getResources().getColor(R.color.white));
        etProductName.setSingleLine();
        tvProductName.setTextColor(getActivity().getResources().getColor(R.color.black));

        tvQuantity.setText("Quantity");

        tvQuantity.setTextColor(getActivity().getResources().getColor(R.color.white));
        etQuantity.setSingleLine();
        tvQuantity.setTextColor(getActivity().getResources().getColor(R.color.black));
//
//        tvFacing.setText("Pieces");
//        tvFacing.setTextColor(getActivity().getResources().getColor(R.color.white));
//        etFacing.setSingleLine();
//        tvFacing.setTextColor(getActivity().getResources().getColor(R.color.black));

        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(tvProductName);
        layout.addView(etProductName);
        layout.addView(tvQuantity);
        layout.addView(etQuantity);
//        layout.addView(tvFacing);
//        layout.addView(etFacing);
        alert.setView(layout);

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                GenericItem item = new GenericItem();
                item.setProductName(etProductName.getText().toString());
                item.setQuantity(etQuantity.getText().toString());
                item.setFacing("8");
                items.add(item);
                adapter.notifyDataSetChanged();
                Utilities.showLongToast(getActivity(), "Success");
            }
        });
        View headerView = inflater.inflate(R.layout.header_dialog, null, false);
        alert.setCustomTitle(headerView);


        alert.show();
    }
}
