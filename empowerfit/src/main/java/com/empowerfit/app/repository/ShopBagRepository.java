package com.empowerfit.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.ShopBag;

public interface ShopBagRepository extends CrudRepository<ShopBag, Long> {
    
    /**
     * Query Methods para realizar consultas específicas sobre la entidad ShopBag.
     */

    // SELECT * FROM shop_bag WHERE date = ?
    List<ShopBag> findByDate(Date date);

    // SELECT * FROM shop_bag WHERE quantity = ?
    List<ShopBag> findByQuantity(int quantity);

    // SELECT * FROM shop_bag WHERE amount = ?
    List<ShopBag> findByAmount(double amount);

    // SELECT * FROM shop_bag WHERE date BETWEEN ? AND ?
    List<ShopBag> findByDateBetween(Date startDate, Date endDate);
}
