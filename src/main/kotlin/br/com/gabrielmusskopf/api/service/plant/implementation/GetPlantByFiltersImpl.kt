package br.com.gabrielmusskopf.api.service.plant.implementation

import br.com.gabrielmusskopf.api.exception.BusinessException
import br.com.gabrielmusskopf.api.model.Plant
import br.com.gabrielmusskopf.api.repository.PlantRepository
import br.com.gabrielmusskopf.api.service.plant.GetPlantByFiltersService
import org.springframework.stereotype.Service

@Service
internal class GetPlantByFiltersImpl(private val plantRepository: PlantRepository) : GetPlantByFiltersService {

	override fun get(name: String?, scientificName: String?): List<Plant> {
		if (name == null && scientificName == null)
			throw BusinessException("At least one filter must be informed.")

		return plantRepository.getAllByNameOrScientificName(name, scientificName)
	}

}