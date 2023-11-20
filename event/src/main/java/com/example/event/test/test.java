package com.example.event.test;


import com.example.event.Event.Event;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class test {
    ArrayList<Event> ev = new ArrayList<>();

    @GetMapping("/get")

    public ArrayList<Event> get() {
        return ev;
    }

    @PostMapping("/add")
    public ResponseEntity addEvent(@Valid  @RequestBody Event evn, Errors errors) {
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        ev.add(evn);
        return ResponseEntity.status(HttpStatus.OK).body("user Added") ;
    }

    @PutMapping("/pus/{index}")

    public ResponseEntity pusUpdate(@Valid @RequestBody Event evn, @PathVariable int index ,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        ev.set(index, evn);
        return ResponseEntity.status(HttpStatus.OK).body("user Added") ;
    }

    @DeleteMapping("/delete/{index}")
    public ArrayList<Event> deleteEvent(@PathVariable int index) {
        ev.remove(index);
        return ev;
    }
    @GetMapping("/change/{index}")
    public Event Change(@PathVariable int index) {
   ev.get(index).setCapacity(ev.get(index).getCapacity()-1);

return null;
}

    @GetMapping("/search/{evn}")
    public ResponseEntity search(@PathVariable String evn) {

        for (Event e : ev) {
            if (e.getId().equalsIgnoreCase(evn)) {
                return ResponseEntity.status(HttpStatus.OK).body(e);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(ev);
    }



}
