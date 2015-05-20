package gerber.uchicago.edu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by Edwin on 15/02/2015.
 */
public class MainActivity extends ActionBarActivity implements Tab2.OnTab2InteractionListener, ViewPager.OnPageChangeListener {

    // Declaring Your View and Variables

    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence mCharSequences[] = {"list", "grid", "edit", "new"};
    int mNumboftabs = 4;
    ActionBar actionBar;
    int mPos;

    boolean bButtonArray[] = new boolean[4];


    //private Menu mMenu;

    // private Drawable oldBackground = null;
    private int currentColor;
    private SystemBarTintManager mTintManager;
    // private LayoutInflater mInflator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //   actionBar = (Toolbar) findViewById(R.id.tool_bar);

//        mInflator = (LayoutInflater) this
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        // Creating The Toolbar and setting it as the Toolbar for the activity
        // toolbar = (Toolbar) findViewById(R.id.tool_bar);
        //  setSupportActionBar(toolbar);
        //  toolbar.setTitle("");
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);


        // create our manager instance after the content view is set
        mTintManager = new SystemBarTintManager(this);
        // enable status bar tint
        mTintManager.setStatusBarTintEnabled(true);

        // Creating The ViewPagerAdapter and Passing Fragment Manager, mCharSequences fot the Tabs and Number Of Tabs.
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), mCharSequences, mNumboftabs);
        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);

        pager.setAdapter(adapter);
        mPos = 0;

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available wid

        tabs.setOnPageChangeListener(this);

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


        if (savedInstanceState == null){
            bButtonArray[0] = true;
            for (int nC = 1; nC < 4; nC++) {
                bButtonArray[nC] = false;
           }

        } else {

            //get it from the prefs
        }
        inflateActionBar(actionBar, 0);


    }

    private void inflateActionBar(ActionBar bar, int pos) {

        // invalidateOptionsMenu();

        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.ab_custom, null);
        // ActionBar actionBar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(false);
        bar.setDisplayShowHomeEnabled(false);
        bar.setDisplayShowCustomEnabled(true);
        bar.setDisplayShowTitleEnabled(false);
        bar.setCustomView(v);


        ImageButton v0 = (ImageButton) v.findViewById(R.id.action_0);
        v0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("view0", "GGG");
                bButtonArray[0] = !bButtonArray[0];
                bButtonArray[1] = !bButtonArray[1];
                toggleActionBarButton(0, bButtonArray[0]);
                toggleActionBarButton(1, bButtonArray[1]);
                //inflateActionBar(actionBar,0);
            }
        });
        ImageButton v1 = (ImageButton) v.findViewById(R.id.action_1);
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("view1", "GGG");
                bButtonArray[1] = !bButtonArray[1];
                bButtonArray[0] = !bButtonArray[0];
                toggleActionBarButton(0, bButtonArray[0]);
                toggleActionBarButton(1, bButtonArray[1]);

                // inflateActionBar(actionBar,1);
            }
        });
        ImageButton v2 = (ImageButton) v.findViewById(R.id.action_2);
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("view2", "GGG");
                bButtonArray[2] = !bButtonArray[2];
                toggleActionBarButton(2, bButtonArray[2]);
                // inflateActionBar(actionBar,2);
            }
        });
        ImageButton v3 = (ImageButton) v.findViewById(R.id.action_3);
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("view3", "GGG");
                bButtonArray[3] = !bButtonArray[3];
                toggleActionBarButton(3, bButtonArray[3]);
                // inflateActionBar(actionBar, 3);
            }
        });

        //use position to switch the gone/view


        // MenuInflater inflater = getMenuInflater();
        for (int nC = 0; nC < bButtonArray.length; nC++) {
            toggleActionBarButton(nC, bButtonArray[nC]);
        }


    }

//    private void inflateActionBar(ActionBar bar, int pos ) {
//        LayoutInflater inflator = (LayoutInflater) this
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View v = inflator.inflate(R.layout.ab_custom, null);
//        // ActionBar actionBar = getSupportActionBar();
//        bar.setDisplayHomeAsUpEnabled(false);
//        bar.setDisplayShowHomeEnabled (false);
//        bar.setDisplayShowCustomEnabled(true);
//        bar.setDisplayShowTitleEnabled(false);
//        bar.setCustomView(v);
//    }


    private void toggleActionBarButton(int pos, final boolean checked) {

        int nId = getResourceId("fram_button_" + pos, "id", getPackageName());
        final LinearLayout ll = (LinearLayout) findViewById(nId);
        int nIdTopBar = getResourceId("topbar_button_" + pos, "id", getPackageName());
        final View vTopBar = ll.findViewById(nIdTopBar);
        int nButton = getResourceId("action_" + pos, "id", getPackageName());
        final ImageButton imageButton = (ImageButton) ll.findViewById(nButton);


        if (checked) {
            vTopBar.setVisibility(View.VISIBLE);
            imageButton.setBackground(getResources().getDrawable(R.drawable.pressed_mask));
        } else {
            vTopBar.setVisibility(View.INVISIBLE);
            imageButton.setBackground(getResources().getDrawable(R.drawable.unpressed_mask));
        }

        int nDp = dpToPx(4);
        imageButton.setPadding(nDp, nDp, nDp, nDp);

    }

    //http://stackoverflow.com/questions/8309354/formula-px-to-dp-dp-to-px-android
    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    //http://stackoverflow.com/questions/4427608/android-getting-resource-id-from-string
    public int getResourceId(String pVariableName, String pResourcename, String pPackageName) {
        try {
            return getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
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
        // getMenuInflater().inflate(R.menu.reminders_menu, menu);
        return true;
    }


//    public boolean onPrepareOptionsMenu (Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//
//        MenuItem mnu1 = menu.getItem(0);
//        MenuItem mnu2 = menu.getItem(1);
//        MenuItem mnu3 = menu.getItem(2);
//
//
//        switch(mPos){
//            case 0:
//
//                break;
//            case 1:
//                mnu2.setVisible(false);
//                break;
//            case 2:
//
//                break;
//            case 3:
//
//                break;
//        }
//
//
//
//
//
////        TextView title  = (TextView) findViewById(R.id.title);
////        menu.getItem(0).setTitle(
////                getString(R.string.payFor) + " " + title.getText().toString());
////        menu.getItem(1).setTitle(getString(R.string.payFor) + "...");
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return true;

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

        switch (position) {
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
        // invalidateOptionsMenu();
        //  inflateActionBar(actionBar, position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}