package com.example.fesenko1.Database

import androidx.room.*

@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    fun getAll(): List<Product>

    @Insert
    fun insert(product: Product): Long

    @Update
    fun update(product: Product)

    @Delete
    fun delete(product: Product)

    @Query("SELECT * FROM products ORDER BY price DESC LIMIT 1")
    fun getMostExpensiveProduct(): Product?
}
