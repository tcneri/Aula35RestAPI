package com.example.aula35restapi.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aula35restapi.models.Aluno
import com.example.aula35restapi.services.Service
import com.example.aula35restapi.services.service
import kotlinx.coroutines.launch

class MainViewModel(service: Service):ViewModel() {
    val aluno = MutableLiveData<Aluno>()
    val listAlunos = MutableLiveData<List<Aluno>>()


    fun getAlunoSort(){
        viewModelScope.launch {
            aluno.value = service.getAlunoSortRepo()

        }
    }

    fun getAllAlunos(){
        viewModelScope.launch {
            listAlunos.value = service.getAllAlunosRepo()

        }
    }
}