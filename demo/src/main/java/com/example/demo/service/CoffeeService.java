package com.example.demo.service;

import com.example.demo.model.Coffee;
import com.example.demo.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    private final CoffeeRepository repository;

    public CoffeeService(CoffeeRepository repository) {
        this.repository = repository;
    }

    public List<Coffee> getAllCoffee() {
        return repository.findAll();
    }

    public Coffee getCoffee(int id) {
        return repository.findById(id);
    }

    public void addCoffee(Coffee coffee) {
        repository.save(coffee);
    }

    public boolean updateCoffee(int id, Coffee coffee) {

        Coffee oldCoffee = repository.findById(id);

        if (oldCoffee == null)
            return false;

        oldCoffee.setName(coffee.getName());
        oldCoffee.setPrice(coffee.getPrice());

        return true;

    }

    public boolean deleteCoffee(int id) {

        Coffee coffee = repository.findById(id);

        if (coffee == null)
            return false;

        repository.delete(id);

        return true;

    }

}