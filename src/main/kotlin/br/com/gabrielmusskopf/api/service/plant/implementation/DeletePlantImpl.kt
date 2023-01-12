package br.com.gabrielmusskopf.api.service.plant.implementation

import br.com.gabrielmusskopf.api.exception.BusinessException
import br.com.gabrielmusskopf.api.repository.PlantRepository
import br.com.gabrielmusskopf.api.service.plant.DeletePlantService
import org.springframework.stereotype.Service

@Service
internal class DeletePlantImpl(private val plantRepository: PlantRepository) : DeletePlantService {

	override fun delete(id: Long) {
		if (!plantRepository.existsById(id))
			throw BusinessException("Plant not found.")

		plantRepository.deleteById(id)
	}
}