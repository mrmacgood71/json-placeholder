package it.macgood.jsonplaceholder.data.remote.dto

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geolocation
)
