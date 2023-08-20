package com.dk.di

import com.dk.repository.HeroRepository
import com.dk.repository.HeroRepositoryImpl
import org.koin.dsl.module

val koinModule = module{
    single <HeroRepository> {
        HeroRepositoryImpl()
    }
}