package com.fabio.professor.aulacinco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        loadListView();
    }

    private void loadListView() {
        final String[] values = new String[]{
                "José",
                "Mario",
                "Roberto",
                "Andressa",
                "Nina",
                "Conceição",
                "João",
                "Luis"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long id) {
                String texto = listView.getItemAtPosition(position).toString();

                Toast.makeText(MainActivity.this, "Posição: " + position
                                + " Item: " + texto,
                        Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view,
                                           int position, long id) {

                String texto = listView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Long -> Posição: " + position
                                + " Item: " + texto,
                        Toast.LENGTH_SHORT).show();

                //return true não dispara o OnItemClick,
                //return false dispara o OnItemClick após esta execução
                return true;
            }
        });
    }

}
