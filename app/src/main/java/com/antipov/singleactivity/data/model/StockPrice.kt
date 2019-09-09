package com.antipov.singleactivity.data.model

data class StockPrice(val stockDate: String, val data: Data) {
    data class Data(val open: Float, val high: Float, val low: Float, val close: Float)
}