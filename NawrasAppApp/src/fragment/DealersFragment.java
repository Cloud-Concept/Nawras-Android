package fragment;

import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.cloudconcept.R;
import com.com.baoyz.swipemenulistview.SwipeMenu;
import com.com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.com.baoyz.swipemenulistview.SwipeMenuItem;
import com.com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

import adapter.MyListAdapter;
import model.GenericItem;
import utilities.LayoutResource;
import utilities.TitleConstants;

/**
 * Created by Abanoub Wagdy on 12/15/2015.
 */
public class DealersFragment extends Fragment {

    SwipeMenuListView lstDealers;
    String[] items2 = new String[]{"Al-Sharara Electronics", "Basma Al Kawn Trading"};
    ArrayList<GenericItem> items;

    public static Fragment newInstance() {
        DealersFragment fragment = new DealersFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(LayoutResource.getDealersResource(), container, false);
        lstDealers = (SwipeMenuListView) view.findViewById(R.id.lstDealers);
        lstDealers.setSwipeDirection(SwipeMenuListView.DIRECTION_RIGHT);
        items = new ArrayList<>();
        for (int i = 0; i < items2.length; i++) {
            GenericItem item = new GenericItem();
            item.setProductName(items2[i]);
            items.add(item);
        }

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getActivity().getApplicationContext());

                openItem.setWidth(dp2px(65));

                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                openItem.setBackground(R.mipmap.call);
                // add to menu
                menu.addMenuItem(openItem);

                SwipeMenuItem mailItem = new SwipeMenuItem(
                        getActivity().getApplicationContext());

                mailItem.setWidth(dp2px(65));

                mailItem.setTitleSize(18);
                // set item title font color
                mailItem.setTitleColor(Color.WHITE);
                mailItem.setBackground(R.mipmap.mail);
                // add to menu
                menu.addMenuItem(mailItem);
            }
        };

        lstDealers.setMenuCreator(creator);

        lstDealers.setAdapter(new MyListAdapter(items, getActivity().getApplicationContext(), TitleConstants.DEALERS_TITLE));

        lstDealers.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        Toast.makeText(getActivity().getApplicationContext(), "Call", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getActivity().getApplicationContext(), "Mail", Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }
        });

        return view;
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
