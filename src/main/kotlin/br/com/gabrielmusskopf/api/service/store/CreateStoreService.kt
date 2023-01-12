package br.com.gabrielmusskopf.api.service.store

import br.com.gabrielmusskopf.api.model.Store

interface CreateStoreService {

	fun create(createStoreDto: CreateStoreDto) : Store

}