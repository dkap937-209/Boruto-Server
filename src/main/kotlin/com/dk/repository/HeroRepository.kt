package com.dk.repository

import com.dk.models.ApiResponse
import com.dk.models.Hero

interface HeroRepository {

    val heroes: Map<Int, List<Hero>>

    val page1: List<Hero>
    val page2: List<Hero>
    val page3: List<Hero>
    val page4: List<Hero>
    val page5: List<Hero>

    suspend fun getAllHero(page: Int = 1): ApiResponse
    suspend fun searchHeroes(name: String?): ApiResponse
}