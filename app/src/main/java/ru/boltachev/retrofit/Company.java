package ru.boltachev.retrofit;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Company {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("competences")
    @Expose
    private List<String> competences = null;
    @SerializedName("employees")
    @Expose
    private List<Employee> employees = null;

    public List<Employee> getEmployees() {
        return employees;
    }

}

