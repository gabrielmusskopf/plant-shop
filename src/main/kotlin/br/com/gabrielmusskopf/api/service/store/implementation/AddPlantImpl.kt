package br.com.gabrielmusskopf.api.service.store.implementation

import br.com.gabrielmusskopf.api.exception.BusinessException
import br.com.gabrielmusskopf.api.model.Plant
import br.com.gabrielmusskopf.api.repository.StoreRepository
import br.com.gabrielmusskopf.api.service.plant.CreatePlantService
import br.com.gabrielmusskopf.api.service.plant.NewPlantDto
import br.com.gabrielmusskopf.api.service.store.AddPlantDto
import br.com.gabrielmusskopf.api.service.store.AddPlantService
import org.springframework.stereotype.Service

@Service
internal class AddPlantImpl(val createPlantService: CreatePlantService,
							val storeRepository: StoreRepository)
	: AddPlantService {

	override fun add(plantToAdd: AddPlantDto, storeId: Long): Plant {
		val plant = createPlantService.add(NewPlantDto(plantToAdd.name, plantToAdd.scientificName, plantToAdd.price))

		val store = storeRepository.findById(storeId)
			.orElseThrow{ BusinessException("A store with id $storeId does not exist.") }

		val newStore = store.copy(plants = store.plants.plus(plant))
		storeRepository.save(newStore)

		return plant
	}

}