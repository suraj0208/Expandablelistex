package com.suraj.expandablelistex;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    MyAdapter myAdapter;
    ExpandableListView exp_list;
    List<String> headers;
    HashMap<String, List<String>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        exp_list = (ExpandableListView) findViewById(R.id.exp_list);

        addlist();

        myAdapter = new MyAdapter(this, headers, null);

        exp_list.setAdapter(myAdapter);




    }

    public void addlist()
    {
        headers = new ArrayList<String>();

        headers.add("Monday");
        headers.add("Tuesday");
        headers.add("Wednesday");
        headers.add("Thursday");
        headers.add("Friday");
        headers.add("Saturday");

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
}
