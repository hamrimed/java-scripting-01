package com.hamri.java_scripting_01.app.dao;

import com.hamri.java_scripting_01.app.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("itemsReposirory")
public interface ItemsReposirory extends JpaRepository<Item, Integer> {
    @Override
    Optional<Item> findById(Integer integer);

    @Override
    List<Item> findAll();
}
