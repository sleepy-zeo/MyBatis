package com.sleepy.zeo.dao;

import com.sleepy.zeo.bean.OrderBean;
import com.sleepy.zeo.bean.OrderUserBean;

import java.util.List;

public interface OrderDao {

    List<OrderUserBean> fetchAllOrders();
}
