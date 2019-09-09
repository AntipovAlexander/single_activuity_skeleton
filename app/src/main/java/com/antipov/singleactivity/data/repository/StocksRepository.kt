package com.antipov.singleactivity.data.repository

import com.antipov.singleactivity.data.model.StockPrice
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel

interface StocksRepository {
    suspend fun saveStockToDb(stockPrice: StockPrice)
    suspend fun getAllStocksInDb(): MutableList<StockPrice>
    suspend fun getFirstStock(): StockPrice

    fun getStocksAsync(day: String): Deferred<StockPrice>
    fun dropAllStocksInDb()
    fun getStockChannel(): Channel<StockPrice>
    fun getTickerChannel(): ReceiveChannel<Unit>
}