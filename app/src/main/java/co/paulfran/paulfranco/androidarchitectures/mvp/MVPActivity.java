package co.paulfran.paulfranco.androidarchitectures.mvp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.paulfran.paulfranco.androidarchitectures.R;
import co.paulfran.paulfranco.androidarchitectures.mvc.CountriesController;
import co.paulfran.paulfranco.androidarchitectures.mvc.MVCActivity;

public class MVPActivity extends AppCompatActivity implements CountriesPresenter.View{

    private List<String> listValues = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;
    private CountriesPresenter presenter;
    private Button retryButton;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        setTitle("MVP");

        presenter = new CountriesPresenter(this);

        list = findViewById(R.id.list);
        retryButton = findViewById(R.id.retryButton);
        progress = findViewById(R.id.progress);

        adapter = new ArrayAdapter<>(this, R.layout.row_layout, R.id.listText, listValues);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MVPActivity.this, "You Clicked " + listValues.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        ArrayList<String> vals = new ArrayList<String>();

        setValues(vals);
    }

    @Override
    public void setValues(List<String> countries) {
        listValues.clear();
        listValues.addAll(countries);
        retryButton.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
        list.setVisibility(View.VISIBLE);
        adapter.notifyDataSetChanged();
    }

    public void onRetry(View view) {
        presenter.onRefresh();
        list.setVisibility(View.GONE);
        retryButton.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);

    }

    @Override
    public void onError() {
        Toast.makeText(this, R.string.message_error, Toast.LENGTH_SHORT).show();
        progress.setVisibility(View.GONE);
        list.setVisibility(View.GONE);
        retryButton.setVisibility(View.VISIBLE);
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MVPActivity.class);
    }
}
