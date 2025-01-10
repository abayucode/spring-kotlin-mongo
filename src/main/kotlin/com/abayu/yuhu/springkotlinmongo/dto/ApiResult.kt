package com.abayu.yuhu.springkotlinmongo.dto


class ApiResult<T>(
    var message: String? = null,
    var data: T? = null,
    var success: Boolean? = null,
    var status: Int? = null,
) {
    fun success(data: T): ApiResult<T> {
        return ApiResult(
            data = data,
            success = true,
            status = 200,
            message = "Successfully"
        );
    }

    fun failure(message: String?): ApiResult<T> {
        val apiResult: ApiResult<T> = ApiResult(
            data = null,
            success = false,
            message = "$message",
        )
        return apiResult
    }
}
