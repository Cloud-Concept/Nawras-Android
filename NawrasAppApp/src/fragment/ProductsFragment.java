package fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
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

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.cloudconcept.R;

import java.util.ArrayList;

import activity.ProductsActivity;
import adapter.MyListAdapter;
import model.GenericItem;
import utilities.LayoutResource;
import utilities.TitleConstants;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 12/15/2015.
 */
public class ProductsFragment extends Fragment {

    SwipeMenuListView lstProducts;
    static String[] products = new String[]{"Ooredoo 4G+ My-Fi", "Ooredoo 4G+ Smart Cradle", "Ooredoo 300 Mbps My-Fi", "Huawei Car Fi E8377 Hilink LTE Hotspot", "HUAWEI E5878S-32 - White", "Slim My-Fi"};
    static ArrayList<GenericItem> items = new ArrayList<>();
    private static MyListAdapter adapter;
    private ProductsActivity activity;

    public static Fragment newInstance() {
        ProductsFragment fragment = new ProductsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutResource.getProductsResource(), container, false);
        lstProducts = (SwipeMenuListView) view.findViewById(R.id.lstProducts);
        lstProducts.setSwipeDirection(SwipeMenuListView.DIRECTION_RIGHT);
        items = new ArrayList<>();

        activity = (ProductsActivity) getActivity();

        activity.GetAddControl().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(inflater);
            }
        });


        for (int i = 0; i < products.length; i++) {
            GenericItem item = new GenericItem();
            item.setProductName(products[i]);
            item.setQuantity(i + 2 + "");
            item.setFacing(i + 4 + "");
            items.add(item);
        }


        final SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getActivity().getApplicationContext());

                openItem.setWidth(Utilities.dp2px(65, getActivity()));

                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                openItem.setBackground(R.mipmap.add);
                // add to menu
                menu.addMenuItem(openItem);

                SwipeMenuItem mailItem = new SwipeMenuItem(
                        getActivity().getApplicationContext());

                mailItem.setWidth(Utilities.dp2px(65, getActivity()));

                mailItem.setTitleSize(18);
                // set item title font color
                mailItem.setTitleColor(Color.WHITE);
                mailItem.setBackground(R.mipmap.minus);
                // add to menu
                menu.addMenuItem(mailItem);
            }
        };

        lstProducts.setMenuCreator(creator);

        lstProducts.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        items.get(position).setQuantity(String.valueOf(Integer.parseInt(items.get(position).getQuantity()) + 1));
                        adapter.notifyDataSetChanged();
                        break;
                    case 1:
                        items.get(position).setQuantity(items.get(position).getQuantity().equals("0") ? "0" : String.valueOf((Integer.parseInt(items.get(position).getQuantity()) - 1)));
                        adapter.notifyDataSetChanged();
                        break;
                }
                return false;
            }
        });

        adapter = new MyListAdapter(items, getActivity().getApplicationContext(), TitleConstants.PRODUCTS_TITLE);
        lstProducts.setAdapter(adapter);
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
