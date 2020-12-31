package vn.edu.usth.weather;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast; // Use Toast class to display message

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class WeatherActivity extends AppCompatActivity {
    final Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            // This method is executed in main thread
            String content = msg.getData().getString("server_response");
            Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
        }
    };

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

//        copyFiletoExternalStorage(R.raw.theme_song, "theme_song.mp3");
//        MediaPlayer music = MediaPlayer.create(this, R.raw.theme_song);
//        music.start();

//        Thread t = new Thread(new Runnable() {
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public void run() {
//            // this method is run in a worker thread
//                try {
//                // wait for 3 seconds to simulate a long network access
//                    Thread.sleep(3000);
//                }
//                catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                // Assume that we got our data from server
//                Bundle bundle = new Bundle();
//                bundle.putString("server_response", "some sample json here");
//                // notify main thread
//                Message msg = new Message();
//                msg.setData(bundle);
//                handler.sendMessage(msg);
//
//
//            }
//        });
//        t.start();

        AsyncTask<String, Integer, Bitmap> task = new AsyncTask<String, Integer, Bitmap>() {
            @Override
            protected void onPreExecute() {
                // do some preparation here, if needed
            }
            @Override
            protected Bitmap doInBackground(String... params) {
                // This is where the worker thread's code is executed
                // params are passed from the execute() method call
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onProgressUpdate(Integer... values) {
                // This method is called in the main thread, so it's possible
                // to update UI to reflect the worker thread progress here.
                // In a network access task, this should update a progress bar
                // to reflect how many percent of data has been retrieved
            }
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                // This method is called in the main thread. After #doInBackground returns
                // the bitmap data, we simply set it to an ImageView using ImageView.setImageBitmap()
                //                // Assume that we got our data from server
                Bundle bundle = new Bundle();
                bundle.putString("server_response", "some sample json here");
                // notify main thread
                Message msg = new Message();
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        };
        task.execute("http://ict.usth.edu.vn/wp-content/uploads/usth/usthlogo.png");
    }


    private void copyFiletoExternalStorage(int resourceId, String resourceName){

        try{
//            File file = new File(getExternalFilesDir(null), resourceName);
            File file = new File(getExternalFilesDir(null), resourceName);
            InputStream in = getResources().openRawResource(resourceId);
            FileOutputStream out = new FileOutputStream(file);
            byte[] buff = new byte[1024];
            int read = 0;
            try {
                while ((read = in.read(buff)) > 0) {
                    out.write(buff, 0, read);
                }
            } finally {
                in.close();
                out.close();
            }
        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Errors!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
            {
                Toast.makeText(getApplicationContext(), "Refreshing...", Toast.LENGTH_SHORT).show();
                recreate();
                return true;
            }
            case R.id.action_settings:
            {
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
                return true;
            }
            default:
                super.onOptionsItemSelected(item);
        }
        return false;
    }
}
