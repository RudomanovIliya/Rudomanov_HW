package com.example.hw5.di

import com.example.hw5.presentation.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainActivityViewModel> {
        MainActivityViewModel(repository = get())
    }
}