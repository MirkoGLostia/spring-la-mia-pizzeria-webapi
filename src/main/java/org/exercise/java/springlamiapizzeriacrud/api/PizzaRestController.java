package org.exercise.java.springlamiapizzeriacrud.api;

import jakarta.validation.Valid;
import org.exercise.java.springlamiapizzeriacrud.exceptions.PizzaNotFoundException;
import org.exercise.java.springlamiapizzeriacrud.model.Pizza;
import org.exercise.java.springlamiapizzeriacrud.repository.PizzaRepository;
import org.exercise.java.springlamiapizzeriacrud.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pizza")
@CrossOrigin
public class PizzaRestController {

    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private PizzaRepository pizzaRepository;


    @GetMapping
    public List<Pizza> pizzaList(@RequestParam Optional<String> search) {
        return pizzaService.getPizzaList(search);
    }

    @GetMapping("/{id}")
    public Pizza pizzaDetail(@PathVariable Integer id) {
        try {
            return pizzaService.getPizzaById(id);
        } catch (PizzaNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Pizza pizzaCreate(@Valid @RequestBody Pizza pizza) {
        try {
            return pizzaRepository.save(pizza);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public Pizza pizzaUpdate(@PathVariable Integer id, @Valid @RequestBody Pizza pizza) {
        pizza.setId(id);
        try {
            return pizzaService.editPizza(pizza);
        } catch (PizzaNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        try {
            Pizza pizzaToDelete = pizzaService.getPizzaById(id);
            pizzaService.deletePizza(id);
        } catch (PizzaNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



}
