package com.ensa.gestion.des.taches.controller;

import com.ensa.gestion.des.taches.model.Task;
import com.ensa.gestion.des.taches.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskservice ;
    @PostMapping("/create")
    public Task create(@RequestBody Task task){
        return taskservice.create(task) ;
    }
    @PutMapping("/update/{id}")
    public Task update(@PathVariable Long id , @RequestBody Task task ){
        return taskservice.modifier(id,task) ;
    }
    @DeleteMapping("/delete/{id}")
    public String delete(Long id ){
        return taskservice.delete(id) ;
    }
    @PutMapping("/update/{id}/status")
    public Task changerstatus(@PathVariable Long id , @RequestParam String nvstatus){
        return taskservice.changerStatut(id,nvstatus) ;
    }
    @GetMapping()
    public List<Task> lire(){
        return taskservice.lire() ;
    }
}
