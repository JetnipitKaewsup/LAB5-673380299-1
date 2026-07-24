package com.example.demo.repository;

import com.example.demo.model.Coffee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CoffeeRepository {

    private List<Coffee> coffeeList = new ArrayList<>();

    public CoffeeRepository() {

        coffeeList.add(new Coffee(1, "Espresso", 55));
        coffeeList.add(new Coffee(2, "Latte", 70));
        coffeeList.add(new Coffee(3, "Mocha", 80));

    }

    public List<Coffee> findAll() {
        return coffeeList;
    }

    public Coffee findById(int id) {

        for (Coffee coffee : coffeeList) {

            if (coffee.getId() == id) {
                return coffee;
            }

        }

        return null;
    }

    public void save(Coffee coffee) {
        coffeeList.add(coffee);
    }

    public void delete(int id) {

        coffeeList.removeIf(c -> c.getId() == id);

    }

}