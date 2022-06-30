package com.dee.domain.mapper

interface UiModelMapper<DomainModel, UIModel> {

    fun mapToPresentation(model: DomainModel): UIModel

    fun mapToDomain(model: UIModel): DomainModel
}