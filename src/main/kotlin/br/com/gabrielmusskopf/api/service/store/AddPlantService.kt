package br.com.gabrielmusskopf.api.service.store

import br.com.gabrielmusskopf.api.model.Plant

interface AddPlantService {

	fun add(plantToAdd: AddPlantDto, storeId: Long) : Plant

}