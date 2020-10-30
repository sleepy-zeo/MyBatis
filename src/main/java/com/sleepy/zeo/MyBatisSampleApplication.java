package com.sleepy.zeo;

import com.sleepy.zeo.bean.CustomerBean;
import com.sleepy.zeo.bean.OrderUserBean;
import com.sleepy.zeo.bean.UserOrderBean;
import com.sleepy.zeo.dao.CustomerDao;
import com.sleepy.zeo.dao.OrderDao;
import com.sleepy.zeo.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * 1. XxxDao.java <====> xxx-mapper.xml
 *
 * 2. 将xxx-mapper.xml在mybatis-config.xml中注册
 *      <mappers>
 *         <mapper resource="mappers/xxx-mapper.xml"/>
 *      </mappers>
 *
 * 3. Application中导入mybatis-config.xml
 */
@SuppressWarnings("ALL")
public class MyBatisSampleApplication {

    private static final int TYPE_INSERT = 1;
    private static final int TYPE_UPDATE = 2;
    private static final int TYPE_DELETE = 3;

    public static void main(String[] args) throws Exception {
        // 加载mybatis_config.xml
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 创建sqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 当sqlSessionFactory创建完成就不再需要sqlSessionFactoryBuilder，sqlSession完全由sqlSessionFactory生产
        SqlSessionFactory factory = builder.build(in);

        // 创建sqlSession，这里默认时不自动commit
        // 所以如果资源释放前没有commit，那么事务会自动回滚
        // sqlSession定义了数据库的操作方法，是线程不安全的，每个线程都应该有自己的SqlSession实例
        SqlSession sqlSession = factory.openSession();

        // 生成Dao接口代理对象
        CustomerDao userDao = sqlSession.getMapper(CustomerDao.class);

        // 执行Dao接口方法
        CustomerBean customerBean = userDao.fetchCustomer(10001);
        System.out.println("fetchCustomer: " + customerBean);

        List<CustomerBean> list = userDao.fetchCustomers("7", 14);
        for (CustomerBean c : list) {
            System.out.println("fetchCustomers: " + c);
        }

        List<CustomerBean> list2 = userDao.fetchAllCustomers();
        for (CustomerBean c : list2) {
            System.out.println("fetchAllCustomers: " + c);
        }

        int type = 1;

        if (type == TYPE_INSERT) {
            CustomerBean customer = new CustomerBean();
            customer.setId(10005);
            customer.setGender("f");
            customer.setName("alice");
            customer.setTelephone("13778654899");
            customer.setGrade("8");
            customer.setPassword("8888");
            customer.setAge(12);
            System.out.println(customer);
            userDao.insert(customer);
            sqlSession.commit();
            System.out.println(customer);
        }
        if (type == TYPE_UPDATE) {
            CustomerBean customer = new CustomerBean();
            customer.setId(10005);
            customer.setGender("f");
            customer.setName("alice");
            customer.setTelephone("13778654899");
            customer.setTelephone("1234567890");
            customer.setGender("f");
            customer.setGrade("8");
            customer.setPassword("8888");
            customer.setAge(12);
            userDao.update(customer);
            sqlSession.commit();
        }
        if (type == TYPE_DELETE) {
            userDao.delete(10005);
            sqlSession.commit();
        }

        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        List<OrderUserBean> li = orderDao.fetchAllOrders();
        for (OrderUserBean orderUserBean : li) {
            System.out.println("->" + orderUserBean);
        }

        UserDao userDao1 = sqlSession.getMapper(UserDao.class);
        List<UserOrderBean> ll = userDao1.fetchAllUsers();
        for (UserOrderBean bean : ll) {
            System.out.println("xx->" + bean);
        }

        // 释放资源
        sqlSession.close();
        in.close();
    }
}
