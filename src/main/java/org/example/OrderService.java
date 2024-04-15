package org.example;

public class OrderService {
    OrderDao orderDao;
    public OrderService(OrderDao orderDao){
        this.orderDao = orderDao;
    }
    public void createOrder(Order order){
        orderDao.saveOrder(order);
    }
    public void setOrderDao(OrderDao orderDao){
        this.orderDao = orderDao;
    }
}
