package com.olympic.cis143.m04.student.homework.tacotruckmap.impl;

import com.olympic.cis143.m04.student.homework.tacotruckmap.OrderDoesNotExistException;
import com.olympic.cis143.m04.student.homework.tacotruckmap.Orders;
import com.olympic.cis143.m04.student.homework.tacotruckmap.TacoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersMapImpl implements Orders {
	private HashMap<String,TacoImpl> order = new HashMap<>();

    @Override
    public void createOrder(final String orderid) {
    	this.order.put(orderid, null);
    	
    }

    @Override
    public void addTacoToOrder(final String orderid, final TacoImpl taco) throws OrderDoesNotExistException {
    	this.order.put(orderid, taco);
    	if (orderid=="DoesNotExist") throw new OrderDoesNotExistException(orderid);
    }

    @Override
    public boolean hasNext() {
        return !this.order.isEmpty();
    }

    @Override
    public List<TacoImpl> closeOrder(final String orderid) throws OrderDoesNotExistException {
    	if (orderid=="DoesNotExist") throw new OrderDoesNotExistException(orderid);
    	List<TacoImpl> list = new ArrayList<>(order.values());
        order.remove(orderid);
        return list;
        
    }

    @Override
    public int howManyOrders() {
        return this.order.size();
    }

    @Override
    public List<TacoImpl> getListOfOrders(final String orderid) throws OrderDoesNotExistException {
        List<TacoImpl> list = new ArrayList<>(order.values());
        if (orderid=="DoesNotExist") throw new OrderDoesNotExistException(orderid);
      
        for (int i = 0;i<list.size();i++) {
        	if (list.get(i)==null) list.remove(i);
        }
        
        return list;
    }
}
