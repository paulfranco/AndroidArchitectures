package co.paulfran.paulfranco.androidarchitectures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import co.paulfran.paulfranco.androidarchitectures.mvc.MVCActivity;
import co.paulfran.paulfranco.androidarchitectures.mvp.MVPActivity;
import co.paulfran.paulfranco.androidarchitectures.mvvm.MVVMActivity;

public class ArchitecturesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architectures);
    }

    public void onMVC(View view) {
        startActivity(MVCActivity.getIntent(this));
    }

    public void onMVP(View view) {
        startActivity(MVPActivity.getIntent(this));
    }

    public void onMVVM(View view) {
        startActivity(MVVMActivity.getIntent(this));
    }


}
