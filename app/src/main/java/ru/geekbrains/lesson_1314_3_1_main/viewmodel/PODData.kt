package ru.geekbrains.lesson_1314_3_1_main.viewmodel

import ru.geekbrains.lesson_1314_3_1_main.repository.PODServerResponseData

sealed class PODData {
    data class Success(val serverResponseData: PODServerResponseData) : PODData()
    data class Error(val error: Throwable) : PODData()

    //data class Loading(val progress: Int?) : PODData()
    object Loading : PODData()
}
