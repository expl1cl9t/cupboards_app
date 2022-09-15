package com.example.cupboards;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CupboardDAO{
    @Query("SELECT * FROM Cupboard")
    List<Cupboard> getAll();

    @Insert
    void insert(Cupboard cup);

    @Delete
    void delete(Cupboard cup);

    @Query("DELETE FROM cupboard")
    void deleteAll();
}
