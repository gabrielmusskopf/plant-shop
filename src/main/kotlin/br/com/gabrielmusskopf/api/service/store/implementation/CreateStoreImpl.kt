package br.com.gabrielmusskopf.api.service.store.implementation

import br.com.gabrielmusskopf.api.model.Store
import br.com.gabrielmusskopf.api.repository.StoreRepository
import br.com.gabrielmusskopf.api.service.store.CreateStoreDto
import br.com.gabrielmusskopf.api.service.store.CreateStoreService
import br.com.gabrielmusskopf.api.service.user.GetUserService
import org.springframework.stereotype.Service

@Service
internal class CreateStoreImpl(val storeRepository: StoreRepository, val getUserService: GetUserService): CreateStoreService {

	override fun create(createStoreDto: CreateStoreDto): Store {
		val user = getUserService.get(createStoreDto.ownerId)
		val store = Store(createStoreDto.name, user)

		return storeRepository.save(store)
	}

}