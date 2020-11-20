package com.example.aula35restapi.services

import com.example.aula35restapi.models.Aluno
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Service{

    @GET("sort/aluno")
    suspend fun getAlunoSortRepo(): Aluno

    @GET("alunos")
    suspend fun getAllAlunosRepo(): List<Aluno>
}

val retrofit = Retrofit.Builder()
.baseUrl("https://promoios.com.br/api/")
.addConverterFactory(GsonConverterFactory.create())
.build()

val service:Service = retrofit.create(Service::class.java)