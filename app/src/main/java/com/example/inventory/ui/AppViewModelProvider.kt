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

package com.example.inventory.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.inventory.InventoryApplication
import com.example.inventory.ui.home.HomeViewModel
import com.example.inventory.ui.item.ItemDetailsViewModel
import com.example.inventory.ui.item.ItemEditViewModel
import com.example.inventory.ui.item.ItemEntryViewModel

/**
 *AppViewModelProvider
 * objek yang menyediakan ViewModelFactory untuk membuat berbagai ViewModel.
 *
 * Factory adalah instance dari viewModelFactory
 * yang akan digunakan untuk membuat berbagai ViewModel saat dibutuhkan.
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        /**
         * Setiap initializer bertanggungjawab untuk membuat instance ViewModel twertentu
         *
         */
        initializer {
            ItemEditViewModel(
                this.createSavedStateHandle()
            )
        }

        initializer {
            ItemEntryViewModel(inventoryApplication().container.itemsRepository)
        }

        initializer {
            ItemDetailsViewModel(
                this.createSavedStateHandle()
            )
        }

        initializer {
            HomeViewModel()
        }
    }
}
/**
 *inventoryApplication() adalah fungsi ekstensi
 * yang digunakan untuk mendapatkan instance dari InventoryApplication.
 * Fungsi ini mengakses aplikasi global melalui AndroidViewModelFactory.APPLICATION_KEY.
 */
fun CreationExtras.inventoryApplication(): InventoryApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)