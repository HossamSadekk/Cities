package com.example.cities.domain.searchAlgorithm

import com.example.cities.data.model.City

class CityTrie {
    private val root = TrieNode()

    fun insert(city: City) {
        var node = root
        for (char in city.name.lowercase()) {
            /** checks if the corresponding child node exists. If not, creates a new child node **/
            node.children[char] = node.children.getOrDefault(char, TrieNode())
            node = node.children[char]!!
        }
        node.city = city
    }

    fun search(prefix: String): List<City> {
        var node = root
        for (char in prefix.lowercase()) {
            node.children[char] ?: return emptyList()
            node = node.children[char]!!
        }
        return node.getAllCities()
    }

    private class TrieNode {
        val children = mutableMapOf<Char, TrieNode>()
        var city: City? = null

        fun getAllCities(): List<City> {
            val cities = mutableListOf<City>()
            getAllCitiesRecursive(cities)
            return cities
        }

        private fun getAllCitiesRecursive(cities: MutableList<City>) {
            city?.let { cities.add(it) }
            for (child in children.values) {
                child.getAllCitiesRecursive(cities)
            }
        }
    }
}

