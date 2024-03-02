package model;

import java.time.LocalDateTime;

public class Inventory {

    private int inventoryId;
    private String isbn;
    private LocalDateTime storeTime;
    private String status;

    public Inventory() {
    }

    public Inventory(int inventoryId, String isbn, LocalDateTime storeTime, String status) {
        this.inventoryId = inventoryId;
        this.isbn = isbn;
        this.storeTime = storeTime;
        this.status = status;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDateTime getStoreTime() {
        return storeTime;
    }

    public void setStoreTime(LocalDateTime storeTime) {
        this.storeTime = storeTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
