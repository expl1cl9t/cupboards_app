package com.example.cupboards;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cupboard {
    @PrimaryKey
    public int id;
    @ColumnInfo(name = "Name")
    public String Name;
}

