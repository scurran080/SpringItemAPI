package com.inventorysystem.inventorysystem.Item;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,String>{
    
    //Other way using SQL Like statement LIKE %:upc%
    @Query(value= "SELECT item FROM Item item WHERE item.upc = :#{#upc}")
    Optional<Item> findItemByUPC(@Param("upc") String upc);

    @Query(value="SELECT item FROM Item item WHERE item.id = :#{#id}")
    Optional<Item> findItemByID(@Param("id") long id);
}
