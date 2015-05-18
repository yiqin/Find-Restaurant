package gerber.uchicago.edu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by Edwin on 15/02/2015.
 */
public class MainActivity extends ActionBarActivity implements Tab2.OnTab2InteractionListener {

    // Declaring Your View and Variables
//ImageButton mImageButton;
    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence mCharSequences[]={"list","grid", "details"};
    int mNumboftabs =3;
    Toolbar actionBar;

    private Menu mMenu;
    //for collors
   // private Drawable oldBackground = null;
    private int currentColor;
    private SystemBarTintManager mTintManager;
    private LayoutInflater mInflator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //action-bar

        actionBar = (Toolbar) findViewById(R.id.tool_bar);


        mInflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);






//        mImageButton = (ImageButton)findViewById(R.id.runCommand);
//        mImageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "clicked floating", Toast.LENGTH_SHORT).show();
//
//            }
//        });

        // Creating The Toolbar and setting it as the Toolbar for the activity

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        // create our manager instance after the content view is set
        mTintManager = new SystemBarTintManager(this);
        // enable status bar tint
        mTintManager.setStatusBarTintEnabled(true);


        // Creating The ViewPagerAdapter and Passing Fragment Manager, mCharSequences fot the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(), mCharSequences, mNumboftabs);


        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width




        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {


              //  actionBar.setBackgroundDrawable(new ColorDrawable(R.color.purple_dark));
                // actionBar.setIcon(R.drawable.ic_action_search);

           //    View rootMenuView = null;


                switch(position){
                    case 0:

                        changeColor(getResources().getColor(R.color.purple_dark), getResources().getColor(R.color.purple));
                      //  rootMenuView = mInflator.inflate(R.layout.action_bar_list, null);
                        break;
                    case 1:

                        changeColor(getResources().getColor(R.color.purple_dark), getResources().getColor(R.color.purple));

                       // return getResources().getColor(R.color.green_dark);
                        break;

                    case 2:
                        changeColor(getResources().getColor(R.color.green_dark), getResources().getColor(R.color.green));
                     //   return getResources().getColor(R.color.orange_dark);
                       // rootMenuView = mInflator.inflate(R.layout.action_bar_details, null);

                      //  return getResources().getColor(R.color.purple_dark);
                        break;



                }

//                final View paramView = rootMenuView;
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        actionBar.addView(paramView);
//                    }
//                });


                return getResources().getColor(R.color.tabsScrollColor);

            }
        });



        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);



    }

    private void changeColor(int newColor, int tabColor) {
        tabs.setBackgroundColor(tabColor);


        mTintManager.setTintColor(newColor);
        // change ActionBar color just if an ActionBar is available
        Drawable colorDrawable = new ColorDrawable(newColor);
       // Drawable bottomDrawable = new ColorDrawable(getResources().getColor(android.R.color.transparent));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        currentColor = newColor;
//        View v = tabs.getChildAt(1);
//        Drawable drawable=  v.getBackground();
//        if (drawable!=null) {
//          //  drawable.setAlpha(220);
//            v.setBackgroundColor(getResources().getColor(R.color.green));
//        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.mMenu = menu;
        getMenuInflater().inflate(R.menu.reminders_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public Menu getMenu() {
        return mMenu;
    }

    public void setMenu(Menu menu) {
        mMenu = menu;
    }

    @Override
    public void onTab2Interaction(String id) {

    }
}