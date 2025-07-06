package ru.easycode.zerotoheroandroidtdd

import java.net.NoRouteToHostException
import java.net.UnknownHostException

interface Repository {
    suspend fun load(): LoadResult

    class Base(private val service: SimpleService, private val url: String) : Repository {

        override suspend fun load(): LoadResult =
            try {
                val data = service.fetch(url)
                LoadResult.Success(data)
            } catch (e: Exception) {
                LoadResult.Error(e is NoRouteToHostException)
            }
    }
}