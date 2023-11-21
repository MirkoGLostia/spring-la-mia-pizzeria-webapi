package org.exercise.java.springlamiapizzeriacrud.api;

import org.exercise.java.springlamiapizzeriacrud.model.Pizza;
import org.exercise.java.springlamiapizzeriacrud.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pizza")
@CrossOrigin
public class BookRestController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public List<Pizza> index(@RequestParam Optional<String> search) {
        return pizzaService.getPizzaList(search);
    }
}
