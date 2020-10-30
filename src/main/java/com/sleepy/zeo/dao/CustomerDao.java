package com.sleepy.zeo.dao;

import com.sleepy.zeo.bean.CustomerBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * dao接口中的所有方法都不可以出现重载，否则xml无法解析
 */
public interface CustomerDao {
    CustomerBean fetchCustomer(@Param("id") int id);

    List<CustomerBean> fetchCustomers(@Param("grade") String grade, @Param("age") int age);

    List<CustomerBean> fetchAllCustomers();

    void insert(CustomerBean customer);

    void update(CustomerBean customer);

    void delete(@Param("id") int id);
}
