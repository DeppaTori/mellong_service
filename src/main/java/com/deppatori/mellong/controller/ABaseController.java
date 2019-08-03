package com.deppatori.mellong.controller;


import com.deppatori.mellong.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

public abstract class ABaseController<T,S extends  BaseService> {

    @Autowired
    private S service;

    @GetMapping
    public Set<T> findAll(){
        return (Set<T>) service.findAll();
    }

    @PostMapping
    public T save(@RequestBody T model){
        return (T) service.save(model);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable Long id, @RequestBody T model){
        return (T) service.update(id,model);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
