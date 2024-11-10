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

package com.example.inventory.ui.home

import androidx.lifecycle.ViewModel
import com.example.inventory.data.Item

/**
 * ViewModel untuk layar HomeScreen.
 * Bertujuan untuk menagmbil dan mengelola daftar semua item di Room Database
 *
 * TIMEOUT: sebagai batas waktu maksimal untuk proses tertentu,
 * seperti memuat data dari database agar aplikasi tetap responsif.
 */
class HomeViewModel : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * HomeUiState
 * kelas data yang menyimpan daftar item (itemList),
 * yang nantinya akan digunakan oleh layar beranda untuk menampilkan semua item di dalam aplikasi
 */
data class HomeUiState(val itemList: List<Item> = listOf())
