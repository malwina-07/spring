package pl.sda.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.model.Order;
import pl.sda.repository.OrderRepository;
import pl.sda.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaOrderService implements OrderService { // komunikacja z bazą danych

    private final OrderRepository orderRepository;

    public JpaOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order getById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAll() {

        List<Order> result = new ArrayList<>();

        orderRepository.findAll().forEach(o -> result.add(o));
        return result;
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }
}
