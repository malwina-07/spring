package pl.sda.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.model.Order;
import pl.sda.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryOrderService implements OrderService {

    private List<Order> orders = new ArrayList<>();
    private int nextId = 1;

    @Override
    public Order getById(Integer id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        throw new IllegalArgumentException("Brak zamówienia dla id: " + id);
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public void save(Order order) {
        order.setId(nextId++);
        orders.add(order);
    }

    @Override
    public void delete(Integer id) {
        orders.remove(id);

    }
}
