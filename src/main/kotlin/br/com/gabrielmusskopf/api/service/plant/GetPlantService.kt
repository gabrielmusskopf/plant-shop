package br.com.gabrielmusskopf.api.service.plant

import br.com.gabrielmusskopf.api.model.Plant

interface GetPlantService {

	fun get(id: Long) : Plant

}