package com.cherish.apimodule.data

import com.cherish.apimodule.data.model.response.MilkyWayResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MilkyWayService {
    @GET("search")
    suspend fun getMilkyWayImages(
        @Query("q",encoded = true) q: String,
        @Query("media_type") mediaType: String,
        @Query("year_start") yearStart: String,
        @Query("year_end") yearEnd: String,
    ): MilkyWayResponse?
}