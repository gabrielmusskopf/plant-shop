package br.com.gabrielmusskopf.api.service.plant

import br.com.gabrielmusskopf.api.model.Plant

interface GetPlantByFiltersService {

	fun get(name: String?, scientificName: String?) : List<Plant>

}