package pablo.example.com.fortnitetracker;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import pablo.example.com.fortnitetracker.Adapter.ForniteTrackerAdapter;
import pablo.example.com.fortnitetracker.DTOs.FinalStats;
import pablo.example.com.fortnitetracker.Repository.ForniteTrackerRP;
import pablo.example.com.fortnitetracker.ViewModels.ForniteViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ForniteTrackerAdapter forniteTrackerAdapter;
    RecyclerView recyclerView;
    EditText busquedatxt;
    FloatingActionButton btnsearch;
    Spinner platform;
    private ForniteViewModel forniteViewModel;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findByView();
    }

    public void findByView() {
        recyclerView = findViewById(R.id.forniteRecycler);
        busquedatxt = findViewById(R.id.busquedatxt);
        btnsearch = findViewById(R.id.btnsearch);
        platform = findViewById(R.id.platfomSpinner);
    }

    private void getParameters(String plataform, String epicName) {

        forniteViewModel = ViewModelProviders.of(this).get(ForniteViewModel.class);

        forniteViewModel.playerDetailsMutableLiveData.observe(this, finalStats -> {
            if (finalStats != null) {
                System.out.println("----->Entra!!");
                generateStatsList(finalStats);
            }

        });
        forniteViewModel.getData(plataform, epicName);
    }

    private void generateStatsList(List<FinalStats> listFornite) {
        recyclerView = findViewById(R.id.forniteRecycler);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(forniteTrackerAdapter);
        forniteTrackerAdapter = new ForniteTrackerAdapter(listFornite);
    }

    public void btnbuscar(View view) {
        System.out.println("plataforma : ----> "+platform.getSelectedItem().toString());
        System.out.println("jugador: ---> "+busquedatxt.getText().toString());
        getParameters(platform.getSelectedItem().toString(),busquedatxt.getText().toString());
    }
}
