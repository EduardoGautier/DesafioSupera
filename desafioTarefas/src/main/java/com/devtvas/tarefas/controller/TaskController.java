package com.devtvas.tarefas.controller;

import com.devtvas.tarefas.entity.Task;
import com.devtvas.tarefas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/todos")
public class TaskController {

    @Autowired
    private TaskService todoService;

    @PostMapping
    Mono<Task> create(@RequestBody Task todo) {
        return todoService.create(todo);
    }

    @GetMapping
    Flux<Task> list() {
        return todoService.list();
    }

    @PutMapping
    Mono<Task> update(@RequestBody Task todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    Mono<Void> delete(@PathVariable("id") Long id) {
        return todoService.delete(id);
    }
}
