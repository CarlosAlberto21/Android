package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;
    private String nombres [] = {"Carlos", "Daniel", "Maria", "Javier", "Alexandra"};

    private String edad [] = {"18", "25", "30", "31", "24"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.txt_view);
        lv1 = (ListView)findViewById(R.id.level1);

        ArrayAdapter <String> adapter = new ArrayAdapter<String> ( this, R.layout.list_item_carlos, nombres);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                tv1.setText("La edad de " + lv1.getItemAtPosition(i) + " es " + edad[i]+ " anos");
            }
        });
    }
}