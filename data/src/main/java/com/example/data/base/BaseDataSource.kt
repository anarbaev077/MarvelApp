package com.example.data.base

import com.example.data.base.models.AnotherError
import com.example.data.base.models.ResultStatus
import retrofit2.HttpException
import retrofit2.Response

abstract class BaseDataSource {

    suspend fun <T> invokeResponseRequest(request: suspend () -> Response<T>): ResultStatus<T> {
        return try {
            val response = request()
            if (response.isSuccessful) {
                ResultStatus.success(
                    data = response.body()!!
                )
            } else {
                ResultStatus.error(
                    errorThrowable = AnotherError(
                        errorMassage = response.message(),
                        code = response.code()
                    ),
                    data = null,
                )
            }
        } catch (httpException: HttpException) {
            ResultStatus.error(errorThrowable = httpException, data = null)
        } catch (e: Throwable) {
            ResultStatus.error(errorThrowable = e, data = null)
        }
    }
}