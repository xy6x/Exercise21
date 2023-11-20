package com.example.ex21.Test;

import com.example.ex21.ProjectSystem.Project;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/project")
public class Test {
    ArrayList<Project> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Project> getTasks() {

        return tasks;
    }
    @PostMapping("/add")
    public ResponseEntity addTask(@Valid @RequestBody Project task ,Errors errors) {
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);

        }
        tasks.add(task);
        return ResponseEntity.status(HttpStatus.OK).body("user Added");
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateTask(@PathVariable int index, @Valid @RequestBody Project task , Errors errors) {
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);

        }
        tasks.set(index,task);
        return ResponseEntity.status(HttpStatus.OK).body("update user");
    }
    @DeleteMapping("/delete/{index}")
    public ArrayList<Project> deleteTask(@PathVariable int index){
        tasks.remove(index);
        return tasks;
    }
    @PutMapping("change/{index}")
    public ResponseEntity Change(@PathVariable int index) {
        Project task = tasks.get(index);
        if (task.getStatus().equalsIgnoreCase("Not Started")) {
            task.setStatus("Progress");
            tasks.set(index, task);
        } else if(task.getStatus().equalsIgnoreCase("Progress")) {
            task.setStatus("Completed");
            tasks.set(index, task);
        } else if(task.getStatus().equalsIgnoreCase("Completed")) {
            task.setStatus("Not Started");
            tasks.set(index, task);
        }

        return ResponseEntity.status(HttpStatus.OK).body("is good ");
    }
        @GetMapping("/search/{title}")
        public ResponseEntity search(@PathVariable String title ) {
            for (Project t : tasks
            ) {
                if (t.getTitle().equals(title)) {
                    return ResponseEntity.status(HttpStatus.OK).body("hi");
                }
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("try again");
        }

    }



