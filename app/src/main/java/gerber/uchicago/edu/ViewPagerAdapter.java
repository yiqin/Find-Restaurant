package gerber.uchicago.edu;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.Random;

/**
 * Created by Edwin on 15/02/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the mCharSequences of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created

    int mPlacesId;

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }


    public int getPlacesId() {
        return mPlacesId;
    }

    public void setPlacesId(int nPlacesId) {
        this.mPlacesId = nPlacesId;
    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {


        switch (position){

            //list view
            case 0:
                Tab2 tab2 = new Tab2();
                return tab2;

            //grid view
            case 1:
                Tab3 tab3 = Tab3.newInstance(new Random().nextInt(99999999) , true);
                return tab3;
            case 2:
                Tab1 tab1 = new Tab1();
                return tab1;
            case 3:
                Tab4 tab4 = new Tab4();
                return tab4;
            default:
                Tab1 tabdefault = new Tab1();
                return tabdefault;
        }
    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}