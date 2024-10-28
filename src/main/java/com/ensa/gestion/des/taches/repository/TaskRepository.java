package com.ensa.gestion.des.taches.repository;

import com.ensa.gestion.des.taches.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
