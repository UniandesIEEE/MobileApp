package ramaieeeuniandes.ramaieeeuniandes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ramaieeeuniandes.ramaieeeuniandes.R;
import ramaieeeuniandes.ramaieeeuniandes.adapters.ViewPagerAdapter;
import ramaieeeuniandes.ramaieeeuniandes.concept.Event;
import ramaieeeuniandes.ramaieeeuniandes.concept.User;

public class ActivityRamaMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /**
     * Constant that models the status of QR result from QR scanner
     */
    public static final int QR_CODE_RESULT = 2001;

    //Data Management
    private static User mainUser;

    private static List<Event> events;

    private static List<User> users;

    //UI Management
    private TabLayout tabLayout;

    private ViewPager viewPager;

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rama_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAddEvent);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityRamaMain.this, ScannerActivity.class);
                startActivityForResult(intent, QR_CODE_RESULT);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Attribute initialization
        users = new ArrayList<>();
        mainUser = new User();
        events = new ArrayList<>();
        mainUser.setMyEvents(new ArrayList<Event>());
        initializeDummyData();

        //UI Management

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rama_main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static List<Event> getEvents(){
        return events;
    }

    public static List<User> getUsers(){
        return users;
    }

    public static User getMainUser() {
        return mainUser;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == QR_CODE_RESULT) {
            if (resultCode == RESULT_OK) {
                //Gets the scanned QR code
                String url = data.getData().toString();
                Toast.makeText(this, url, Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
     * Method that initializes a new detailed activity for an event
     * @param position in which the event is located at the fragment
     */
    public void startEventDetail(int position) {
        Intent intent = new Intent(ActivityRamaMain.this, EventDetailActivity.class);
        intent.putExtra("invoice", events.get(position));
        startActivity(intent);
    }

    /**
     * Method that initializes dummy data for testing app features
     */
    private void initializeDummyData() {

        User user = new User((long)0,"John Doe","j.doe",100,R.mipmap.ic_prof_pic);
        users.add(user);
        user = new User((long)1,"Bob","bob",200,R.mipmap.ic_prof_pic);
        users.add(user);
        user = new User((long)2,"Alice","alice",50,R.mipmap.ic_prof_pic);
        users.add(user);
        user = new User((long)3,"Jeff","jeff",300,R.mipmap.ic_prof_pic);
        users.add(user);

        Event event = new Event((long)0,"Taller de Soldadura",
                new Timestamp(System.currentTimeMillis()+20000),"ML 004",25,
                "Aprende a soldar",R.mipmap.logo_rama_negativo_rend,R.mipmap.logo_rama_sqd);
        events.add(event);
        event = new Event((long)1,"IEEExtreme",
                new Timestamp(System.currentTimeMillis()+30000),"ML 026",30,
                "Code",R.mipmap.logo_rama_negativo_rend,R.mipmap.logo_computer_sqd);
        events.add(event);
        event = new Event((long)3,"PEPQA",
                new Timestamp(System.currentTimeMillis()+40000),"ML 026",130,
                "Code",R.mipmap.logo_rama_negativo_rend,R.mipmap.logo_ias_sqd);
        events.add(event);
        event = new Event((long)2,"WIE Roadshow",
                new Timestamp(System.currentTimeMillis()+50000),"ML 004",25,
                "Aprende a soldar",R.mipmap.logo_rama_negativo_rend,R.mipmap.logo_wie_sqd);
        events.add(event);
        event = new Event((long)3,"Cazucá",
                new Timestamp(System.currentTimeMillis()+60000),"ML 026",30,
                "Code",R.mipmap.logo_rama_negativo_rend,R.mipmap.logo_css_sqd);
        events.add(event);

        mainUser.addEvent(event);
    }
}
