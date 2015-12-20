package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cloudconcept.R;

import java.util.ArrayList;

import model.Visit;

/**
 * Created by Abanoub Wagdy on 12/20/2015.
 */
public class ScheduledVisitsAdapter extends BaseAdapter {

    ArrayList<Visit> _visits;
    Context context;

    public ScheduledVisitsAdapter(Context context) {
        _visits = new ArrayList<>();
        Visit _visit = new Visit();
        _visit.setName("Basma Al Kawn Trading");
        _visit.setTime("Time : 2013-10-23 10 A.M");
        _visit.setLocation("Location : Oman");
        _visits.add(_visit);
        _visit = new Visit();
        _visit.setName("Rahaf Al Khair");
        _visit.setTime("Time : 2013-10-23 10 A.M");
        _visit.setLocation("Location : Oman");
        _visits.add(_visit);
        this.context = context;
    }

    @Override
    public int getCount() {
        return _visits.size();
    }

    @Override
    public Object getItem(int position) {
        return _visits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tvVisitName,tvLocation,tvTime;
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.scheduled_visit_list_item, null);
        }
        tvVisitName = (TextView)convertView.findViewById(R.id.tvVisitName);
        tvLocation = (TextView)convertView.findViewById(R.id.tvLocation);
        tvTime = (TextView)convertView.findViewById(R.id.tvTime);

        tvVisitName.setText(_visits.get(position).getName());
        tvLocation.setText(_visits.get(position).getLocation());
        tvTime.setText(_visits.get(position).getTime());
        return convertView;
    }
}
