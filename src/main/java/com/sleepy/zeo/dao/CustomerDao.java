package com.sleepy.zeo.dao;

import com.sleepy.zeo.bean.CustomerBean;

import java.util.List;

public interface CustomerDao {
    List<CustomerBean> fetchAllCustomers();
}
