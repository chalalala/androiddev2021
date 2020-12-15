package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast; // Use Toast class to display message

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.io.InputStream;

public class WeatherActivity extends AppCompatActivity {
//    FragmentPagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // Create a new fragment to be placed in the activity
//        ForecastFragment firstFragment = new ForecastFragment();
//        WeatherFragment secondFragment = new WeatherFragment();

        // Add the fragment to the 'container' FrameLayout
//        getSupportFragmentManager().beginTransaction().add(R.id.container, secondFragment).commit();
//        getSupportFragmentManager().beginTransaction().add(R.id.container, firstFragment).commit();

        // View Pager
        PagerAdapter adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager()
        );
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);

        MediaPlayer music = MediaPlayer.create(this, R.raw.theme_song);
        music.start();
    }

    @Override
    public void onStart() {
        super.onStart();
//        Toast.makeText(getApplicationContext(),"Now onStart() calls", Toast.LENGTH_LONG).show(); //onStart Called
        Log.i("WeatherActivity", "onStart"); // Send an INFO log message
    }

    @Override
    public void onResume() {
        super.onResume();
//        Toast.makeText(getApplicationContext(),"Now onResume() calls", Toast.LENGTH_LONG).show();
        Log.i("WeatherActivity", "onResume"); // Send an INFO log message
    }

    @Override
    public void onPause() {
        super.onPause();
//        Toast.makeText(getApplicationContext(),"Now onPause() calls", Toast.LENGTH_LONG).show();
        Log.i("WeatherActivity", "onPause"); // Send an INFO log message
    }

    @Override
    public void onStop() {
        super.onStop();
//        Toast.makeText(getApplicationContext(),"Now onStop() calls", Toast.LENGTH_LONG).show();
        Log.i("WeatherActivity", "onStop"); // Send an INFO log message
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        Toast.makeText(getApplicationContext(),"Now onDestroy() calls", Toast.LENGTH_LONG).show();
        Log.i("WeatherActivity", "onDestroy"); // Send an INFO log message
    }
}
