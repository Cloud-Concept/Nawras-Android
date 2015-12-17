package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudconcept.R;

import utilities.TitleConstants;

/**
 * Created by Abanoub Wagdy on 12/15/2015.
 */
public class MyListAdapter extends BaseAdapter {

    private final String[] products;
    private final Context context;
    String screenType;

    public MyListAdapter(String[] products, Context context, String screenType) {
        this.products = products;
        this.context = context;
        this.screenType = screenType;
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

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitleList);
        TextView tvSubTitle = (TextView) convertView.findViewById(R.id.tvSubTitle);
        ImageView imageRow = (ImageView) convertView.findViewById(R.id.imageRow);


        if (screenType.equals(TitleConstants.PRODUCTS_TITLE)) {

            tvTitle.setText("Product Item");
            imageRow.setImageResource(R.mipmap.products);
            tvSubTitle.setText(products[position]);

        } else if (screenType.equals(TitleConstants.PROMOTIONAL_ITEMS_TITLE)) {

            tvTitle.setText("Promotional Item");
            imageRow.setImageResource(R.mipmap.promotional_items);
            tvSubTitle.setText(products[position]);

        } else if(screenType.equals(TitleConstants.SAMPLES_TITLE)){

            tvTitle.setText("Sample Item");
            imageRow.setImageResource(R.mipmap.samples);
            tvSubTitle.setText(products[position]);

        }else if(screenType.equals(TitleConstants.DEALERS_TITLE)){

            tvTitle.setText(products[position]);
            tvSubTitle.setText("Address : Oman");

        }


        return convertView;
    }
}
