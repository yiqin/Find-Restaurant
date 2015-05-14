package gerber.uchicago.edu;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import gerber.uchicago.edu.R;

/**
 * Created by Edwin on 15/02/2015.
 */
public class MainActivity extends ActionBarActivity implements Tab2.OnTab2InteractionListener {

    // Declaring Your View and Variables
ImageButton mImageButton;
    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"search","list", "grid"};
    int Numboftabs =3;

    //for collors
   // private Drawable oldBackground = null;
    private int currentColor;
    private SystemBarTintManager mTintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageButton = (ImageButton)findViewById(R.id.runCommand);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked floating", Toast.LENGTH_SHORT).show();

            }
        });

        // Creating The Toolbar and setting it as the Toolbar for the activity

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        // create our manager instance after the content view is set
        mTintManager = new SystemBarTintManager(this);
        // enable status bar tint
        mTintManager.setStatusBarTintEnabled(true);


        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);


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

                switch(position){
                    case 0:
                        changeColor(getResources().getColor(R.color.green_dark), getResources().getColor(R.color.green));
                       // return getResources().getColor(R.color.green_dark);
                        break;
                    case 1:
                    case 2:
                        changeColor(getResources().getColor(R.color.purple_dark), getResources().getColor(R.color.purple));
                     //   return getResources().getColor(R.color.orange_dark);

                      //  return getResources().getColor(R.color.purple_dark);
                        break;



                }
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    @Override
    public void onTab2Interaction(String id) {

    }
}