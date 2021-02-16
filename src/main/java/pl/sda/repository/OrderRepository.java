package pl.sda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    /*
     CrudRepository< encja, typ naszego id > -
     zawiera kilka metod już zdefiniowane. Są to metody CRUD'owe create read update delete
     Springboot sam utworzy bean który jest implementacją CrudRepository
     czyli mozemy korzystać z OrderRepository jako obiektu

     */

    // metoda wyszukująca zamówienie na podstawie nazwy zamówienia

     List<Order> findByProductName(String productName); // select * from Orders where product_name = productName

}
