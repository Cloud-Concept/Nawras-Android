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
public class PromotionalItemsFragment extends Fragment {

    ListView lstPromotions;
    String[] promotions = new String[]{"Agenda", "Pens", "Calculators", "Cups", "Note Books"};


    public static Fragment newInstance() {
        PromotionalItemsFragment fragment = new PromotionalItemsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutResource.getPromotionsResource(), container, false);
        lstPromotions = (ListView)view.findViewById(R.id.lstPromotions);
        lstPromotions.setAdapter(new MyListAdapter(promotions,getActivity().getApplicationContext()));
        return view;
    }
}
