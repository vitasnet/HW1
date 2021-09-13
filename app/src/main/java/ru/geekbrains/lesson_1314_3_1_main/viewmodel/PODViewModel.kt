package ru.geekbrains.lesson_1314_3_1_main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.geekbrains.lesson_1314_3_1_main.BuildConfig
import ru.geekbrains.lesson_1314_3_1_main.repository.PODRetrofitImpl
import ru.geekbrains.lesson_1314_3_1_main.repository.PODServerResponseData

class PODViewModel(private val liveDataToObserve: MutableLiveData<PODData> = MutableLiveData(),
private val retrofitImpl: PODRetrofitImpl = PODRetrofitImpl()):ViewModel() {
    fun getLiveData():LiveData<PODData>{
        return liveDataToObserve
    }

    fun sendServerRequest(){
        liveDataToObserve.postValue(PODData.Loading)
        val apiKey = BuildConfig.NASA_API_KEY
        if(apiKey.isBlank()){
            //
        }else{
            retrofitImpl.getRetrofitImpl().getPictureOfTheDay(apiKey).enqueue(
                object : Callback<PODServerResponseData>{
                    override fun onResponse(
                        call: Call<PODServerResponseData>,
                        response: Response<PODServerResponseData>
                    ) {
                        if(response.isSuccessful && response.body()!=null){
                            liveDataToObserve.postValue(PODData.Success(response.body() as PODServerResponseData)) // FIXME костыль
                        }else{
                            // TODO HW
                        }
                    }

                    override fun onFailure(call: Call<PODServerResponseData>, t: Throwable) {
                        // TODO HW
                    }

                }
            )
        }
    }
}