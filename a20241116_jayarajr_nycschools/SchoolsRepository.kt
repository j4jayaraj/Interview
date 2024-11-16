package com.example.a20241116_jayarajr_nycschools

import kotlinx.coroutines.flow.flow

class SchoolsRepository() {
    private val apiService= RetrofitBuilder().retrofitInstance()
    suspend fun getSchoolDetails()= flow {
       emit( apiService.getSchoolList())
    }
}