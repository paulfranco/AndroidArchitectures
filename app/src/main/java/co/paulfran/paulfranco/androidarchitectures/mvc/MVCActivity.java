package co.paulfran.paulfranco.androidarchitectures.mvc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.paulfran.paulfranco.androidarchitectures.R;

public class MVCActivity extends AppCompatActivity {

    private List<String> listValues = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        setTitle("MVC");

        list = findViewById(R.id.list);
        adapter = new ArrayAdapter<>(this, R.layout.row_layout, R.id.listText, listValues);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MVCActivity.this, "You Clicked " + listValues.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        ArrayList<String> vals = new ArrayList<String>();
        vals.add("USA");
        vals.add("Mexico");
        vals.add("UK");
        vals.add("China");
        vals.add("France");
        vals.add("USA");
        vals.add("Mexico");
        vals.add("UK");
        vals.add("China");
        vals.add("France");
        vals.add("USA");
        vals.add("Mexico");
        vals.add("UK");
        vals.add("China");
        vals.add("France");
        setValues(vals);
    }

    public void setValues(List<String> values) {
        listValues.clear();
        listValues.addAll(values);
        adapter.notifyDataSetChanged();
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MVCActivity.class);
    }
}
