package com.hc.common.network.model

import retrofit2.Response

/**
 * Created by hcw  on 2021/5/15
 * 类描述：
 * all rights reserved
 */

/**
 * 密封类形式的，网络数据返回封装类
 *
 *
 */
sealed class ApiResponse<T> {

    companion object {
        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                if (body == null || response.code() == 204) {
                    ApiEmptyResponse()
                }else {
                    ApiSuccessResponse(body)
                }


            } else {
                ApiErrorResponse(
                    response.code(),
                    response.errorBody()?.string() ?: response.message()
                )

            }
        }

        fun <T> create(errorCode: Int, error: Throwable): ApiErrorResponse<T>{
            return  ApiErrorResponse(
                errorCode,
                error.message?:"Unknown Error!"
            )
        }

    }
}




class ApiEmptyResponse<T> : ApiResponse<T>()

data  class ApiSuccessResponse<T>(val body: T) : ApiResponse<T>()

data class ApiErrorResponse<T>(val errorCode: Int, val errorMessage: String) : ApiResponse<T>()


internal const val UNKNOWN_ERROR_CODE = -1//未知错误码







