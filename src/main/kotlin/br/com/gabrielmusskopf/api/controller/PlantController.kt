package br.com.gabrielmusskopf.api.controller

import br.com.gabrielmusskopf.api.service.plant.CreatePlantService
import br.com.gabrielmusskopf.api.service.plant.NewPlantDto
import br.com.gabrielmusskopf.api.service.plant.DeletePlantService
import br.com.gabrielmusskopf.api.service.plant.GetPlantByFiltersService
import br.com.gabrielmusskopf.api.service.plant.GetPlantService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("plants")
class PlantController(
	private val createPlantService: CreatePlantService,
	private val getPlantService: GetPlantService,
	private val getPlantByFiltersService: GetPlantByFiltersService,
	private val deletePlantService: DeletePlantService,
) {

	@PostMapping
	fun addPlantToUser(@RequestBody newPlantRequest: NewPlantRequest) : PlantResponse {
		val plant = createPlantService.add(NewPlantDto(newPlantRequest.name, newPlantRequest.scientificName, newPlantRequest.price))
		return PlantResponse(plant.name, plant.scientificName, plant.price)
	}

	@GetMapping("{id}")
	fun getPlant(@PathVariable id: Long) : PlantResponse {
		val plant = getPlantService.get(id)
		return PlantResponse(plant.name, plant.scientificName, plant.price)
	}

	@GetMapping
	fun getPlantByFields(@RequestParam(required = false) name: String?,
						 @RequestParam(required = false) scientificName: String?)
	: List<PlantResponse> {
		val plants = getPlantByFiltersService.get(name, scientificName)
		return plants.map { PlantResponse(it.name, it.scientificName, it.price) }
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	fun delete(@PathVariable id: Long) = deletePlantService.delete(id)

	class NewPlantRequest(val name: String, val scientificName: String, val price: BigDecimal)

	class PlantResponse(val name: String, val scientificName: String, val price: BigDecimal)

}