package com.example.cupboards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView cupid;
    private String cupName;
    List<String> cup;
    CupboardAdapter ad;
    String[] ids;
    MainViewModel viewModel;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = App.getInstance().getDB();
        cupid = findViewById(R.id.editTextTextPersonName);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getData().observe(this, cupboards -> cup = cupboards);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,SetData());
        ListView list = findViewById(R.id.list);
        list.setAdapter(ad);
    }
    public void addCupboard(View view){
        try {
            viewModel.addCupboard(cupid.getText().toString());
        }
        catch (Exception ex){
            cupid.setText(ex.toString());
        }
    }
    String[] SetData(){
        List<Cupboard>source = db.cupboardDAO().getAll();
        String[]arr = new String[source.size()];
        for(int i = 0;i<=source.size() - 1; i++){
            arr[i] = source.get(i).Name;
        }
        return arr;
    }
}