package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.service.ActorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
@Slf4j
public class ActorController {
    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping
    public Actor save(@RequestBody Actor actor) {
        return actorService.save(actor);
    }

    @GetMapping("/{id}")
    public Actor findById(@PathVariable Long id) {
        Actor actor = actorService.findById(id);
        if (actor == null) {
            throw new ApiException("Actor not found", HttpStatus.NOT_FOUND);
        }
        return actor;
    }

    @GetMapping
    public List<Actor> findAll() {
        return actorService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Actor> delete(@PathVariable Long id) {
        Actor actor = actorService.findById(id);
        if (actor != null) {
            actorService.delete(actor);
            return ResponseEntity.ok(actor);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public Actor update(@PathVariable Long id, @RequestBody Actor actor) {
        Actor existingActor = actorService.findById(id);
        if (existingActor == null) {
            throw new ApiException("Actor not found", HttpStatus.NOT_FOUND);
        }

        existingActor.setFirstName(actor.getFirstName());
        existingActor.setLastName(actor.getLastName());
        existingActor.setBirthDate(actor.getBirthDate());
        existingActor.setGender(actor.getGender());

        return actorService.save(existingActor);
    }

}
