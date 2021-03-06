package vn.edu.usth.weather;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 3;
    private String[] title = {"Hanoi, Vietnam", "Paris, France", "Toulouse, France"};
    public HomeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public int getCount() {
        return PAGE_COUNT; // number of pages for a ViewPager
    }
    @Override
    public Fragment getItem(int page) {
    // returns an instance of Fragment corresponding to the specified page
        switch (page) {
            case 0: return WeatherAndForecastFragment.newInstance("Hanoi");
            case 1: return WeatherAndForecastFragment.newInstance("Paris");
            case 2: return WeatherAndForecastFragment.newInstance("Toulouse");

            default:
                return null;
        }
    }
    @Override
    public CharSequence getPageTitle(int page) {
        return title[page];
    }
}