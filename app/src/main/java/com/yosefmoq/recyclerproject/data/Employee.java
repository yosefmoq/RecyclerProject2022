package com.yosefmoq.recyclerproject.data;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "employee")
public class Employee {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "emp_id")
    private int id;

    private String name;
    private String email;
    private int image;

    public Employee(String name, String email, int image) {
        this.name = name;
        this.email = email;
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
