/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data


/**
 * Entity data class represents a single row in the database.
 */
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Anotasi Entiti yang menandakan class Item sebagai entital tabel di databse room
 * nama tabel di databse ini adalah "Items"
 * data class item, mendefinisikan kelad data item yang mewakili satu baris data
 * dalam tabel item
 */
@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true) // id sebagai primary key
    val id: Int = 0, // id unik setiap item
    val name: String, //nama item
    val price: Double, //harga
    val quantity: Int // stok

){
    // fungsi formatted
    fun formatedPrice(): String {
        return "$${"%.2f".format(price)}"
    }
}
