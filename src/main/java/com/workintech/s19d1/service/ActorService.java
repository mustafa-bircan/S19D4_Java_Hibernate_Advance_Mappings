package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;

import java.util.List;

public interface ActorService {
    Actor save(Actor actor);
    Actor findById(Long id);
    List<Actor> findAll();
    void delete(Actor actor);
}
