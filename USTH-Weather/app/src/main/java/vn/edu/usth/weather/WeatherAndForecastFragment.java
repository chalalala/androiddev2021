package vn.edu.usth.weather;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WeatherAndForecastFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM = "param";

    // TODO: Rename and change types of parameters
    private String param;

    public WeatherAndForecastFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static WeatherAndForecastFragment newInstance(String param) {
        WeatherAndForecastFragment fragment = new WeatherAndForecastFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather_and_forecast, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
//        insertNestedFragment();
        TextView location = (TextView) view.findViewById(R.id.location);
        location.setText(param);
    }

    // Embeds the child fragment dynamically
    private void insertNestedFragment() {
        WeatherFragment childFragment1 = new WeatherFragment();
        ForecastFragment childFragment2 = new ForecastFragment();
        getChildFragmentManager().beginTransaction()
        .replace(R.id.child_fragment_container, childFragment1)
            .add(R.id.child_fragment_container, childFragment2)
            .commit();
    }
}
