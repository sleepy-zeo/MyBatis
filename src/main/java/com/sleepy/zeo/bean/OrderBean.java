package com.sleepy.zeo.bean;

public class OrderBean {
    private int id;
    private String orderno;
    private double amount;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "OrderBean[" +
                "id=" + id +
                ", orderno='" + orderno + '\'' +
                ", amount=" + amount +
                ", userId=" + userId +
                ']';
    }
}
