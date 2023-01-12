package br.com.gabrielmusskopf.api.service.store

import br.com.gabrielmusskopf.api.model.Store

interface GetStoreService {

	fun get(storeId: Long) : Store

}