package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cloudconcept.R;

import utilities.LayoutResource;

/**
 * Created by Abanoub Wagdy on 12/20/2015.
 */
public class ObjectivesFragment extends Fragment implements View.OnClickListener {

    TextView tvQuestion1, tvQuestion2, tvQuestion3;
    EditText  etResult2;
    EditText etRemarks1, etRemarks2, etRemarks3;
    String[] Questions = new String[]{"BRIEF TRAIN THE DEALER ON THE NEW RECHARGE WIN PROMOTION", "REINFORCE THE MOUSBAK PLAN PROMOTION", "CHECK COLLECT PENDING USSD FORMS"};
    Button btnSave;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutResource.getObjectivesResource(), container, false);
        InitializeViews(view);
        return view;
    }

    private void InitializeViews(View view) {
        tvQuestion1 = (TextView) view.findViewById(R.id.tvQuestion1);
        tvQuestion2 = (TextView) view.findViewById(R.id.tvQuestion2);
        tvQuestion3 = (TextView) view.findViewById(R.id.tvQuestion3);

        tvQuestion1.setText(Questions[0]);
        tvQuestion2.setText(Questions[1]);
        tvQuestion3.setText(Questions[2]);

//        etResult1 = (EditText) view.findViewById(R.id.etResult1);
        etResult2 = (EditText) view.findViewById(R.id.etResult2);
//        etResult3 = (EditText) view.findViewById(R.id.etResult3);

        etRemarks1 = (EditText) view.findViewById(R.id.etRemarks1);
        etRemarks2 = (EditText) view.findViewById(R.id.etRemarks2);
        etRemarks3 = (EditText) view.findViewById(R.id.etRemarks3);

        btnSave = (Button) view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnSave) {
            getActivity().finish();
        }
    }
}
