package ru.boltachev.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public abstract class Employee {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("skills")
    @Expose
    private List<String> skills = null;

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<String> getSkills() {
        return skills;
    }

}