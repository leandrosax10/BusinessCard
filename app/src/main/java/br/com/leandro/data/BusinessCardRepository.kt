package br.com.leandro.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository (private val dao: BusinessCardDao){

    fun insert(businesscard: Businesscard) = runBlocking{
    launch(Dispatchers.IO){
        dao.insert(businesscard)
        }

    }

    fun getAll() = dao.getAll()
}