package com.example.udemy_thecompleteandroid14developercourse_build100apps.TopCompaniesApp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import retrofit2.Response

class MainTopCompaniesActivity : AppCompatActivity() {
    lateinit var resultTextView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_top_companies)
        resultTextView = findViewById(R.id.resultTextViewCountries)
        
        // Retrofit Instance
        var retrofitInstance = RetrofitInstance.getRetrofitInstance()
            .create(CompaniesService::class.java)
        
        val responseLiveData:LiveData<Response<CompaniesList>> = liveData { 
            val companiesResponse = retrofitInstance.getAllCompanies()
            emit(companiesResponse)
        }
        
        responseLiveData.observe(this, Observer { 
            val companiesList = it.body()?.listIterator()
            
            if (companiesList != null){
                while (companiesList.hasNext()){
                    val companyItem = companiesList.next()
                    val companiesResult = "Company Name: ${companyItem.name}"
                    resultTextView.append(companiesResult)
                }
            }
        })
    }
}