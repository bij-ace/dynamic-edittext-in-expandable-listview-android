package com.example.dell.addviewsinlistitem;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<ListItemModel> arrayList;

    ExpandableListView elv;
    CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<>();
        arrayList.add(new ListItemModel("Title 1"));
        arrayList.add(new ListItemModel("Title 2"));
        arrayList.add(new ListItemModel("Title 3"));
        arrayList.add(new ListItemModel("Title 4"));
        arrayList.add(new ListItemModel("Title 5"));
        arrayList.add(new ListItemModel("Title 6"));
        arrayList.add(new ListItemModel("Title 7"));
        arrayList.add(new ListItemModel("Title 8"));
        arrayList.add(new ListItemModel("Title 9"));
        arrayList.add(new ListItemModel("Title 10"));

        elv = (ExpandableListView)findViewById(R.id.listview);
        adapter = new CustomListAdapter(MainActivity.this, arrayList);
        adapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        elv.setAdapter(adapter);

        Button btn = (Button)findViewById(R.id.show);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String all="";
                for (int i=0; i<arrayList.size(); i++){
                    for (int j=0; j<arrayList.get(i).getArrayList().size(); j++) {
                        all += arrayList.get(i).getArrayList().get(j).getValue() + "\n";
                    }
                }
                Toast.makeText(MainActivity.this, all, Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds groupItem to the action bar if it is present.
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
