package org.example.servlets;

public class Product {
    private String id;
    private String title;
    private String cost;

    public Product(String id, String title, String cost){
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCost() {
        return cost;
    }
}
