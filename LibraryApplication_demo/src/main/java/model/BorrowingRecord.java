package model;

import java.time.LocalDateTime;

public class BorrowingRecord {

    private int userId;
    private int inventoryId;
    private LocalDateTime borrowingTime;
    private LocalDateTime returnTime;

    public BorrowingRecord() {
    }

    public BorrowingRecord(int userId, int inventoryId, LocalDateTime borrowingTime, LocalDateTime returnTime) {
        this.userId = userId;
        this.inventoryId = inventoryId;
        this.borrowingTime = borrowingTime;
        this.returnTime = returnTime;
    }

    
	

	public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public LocalDateTime getBorrowingTime() {
        return borrowingTime;
    }

    public void setBorrowingTime(LocalDateTime borrowingTime) {
        this.borrowingTime = borrowingTime;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }

}
