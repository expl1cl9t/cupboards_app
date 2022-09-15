package com.example.cupboards;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Random;

public class MainViewModel extends ViewModel {
    MutableLiveData<List<String>> data;
    public LiveData<List<String>>getData(){
        if(data==null){
            data = new MutableLiveData<>();
            loadData();
        }
        return  data;
    }
    private void loadData(){
        List<Cupboard>cups =  App.getInstance().getDB().cupboardDAO().getAll();
        List<String>names = null;
        for(int i =  0;i<=cups.size() - 1; i++){
            names.add(cups.get(i).Name);
        }
        data.postValue(names);
    }
    public void addCupboard(String Name){
        Cupboard cup = new Cupboard();
        cup.Name = Name;
        cup.id = new Random().nextInt(100);
        App.getInstance().getDB().cupboardDAO().insert(cup);
        loadData();
    }
}
