package com.antipov.singleactivity.data.repository.impl

import com.antipov.singleactivity.data.db.dao.StockPriceDao
import com.antipov.singleactivity.data.model.StockPrice
import com.antipov.singleactivity.data.repository.StocksRepository
import com.antipov.singleactivity.data.retrofit.ApiHelper
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.ticker

class StocksRepositoryImpl(
    private val apiHelper: ApiHelper,
    private val stockPriceDao: StockPriceDao
) : StocksRepository {

    override suspend fun getFirstStock(): StockPrice = stockPriceDao.getFirstItem()

    override suspend fun getAllStocksInDb(): MutableList<StockPrice> = stockPriceDao.getAll()

    override suspend fun saveStockToDb(stockPrice: StockPrice) = stockPriceDao.create(stockPrice)

    @ObsoleteCoroutinesApi
    override fun getTickerChannel(): ReceiveChannel<Unit> = ticker(delayMillis = 500, initialDelayMillis = 0)

    override fun getStocksAsync(day: String) = apiHelper.getStocksAsync(day)

    override fun dropAllStocksInDb() = stockPriceDao.dropAll()

    override fun getStockChannel() = stockPriceDao.getUpdatesChannel()


}