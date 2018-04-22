package ru.boltachev.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    RecyclerView.Adapter adapter;


    Htc htc;

    HtcApi htcApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        htcApi = Controller.getApi();

        recyclerView = findViewById(R.id.employee_recycle_view);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        htcApi.getCompany("56fa31e0110000f920a72134").enqueue(new Callback<Htc>() {
            @Override
            public void onResponse(Call<Htc> call, Response<Htc> response) {
                htc = response.body();
                adapter = new EmployeeAdapter(htc);
                recyclerView.setAdapter(adapter);
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Htc> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });

    }
}