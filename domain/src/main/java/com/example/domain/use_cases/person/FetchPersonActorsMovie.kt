package com.example.domain.use_cases.person

import com.example.domain.models.person_models_domain.ResultDomain

interface FetchPersonActorsMovie {

    suspend operator fun invoke(page: Int): Result<List<ResultDomain>>

}