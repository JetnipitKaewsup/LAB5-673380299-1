package com.example.demo.service;

import com.example.demo.model.Coffee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeService {

    private List<Coffee> coffeeList = new ArrayList<>();

    // Constructor
    public CoffeeService() {
        coffeeList.add(new Coffee(1, "Espresso", 55));
        coffeeList.add(new Coffee(2, "Latte", 70));
        coffeeList.add(new Coffee(3, "Mocha", 80));
    }

    // GET
    public List<Coffee> getAllCoffee() {
        return coffeeList;
    }

    // GET by id
    public Coffee getCoffee(int id) {
        for (Coffee coffee : coffeeList) {
            if (coffee.getId() == id) {
                return coffee;
            }
        }
        return null;
    }

    // POST
    public void addCoffee(Coffee coffee) {
        coffeeList.add(coffee);
    }

    // PUT
    public boolean updateCoffee(int id, Coffee newCoffee) {

        Coffee oldCoffee = getCoffee(id);

        if (oldCoffee == null) {
            return false;
        }

        oldCoffee.setName(newCoffee.getName());
        oldCoffee.setPrice(newCoffee.getPrice());

        return true;
    }

    // DELETE
    public boolean deleteCoffee(int id) {

        Coffee coffee = getCoffee(id);

        if (coffee == null) {
            return false;
        }

        coffeeList.remove(coffee);

        return true;
    }
}