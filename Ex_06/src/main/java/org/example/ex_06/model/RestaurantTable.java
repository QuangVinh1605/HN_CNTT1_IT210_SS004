package org.example.ex_06.model;

public class RestaurantTable {
    private Long id;
    private int capacity;
    private String status;

    public RestaurantTable(Long id, int capacity, String status) {
        this.id = id;
        this.capacity = capacity;
        this.status = status;
    }

    public Long getId() { return id; }
    public int getCapacity() { return capacity; }
    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }
}
