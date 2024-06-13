package com.moveseg.app.checklist.Item.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moveseg.app.checklist.Item.domain.Item;
import com.moveseg.app.checklist.Item.domain.ItemId;

public interface ItemRepository extends JpaRepository<Item, ItemId>{
    
}
