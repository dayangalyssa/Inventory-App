package com.example.inventory.data

import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room

/**
 * InventoryDatabse Abstrak Class
 * sebagai database utama aplikasi yang diatur dengan room, titik akses utama ke data lokal
 *
 * method itemDao() akan memberikan akses ke ItemDao. Befungsi fungsi2 untuk akses dan modifkasi data pada tabel Item
 *
 */
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instance: InventoryDatabase? = null

        fun getDatabase(context: Context): InventoryDatabase {
            // satu instance database yang aktif dalam aplikasi
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}

/**
 * 1. Database Setup: InventoryDatabase adalah database utama yang membuat tabel items.
 * 2. Entity Declaration: Item adalah kelas yang mendefinisikan struktur tabel items.
 * 3. Data Access: ItemDao menyediakan fungsi untuk akses langsung ke database.
 * 4. Repository Interface: ItemsRepository mendefinisikan fungsi CRUD standar untuk aplikasi.
 * 5. Concrete Repository: OfflineItemsRepository menerapkan ItemsRepository, menggunakan ItemDao untuk akses data dari database.
 * 6. Alur ini memastikan bahwa data dari InventoryDatabase bisa diakses dengan aman dan konsisten melalui ItemDao dan OfflineItemsRepository.
 */