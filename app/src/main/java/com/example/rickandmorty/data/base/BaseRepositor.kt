package com.example.rickandmorty.data.base

import com.example.rickandmorty.domain.utils.Resourse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

abstract class BaseRepositor {

    protected  fun <T>  doReguest(reguest:suspend () -> T) = flow{
        emit(Resourse.Loading())
            try {
                val data =  reguest()
                emit(Resourse.Success(data))
            }catch (ioExaption:IOException){
                emit(Resourse.Error(ioExaption.localizedMessage ?: "hj"))
            }

        }.flowOn(Dispatchers.IO)
}