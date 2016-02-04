package com.example.dell.addviewsinlistitem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<EdittextValues> etValues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ListItemModel> arrayList = new ArrayList<>();
        arrayList.add(new ListItemModel("Title 1"));
        arrayList.add(new ListItemModel("Title 2"));
        arrayList.add(new ListItemModel("Title 3"));
        arrayList.add(new ListItemModel("Title 4"));
        arrayList.add(new ListItemModel("Title 5"));

        ListView lv = (ListView)findViewById(R.id.listview);
        lv.setItemsCanFocus(true);
        CustomListAdapter adapter = new CustomListAdapter(MainActivity.this, arrayList, etValues);
        lv.setAdapter(adapter);

        Button btn = (Button)findViewById(R.id.show);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String all="";
                for (int i=0; i<etValues.size(); i++){
                    all += etValues.get(i).getValue()+"\n";
                }
                Toast.makeText(MainActivity.this, all, Toast.LENGTH_LONG).show();
            }
        });
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
