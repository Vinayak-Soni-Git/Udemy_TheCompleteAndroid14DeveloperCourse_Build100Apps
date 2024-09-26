package com.example.udemy_thecompleteandroid14developercourse_build100apps.TopCompaniesApp

import retrofit2.Response
import retrofit2.http.GET

interface CompaniesService {
    @GET("/companies")
    suspend fun getAllCompanies():Response<CompaniesList>
}