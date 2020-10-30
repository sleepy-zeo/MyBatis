package com.sleepy.zeo.dao;

import com.sleepy.zeo.bean.UserOrderBean;

import java.util.List;

public interface UserDao {
    List<UserOrderBean> fetchAllUsers();
}
