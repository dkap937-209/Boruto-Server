package com.dk.repository

import com.dk.models.ApiResponse
import com.dk.models.Hero

class HeroRepositoryImpl: HeroRepository {
    override val heroes: Map<Int, List<Hero>>
        get() = TODO("Not yet implemented")
    override val page1: List<Hero>
        get() = TODO("Not yet implemented")
    override val page2: List<Hero>
        get() = TODO("Not yet implemented")
    override val page3: List<Hero>
        get() = TODO("Not yet implemented")
    override val page4: List<Hero>
        get() = TODO("Not yet implemented")
    override val page5: List<Hero>
        get() = TODO("Not yet implemented")

    override suspend fun getAllHero(page: Int): ApiResponse {
        TODO("Not yet implemented")
    }

    override suspend fun searchHeroes(name: String): ApiResponse {
        TODO("Not yet implemented")
    }
}