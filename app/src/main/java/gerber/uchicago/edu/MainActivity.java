package gerber.uchicago.edu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by Edwin on 15/02/2015.
 */
public class MainActivity extends ActionBarActivity implements Tab2.OnTab2InteractionListener, ViewPager.OnPageChangeListener{

    // Declaring Your View and Variables
    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence mCharSequences[]={"list","grid", "edit", "new"};
    int mNumboftabs =4;
    Toolbar actionBar;
    int mPos;


   //private Menu mMenu;

   // private Drawable oldBackground = null;
    private int currentColor;
    private SystemBarTintManager mTintManager;
   // private LayoutInflater mInflator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = (Toolbar) findViewById(R.id.tool_bar);

//        mInflator = (LayoutInflater) this
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        // Creating The Toolbar and setting it as the Toolbar for the activity
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // create our manager instance after the content view is set
        mTintManager = new SystemBarTintManager(this);
        // enable status bar tint
        mTintManager.setStatusBarTintEnabled(true);

        // Creating The ViewPagerAdapter and Passing Fragment Manager, mCharSequences fot the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(), mCharSequences, mNumboftabs);
        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);

        pager.setAdapter(adapter);
        mPos = 0;

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available wid

        tabs.setOnPageChangeListener(this );

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {

               // Log.d(String.valueOf(position), "TAGGER");


                return getResources().getColor(R.color.tabsScrollColor);

            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
        changeColor(getResources().getColor(R.color.purple_dark), getResources().getColor(R.color.purple));

    }

    private void changeColor(int newColor, int tabColor) {
        tabs.setBackgroundColor(tabColor);


        mTintManager.setTintColor(newColor);
        // change ActionBar color just if an ActionBar is available
        Drawable colorDrawable = new ColorDrawable(newColor);
       // Drawable bottomDrawable = new ColorDrawable(getResources().getColor(android.R.color.transparent));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        currentColor = newColor;

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // this.mMenu = menu;
        getMenuInflater().inflate(R.menu.reminders_menu, menu);
        return true;
    }


    public boolean onPrepareOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();

        MenuItem mnu1 = menu.getItem(0);
        MenuItem mnu2 = menu.getItem(1);
        MenuItem mnu3 = menu.getItem(2);


        switch(mPos){
            case 0:

                break;
            case 1:
                mnu2.setVisible(false);
                break;
            case 2:

                break;
            case 3:

                break;
        }





//        TextView title  = (TextView) findViewById(R.id.title);
//        menu.getItem(0).setTitle(
//                getString(R.string.payFor) + " " + title.getText().toString());
//        menu.getItem(1).setTitle(getString(R.string.payFor) + "...");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

//    public Menu getMenu() {
//        return mMenu;
//    }
//
//    public void setMenu(Menu menu) {
//        mMenu = menu;
//    }

    @Override
    public void onTab2Interaction(String id) {

    }


    @Override
    public void onPageSelected(int position) {

        switch(position){
            case 0:
                 mPos = 0;
                changeColor(getResources().getColor(R.color.purple_dark), getResources().getColor(R.color.purple));
                break;
            case 1:
                changeColor(getResources().getColor(R.color.purple_dark), getResources().getColor(R.color.purple));
                 mPos = 1;
                break;
            case 2:
                changeColor(getResources().getColor(R.color.orange_dark), getResources().getColor(R.color.orange));
                 mPos = 2;
                break;
            case 3:
                changeColor(getResources().getColor(R.color.green_dark), getResources().getColor(R.color.green));
                 mPos = 3;
                break;
        }
        invalidateOptionsMenu(); //this will call onPreare
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}