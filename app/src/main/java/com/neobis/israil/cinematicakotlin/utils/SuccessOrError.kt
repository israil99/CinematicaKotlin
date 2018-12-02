package com.neobis.israil.cinematicakotlin.utils


interface SuccessOrError<T> {
    fun onSuccess(result: T)
    fun onError(message: String?)
}