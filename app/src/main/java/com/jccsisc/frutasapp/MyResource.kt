package com.jccsisc.frutasapp

sealed class MyResource<out T> {

    class  Loading<out T> : MyResource<T>()
    data class Succes<out T>(val data: T) : MyResource<T>()
    data class Failure<out T>(val exception: Exception) : MyResource<T>()

}