package com.devtvas.tarefas.service;

import com.devtvas.tarefas.entity.Task;
import com.devtvas.tarefas.repository.TaskRepository;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@Service
public class TaskService {

    private TaskRepository todoRepository;

    public Mono<Task> create(Task todo) {
        return todoRepository.save(todo);
    }

    public Flux<Task> list() {
        return todoRepository.findAll()
                .sort(Comparator.comparing(Task::getFavoritos).reversed()
                        .thenComparing(Task::getTitulo));
    }
    public Mono<Task> update(Task todo) {
        return todoRepository.save(todo);
    }

    public Mono<Void> delete(Long id) {
        return todoRepository.deleteById(id);
    }
}
