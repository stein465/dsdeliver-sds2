package com.stein.dsdeliver.services;


import com.stein.dsdeliver.dto.OrderDTO;
import com.stein.dsdeliver.entities.Order;
import com.stein.dsdeliver.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> list = repository.findOrdersWithProducts ();
        return list.stream ().map ( x -> new OrderDTO (x)).collect( Collectors.toList());
    }
}
