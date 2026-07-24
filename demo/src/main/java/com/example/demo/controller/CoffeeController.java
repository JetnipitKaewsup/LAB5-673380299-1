package com.example.demo.controller;

import com.example.demo.model.Coffee;
import com.example.demo.service.CoffeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    private final CoffeeService service;

    public CoffeeController(CoffeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Coffee> getAllCoffee() {
        return service.getAllCoffee();
    }

    @GetMapping("/{id}")
    public Coffee getCoffee(@PathVariable int id) {
        return service.getCoffee(id);
    }

    @PostMapping
    public String addCoffee(@RequestBody Coffee coffee) {
        service.addCoffee(coffee);
        return "Coffee Added";
    }

    @PutMapping("/{id}")
    public String updateCoffee(@PathVariable int id,
                               @RequestBody Coffee coffee) {

        if (service.updateCoffee(id, coffee))
            return "Updated";

        return "Coffee Not Found";
    }

    @DeleteMapping("/{id}")
    public String deleteCoffee(@PathVariable int id) {

        if (service.deleteCoffee(id))
            return "Deleted";

        return "Coffee Not Found";

    }

}
