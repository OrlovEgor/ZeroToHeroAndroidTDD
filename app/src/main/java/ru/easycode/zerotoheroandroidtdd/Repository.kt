package ru.easycode.zerotoheroandroidtdd

import java.net.UnknownHostException

interface Repository {
    suspend fun load(): LoadResult

    class Base(private val service: SimpleService, private val url: String) : Repository {

        override suspend fun load(): LoadResult {
            return try {
                val data = service.fetch(url)
                LoadResult.Success(data)
            } catch (e: UnknownHostException) {
                LoadResult.Error(noConnection = true)
            } catch (e: IllegalStateException) {
                LoadResult.Error(noConnection = false)
            }
        }

    }
}