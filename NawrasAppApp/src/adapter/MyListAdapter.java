package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cloudconcept.R;

/**
 * Created by Abanoub Wagdy on 12/15/2015.
 */
public class MyListAdapter extends BaseAdapter {

    private final String[] products;
    private final Context context;

    public MyListAdapter(String[] products, Context context) {
        this.products = products;
        this.context = context;
    }

    @Override
    public int getCount() {
        return products.length;
    }

    @Override
    public Object getItem(int position) {
        return products[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.item_list, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.tv);
        tv.setText(products[position]);
        return convertView;
    }
}
