package vn.edu.usth.weather;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForecastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForecastFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ForecastFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForecastFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForecastFragment newInstance(String param1, String param2) {
        ForecastFragment fragment = new ForecastFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
//        view.setBackgroundColor(Color.parseColor("#f0f0ff"));

        LinearLayout llayout = (LinearLayout) view.findViewById(R.id.llayout);

        int[] dates = {R.string.mon, R.string.tue, R.string.wed, R.string.thu, R.string.fri, R.string.sat, R.string.sun};

        for (int i=0; i<dates.length; i++){
            // Create LinearLayout
            LinearLayout row = new LinearLayout(this.getActivity());
            LinearLayout.LayoutParams row_params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 200, 0);
            row_params.setMargins(0, 10, 0, 10);
            row.setLayoutParams(row_params);
            row.setOrientation(LinearLayout.HORIZONTAL);

            // Parameter for the first two columns
            LinearLayout.LayoutParams first_params = new LinearLayout.LayoutParams(
                    0, 120, 3f);

            // Date of week
            TextView dText = new TextView(this.getContext());
            row_params.setMargins(0, 10, 0, 10);
            dText.setText(dates[i]);
            dText.setGravity(Gravity.CENTER_VERTICAL);
            dText.setLayoutParams(first_params);
            row.addView(dText);

            // Random status
            int[] icons = {R.drawable.sun, R.drawable.wind, R.drawable.rain1, R.drawable.cloudy};
            String[] stt = {"Sunny", "Windy", "Rainy", "Cloudy"};
            int n = (int)(Math.random()*4);

            // Icons
            ImageView icon = new ImageView(this.getContext());
            icon.setImageResource(icons[n]);
            icon.setLayoutParams(first_params);
            row.addView(icon);

            // Description
            LinearLayout des = new LinearLayout(this.getActivity());
            LinearLayout.LayoutParams des_params = new LinearLayout.LayoutParams(
                    0, 120, 7f);
            des_params.setMargins(60, 0, 0, 0);
            des.setLayoutParams(des_params);
            des.setGravity(Gravity.CENTER_VERTICAL);
            des.setOrientation(LinearLayout.VERTICAL);

            LinearLayout.LayoutParams text_params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, 0, 1f);

            TextView status = new TextView(this.getContext());
            status.setText(stt[n]);
            status.setLayoutParams(text_params);
            des.addView(status);

            // Random temperature
            int num1 = (int)(Math.random()*15+20);
            int num2 = num1 + (int)(Math.random()+5);

            TextView temp = new TextView(this.getContext());
            temp.setText(num1 + "C - " + num2 + "C");
            temp.setLayoutParams(text_params);
            des.addView(temp);

            row.addView(des);
            llayout.addView(row);
        }

        return view;
    }

}