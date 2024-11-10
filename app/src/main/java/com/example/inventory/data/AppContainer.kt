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

import android.content.Context

/**
 * Interface AppContainer
 * merupakan struktur untuk Dependency Injection, (DI teknik untuk memberkan ketergantungan sebuah objek dari luar)
 * interface ini akan mendefinisikan bagaimana mendapatkan instance dari ItemsRepository
 *
 * Properti itemsRepository adalah abstraksi dari ItemsRepository. Properti ini
 * menyediakan instance ItemsRepository agar daapat digunakan diseluruh aplikasi
 */
interface AppContainer {
    val itemsRepository: ItemsRepository
}

/**
 * AppData Container
 * implementasi dari AppContainer, mengambil context sebagai parameter dan menggunakan context
 * untuk mendapatkan instance InventoryDatabase
 *
 * context merupakan parameter untuk inisialisasi databse aplikasi agar bisa diakses oleh AppDataContainer
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementasi ItemsRepository
     */
    override val itemsRepository: ItemsRepository by lazy {
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
    }
}
/**
 * InventoryDatabase.getDatabase(context).itemDao():
 * Memanggil getDatabase dari InventoryDatabase untuk mendapatkan instance database.
 * Kemudian, menggunakan itemDao() untuk mendapatkan akses ke DAO (ItemDao),
 * yang menyediakan fungsi-fungsi untuk mengakses tabel items di database.
 */