package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * DAO adalah pola untuk memisahkan lapisan perseistensi dari bagian aplikasi lainnya
 * dengan menyediakan interface abstrak
 *
 * DAO komponen utama dari room yang menetukan antarmuka yang mengakses database
 *
 */
@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)//Argumen onConflict akan memberi tahu room apa yg harus dilakukan,
    // strategy jika terjadi konflik adlaah dengan mengabaikan item baru
    suspend fun insert(item: Item) // agar dapat berjalan di thread terpisah

    @Update
    suspend fun update(item: Item) // Fungsi suspensi untuk memperbarui data.

    @Delete
    suspend fun delete(item: Item) // Fungsi suspensi untuk menghapus item berdasarkan primary key-nya (id).

    /**
     * Mengembalikan item yang sesuai dengan id dalam bentuk Flow.
     * Aliran ini memungkinkan UI untuk mendapatkan pembaruan otomatis
     * saat data berubah.
     */
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    // mengambil data secara ascending
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}