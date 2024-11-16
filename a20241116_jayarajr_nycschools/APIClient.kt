package com.example.a20241116_jayarajr_nycschools

import retrofit2.http.GET

interface APIClient {
    @GET("resource/s3k6-pzi2.json")
     suspend fun getSchoolList():List<SchoolListResponseItem>
}