package pl.sda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller //  bedzie zarejestrowany jako bean oraz obsługuje żądania HTTP
public class HelloController {

//    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    @GetMapping("/hello")  //zapis równoważny z powyższym
    public String helloWorld(){


        // Redirect :
        // czyszczenie cache np. zakończyć sesje http

        // przywrócenie ustawienia wartości domyślnych


        return "welcome"; // nazwa widoku o rozszerzeniu .html
    }

    @GetMapping("/hello-msg")
    public String helloWorldWithMsg(Model model){ // wstrzyknięcie pustego obiektu ModelMap - jak Mapa(klucz, wartość)

        model.addAttribute("helloMsg", "Wiadomość przekazana z kontrolera!");

        model.addAttribute("elements", Arrays.asList("one","two","three"));

        return "welcome-msg";
    }


}
