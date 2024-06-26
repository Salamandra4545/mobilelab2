package com.example.fesenko1.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val quantity: Int,
    val price: Double,
    val year: Int,
    val manufacturer: String
)
