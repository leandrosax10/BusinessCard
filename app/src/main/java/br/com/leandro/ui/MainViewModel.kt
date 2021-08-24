package br.com.leandro.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.leandro.data.BusinessCardRepository
import br.com.leandro.data.Businesscard
import java.lang.IllegalArgumentException

class MainViewModel(private val businessCardRepository: BusinessCardRepository) : ViewModel() {

    fun insert(businesscard: Businesscard){
        businessCardRepository.insert(businesscard)

    }

    fun gelAll() : LiveData<List<Businesscard>>{
        return businessCardRepository.getAll()
    }

}

class MainsViewModelFactory(private val repository : BusinessCardRepository) :
    ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}