package com.sleepy.zeo.bean;

import java.util.List;

public class UserOrderBean {
    private int id;
    private String username;
    private String password;
    private List<OrderBean> orders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<OrderBean> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderBean> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "UserOrderBean[" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", orders=" + orders +
                ']';
    }
}
