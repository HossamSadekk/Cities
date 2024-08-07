package com.example.cities.domain.usecase

import com.example.cities.data.model.City
import com.example.cities.domain.repository.CityRepository
import com.example.cities.domain.searchAlgorithm.CityTrie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchCitiesUseCase(private val cityRepo: CityRepository) {
    private val trie = CityTrie()

    suspend fun initialize() {
        withContext(Dispatchers.IO) {
            cityRepo.getCities().forEach { trie.insert(it) }
        }
    }

    fun search(query: String): List<City> {
        val filteredCities = trie.search(query)
        return filteredCities.sortedWith(
            compareBy<City> { it.name }.thenBy { it.country }
        )
    }

}