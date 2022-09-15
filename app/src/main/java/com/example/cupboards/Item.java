package com.example.cupboards;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Item {
    @PrimaryKey
    public int id;
    @ColumnInfo(name = "Name")
    public String Name;
    @ColumnInfo(name = "isExists")
    public int isExists;
    @ColumnInfo(name = "ParentName")
    public String ParentName;
}
