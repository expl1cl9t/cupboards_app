package com.example.cupboards;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Cupboard.class, Item.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CupboardDAO cupboardDAO();
    //public abstract ItemDAO itemDAO;
}
