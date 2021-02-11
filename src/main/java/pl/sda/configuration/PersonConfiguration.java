package pl.sda.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sda.dao.PersonDao;
import pl.sda.dao.impl.MockPersonDao;
import pl.sda.service.PersonService;
import pl.sda.service.impl.PersonServiceImpl;
import pl.sda.util.PersonUtil;
import pl.sda.util.PersonValidator;

@Configuration
public class PersonConfiguration {
    // konfiguracja obiektow, z adnotacja @Configuration - tutaj ma szukac konfiguracji bean'ow -
    // 3 zajeznosci do Person Service Impl

    // 1 zależość adnotacja @Bean - zawsze metoda publiczna
    // typ zwracany taki samy jak typ zależności

    @Bean
    public PersonDao mockPersonDao(){
        return new MockPersonDao();
    }
    @Bean
    public PersonUtil personUtil(){
        return new PersonUtil();
    }
    @Bean
    public PersonValidator personValidator(){
        return new PersonValidator();
    }
    @Bean
    public PersonService personServiceImpl(){
        return new PersonServiceImpl(
                mockPersonDao(),
                personUtil(),
                personValidator());
        }
}

