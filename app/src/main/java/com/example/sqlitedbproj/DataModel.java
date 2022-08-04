package com.example.sqlitedbproj;

public class DataModel
{
    private String name;
    private String description;
    private String price;
    private String calories;
    private String id;

    public DataModel() {
        // empty constructor required for firebase.
    }

    // constructor for our object class.
    public DataModel(String name, String description, String price, String calories, String id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.calories=calories;
        this.id = id;
    }

    // getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
