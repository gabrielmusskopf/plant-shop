package br.com.gabrielmusskopf.api.service.plant

import br.com.gabrielmusskopf.api.model.Plant

interface CreatePlantService {

	fun add(plant: NewPlantDto) : Plant

}