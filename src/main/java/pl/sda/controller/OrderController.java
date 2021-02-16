package pl.sda.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.model.Order;
import pl.sda.service.OrderService;

import java.time.LocalDateTime;

@RequestMapping("/order")
@Controller
public class OrderController {

    // zapisywanie zamówień do servicu
    private final OrderService orderService;


    public OrderController(
            @Qualifier("jpaOrderService")
                    OrderService orderService) {
        this.orderService = orderService;
    }

    //zwracanie widoku html do przeglądarki
    @GetMapping("/create")
    public String createOrderForm(Model model){
        //Model - to argument naszej metody jest to pusty obiekt wysyłany do .html, to tak jakby Mapa zawierająca klucz (String) i wartość (różne metody) dzięki której mozemy cos wysłać na front-end
        // emptyOrder - referencja do obiektu wysyłany na widok html Obiekt ten jest pamiętany i uzupełniany
        model.addAttribute("emptyOrder", new Order());

        return "createOrder";
    }

    /*
     obsłuży akcje po zatwierdzeniu submitem
    @ModelAttribute - chcemy uzyskać obiekt "emptyOrder" i aby został on zapisany w obiekcie Order order

     */
    @PostMapping("/save")
    public String saveOrder(@ModelAttribute("emptyOrder") Order order){

        System.out.println("Zapisuje order: "+ order);

        order.setCreateDate(LocalDateTime.now());

        orderService.save(order);

//        return "welcome"; // forward -> przekierowanie (odesłanie do klienta zwyklej strony statycznej z widokiem html)

        return "redirect:/order/list";

        //redirect ->też przekierowanie ale zdecydowanie bardziej stosowane - dodatkowo adres url ulegnie zmianie
    }


    @GetMapping("/list")
    public String orderList(Model model){

        model.addAttribute("orders", orderService.getAll());

        return "orderList";
    }

    @GetMapping("/details/{orderId}")             // {orderId} -> klamry dają możliwość odniesienia się do zmiennej
    public String orderDetails(@PathVariable Integer orderId, Model model){      // @PathVariabl zmienna ze ścieżki
         model.addAttribute("order", orderService.getById(orderId));

        return "orderDetails";
    }

    @GetMapping("/delete/{orderId}")
    public String orderDelete(@PathVariable Integer orderId, Model model){
        System.out.println("Order " + orderService.getById(orderId) + " has been deleted");
        orderService.delete(orderId);

        return "redirect:/order/list";
    }



}
