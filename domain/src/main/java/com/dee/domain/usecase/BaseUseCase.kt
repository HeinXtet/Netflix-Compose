package com.dee.domain.usecase

interface BaseUseCase<out Result, in Params> {
    fun performResult(params: Params): Result = throw NotImplementedError()
}