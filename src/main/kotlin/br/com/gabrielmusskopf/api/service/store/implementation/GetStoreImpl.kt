package br.com.gabrielmusskopf.api.service.store.implementation

import br.com.gabrielmusskopf.api.exception.BusinessException
import br.com.gabrielmusskopf.api.model.Store
import br.com.gabrielmusskopf.api.repository.StoreRepository
import br.com.gabrielmusskopf.api.service.store.GetStoreService
import org.springframework.stereotype.Service

@Service
internal class GetStoreImpl(
	val storeRepository: StoreRepository
): GetStoreService{

	override fun get(storeId: Long): Store = storeRepository
		.findById(storeId)
		.orElseThrow { BusinessException("A store with id $storeId does not exist.") }

}