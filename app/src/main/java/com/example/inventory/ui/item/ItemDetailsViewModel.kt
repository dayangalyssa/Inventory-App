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

package com.example.inventory.ui.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.inventory.data.ItemsRepository

/**
 * ItemDetailsViewModel
 *  ViewModel yang bertanggung jawab untuk mengelola data
 *  terkait detail suatu item yang dipilih dalam aplikasi.
 *
 *  itemId, menyimpan id fdari item yang sedaang ditampilkan
 *  diperoleh dari savedStateHandle
 *
 *
 */
class ItemDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val itemId: Int = checkNotNull(savedStateHandle[ItemDetailsDestination.itemIdArg])

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * ItemDetailsUiState
 * sebagai data class yang digunakan untuk merepresentasikan
 * status ui dari layar detail item
 */
data class ItemDetailsUiState(
    val outOfStock: Boolean = true, // stock item habis atau tidak
    val itemDetails: ItemDetails = ItemDetails() // data dari tiem
)
