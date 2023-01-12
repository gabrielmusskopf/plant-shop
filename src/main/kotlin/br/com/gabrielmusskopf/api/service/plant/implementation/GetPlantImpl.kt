package br.com.gabrielmusskopf.api.service.plant.implementation

import br.com.gabrielmusskopf.api.exception.BusinessException
import br.com.gabrielmusskopf.api.model.Plant
import br.com.gabrielmusskopf.api.repository.PlantRepository
import br.com.gabrielmusskopf.api.service.plant.GetPlantService
import org.springframework.stereotype.Service

@Service
internal class GetPlantImpl(
	private val plantRepository: PlantRepository
) : GetPlantService {

	override fun get(id: Long): Plant {
		return plantRepository.findById(id)
			.orElseThrow { BusinessException("Plant not found.") };
	}

}