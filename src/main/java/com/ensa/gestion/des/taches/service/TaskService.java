package com.ensa.gestion.des.taches.service;

import com.ensa.gestion.des.taches.model.Task;
import com.ensa.gestion.des.taches.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskrepository ;
    public Task create(Task task){
        return taskrepository.save(task) ;
    }
    public Task modifier(Long id , Task task ){
        return taskrepository.findById(id)
                .map(tache -> {
                    tache.setId(task.getId()) ;
                    tache.setDescription(task.getDescription());
                    tache.setStatus(task.getStatus());
                    tache.setTitre(task.getTitre());
                    tache.setDateCreation(task.getDateCreation());
                    return taskrepository.save(tache);
                } )
                .orElseThrow(() ->new RuntimeException("task non trouvé"));
    }
    public String delete(Long id ){
        taskrepository.deleteById(id);
        return"supprimé" ;

    }
    public Task changerStatut(Long id, String nouveauStatut) {
        return taskrepository.findById(id)
                .map(tache -> {
                    tache.setStatus(nouveauStatut);
                    return taskrepository.save(tache);
                })
                .orElseThrow(() -> new RuntimeException("Tâche non trouvée avec l'ID : " + id));
    }
    public List<Task> lire(){
        return taskrepository.findAll() ;
}
}
