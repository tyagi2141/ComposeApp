package com.example.myapplication.model

import androidx.compose.runtime.Immutable

@Immutable
data class SnackCollection(
    val id: Long,
    val name: String,
    val snacks: List<Snack>,
    val type: CollectionType = CollectionType.Normal
)

enum class CollectionType { Normal, Highlight }

/**
 * A fake repo
 */
object SnackRepo {
    fun getSnacks(): List<SnackCollection> = snackCollections
    fun getSnack(snackId: Long) = snacks.find { it.id == snackId }!!
    fun getRelated(@Suppress("UNUSED_PARAMETER") snackId: Long) = related
    fun getFilters() = filters
}

/**
 * Static data
 */

val tastyTreats = SnackCollection(
    id = 1L,
    name = "Android's picks",
    type = CollectionType.Highlight,
    snacks = snacks.subList(0, 13)
)

val popular = SnackCollection(
    id = 2L,
    name = "Popular on Jetsnack",
    snacks = snacks.subList(14, 19)
)

val wfhFavs = tastyTreats.copy(
    id = 3L,
    name = "WFH favourites"
)

val newlyAdded = popular.copy(
    id = 4L,
    name = "Newly Added"
)

val exclusive = tastyTreats.copy(
    id = 5L,
    name = "Only on Jetsnack"
)

val also = tastyTreats.copy(
    id = 6L,
    name = "Customers also bought"
)

val snackCollections = listOf(
    tastyTreats,
    popular,
    wfhFavs,
    newlyAdded,
    exclusive
)

val related = listOf(
    also,
    popular
)