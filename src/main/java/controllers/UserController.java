package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "prueba")
    public List<String> prueba () {
        return List.of("manzana", "kiwi", "pera");
    }
}
