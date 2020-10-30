package com.sleepy.zeo.bean;

public class OrderUserBean {
    private int id;
    private String orderno;
    private double amount;
    private UserBean user;

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

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OrderUserBean[" +
                "id=" + id +
                ", orderno='" + orderno + '\'' +
                ", amount=" + amount +
                ", user=" + user +
                ']';
    }
}
