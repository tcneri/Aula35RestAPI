package com.example.aula35restapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aula35restapi.R
import com.example.aula35restapi.services.service

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(service) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getAlunoSort()
        viewModel.getAllAlunos()

        viewModel.aluno.observe(this,{
//            Log.i("MainActivity", it.toString())
        })

        viewModel.listAlunos.observe(this,{
            it.forEach(){
                Log.i("MainActivity", it.toString())
            } })

    }
}