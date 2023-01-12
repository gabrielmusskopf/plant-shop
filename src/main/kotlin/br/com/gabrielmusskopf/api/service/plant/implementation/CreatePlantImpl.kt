package br.com.gabrielmusskopf.api.service.plant.implementation

import br.com.gabrielmusskopf.api.model.Plant
import br.com.gabrielmusskopf.api.repository.PlantRepository
import br.com.gabrielmusskopf.api.service.plant.NewPlantDto
import br.com.gabrielmusskopf.api.service.plant.CreatePlantService
import org.springframework.stereotype.Service

@Service
internal class CreatePlantImpl(private val plantRepository : PlantRepository) : CreatePlantService {

	override fun add(newPlant: NewPlantDto): Plant {
		val plant = Plant(newPlant.name, newPlant.scientificName, newPlant.price)
		return plantRepository.save(plant)
	}

}