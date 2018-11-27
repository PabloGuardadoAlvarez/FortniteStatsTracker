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

    List<FinalStats> statsList;
    ForniteTrackerRP forniteTrackerRP;
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
        changeData("","");


    }

    public void findByView() {
        recyclerView = findViewById(R.id.forniteRecycler);
        busquedatxt = findViewById(R.id.busquedatxt);
        btnsearch = findViewById(R.id.btnsearch);
        platform = findViewById(R.id.platfomSpinner);
    }

    private void changeData(String plataform, String epic_nickname) {

        forniteViewModel = ViewModelProviders.of(this).get(ForniteViewModel.class);

        forniteViewModel.playerDetailsMutableLiveData.observe(this, stadisticObjectData -> {
            if (stadisticObjectData != null) {
                Log.d("ServicioFornite", "Cambios: " + stadisticObjectData);
                generateForniteList(stadisticObjectData);
            }

        });
        forniteViewModel.getData(plataform,epic_nickname);
    }

    private void generateForniteList(List<FinalStats> listFornite) {
        recyclerView = findViewById(R.id.forniteRecycler);
        forniteTrackerAdapter = new ForniteTrackerAdapter(listFornite);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(forniteTrackerAdapter);
    }

    public void btnbuscar(View view){

       String plataform = platform.getSelectedItem().toString();
       String epic_nickname = busquedatxt.getText().toString();
        Log.d("Cambio","plataforma "+plataform+" epic_name "+epic_nickname);
        changeData(plataform, epic_nickname);
        System.out.println(plataform);
        System.out.println(epic_nickname);
    }
}
