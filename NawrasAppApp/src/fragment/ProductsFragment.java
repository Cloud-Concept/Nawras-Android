package fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
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
import android.widget.Toast;

import com.cloudconcept.R;
import com.com.baoyz.swipemenulistview.SwipeMenu;
import com.com.baoyz.swipemenulistview.SwipeMenuAdapter;
import com.com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.com.baoyz.swipemenulistview.SwipeMenuItem;
import com.com.baoyz.swipemenulistview.SwipeMenuListView;

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

    private static EditText etProductName;
    private static EditText etQuantity;
    private static Button btnOk;
    private static Button btnCancel;
    SwipeMenuListView lstProducts;
    ListView lstProducts2;
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

        View view;
        activity = (ProductsActivity) getActivity();
        if (activity.GetAddVisibillity() == View.VISIBLE) {
            view = inflater.inflate(LayoutResource.getProductsResource(), container, false);
            lstProducts = (SwipeMenuListView) view.findViewById(R.id.lstProducts);
            lstProducts.setSwipeDirection(SwipeMenuListView.DIRECTION_RIGHT);
            lstProducts.setCloseInterpolator(null);
            items = new ArrayList<>();

            activity = (ProductsActivity) getActivity();

            activity.GetAddControl().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialog(activity, "Add Product Item");
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
            SwipeMenuAdapter swipeMenuListViewadapter = new SwipeMenuAdapter(getActivity().getApplicationContext(), adapter);
            lstProducts.setAdapter(swipeMenuListViewadapter);

        } else {

            view = inflater.inflate(LayoutResource.getProductsWithoutSwipeResource(), container, false);
            lstProducts2 = (ListView) view.findViewById(R.id.lstProducts);
            items = new ArrayList<>();
            for (int i = 0; i < products.length; i++) {
                GenericItem item = new GenericItem();
                item.setProductName(products[i]);
                item.setQuantity(i + 2 + "");
                item.setFacing(i + 4 + "");
                items.add(item);
            }
            adapter = new MyListAdapter(items, getActivity().getApplicationContext(), TitleConstants.PRODUCTS_TITLE);
            lstProducts2.setAdapter(adapter);

        }
        return view;
    }


    public static void showAlertDialog(final Activity activity, String title) {

        final Dialog dialog = new Dialog(activity);
        dialog.setTitle(title);

        dialog.setContentView(R.layout.dialog_product);

        etProductName = (EditText) dialog.findViewById(R.id.etProductName);
        etQuantity = (EditText) dialog.findViewById(R.id.etQuantity);
        btnOk = (Button) dialog.findViewById(R.id.btnOk);
        btnCancel = (Button) dialog.findViewById(R.id.btnCancel);

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
}
