package br.com.gabrielmusskopf.api.controller

import br.com.gabrielmusskopf.api.service.store.*
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("stores")
class StoreController(
	val createStoreService: CreateStoreService,
	val addPlantService: AddPlantService,
	val buyPlantService: BuyPlantService
	) {

	@PostMapping
	fun createStore(@RequestBody createStoreRequest: CreateStoreRequest) : StoreResponse {
		val store = createStoreService.create(CreateStoreDto(createStoreRequest.name, createStoreRequest.ownerId))
		val userResponse = UserResponse(store.owner.name)

		return StoreResponse(store.name, userResponse)
	}

	@PostMapping("{storeId}")
	fun addPlantToStore(@PathVariable storeId: Long, @RequestBody addPlantRequest: AddPlantRequest) : PlantResponse {
		val plantToAdd = AddPlantDto(addPlantRequest.name, addPlantRequest.scientificName, addPlantRequest.price)
		val plantAdded = addPlantService.add(plantToAdd, storeId)

		return PlantResponse(plantAdded.name, plantAdded.scientificName, plantAdded.price)
	}

	@PostMapping("{storeId}/buy/{plantId}")
	fun buyPlant(@PathVariable storeId: Long, @PathVariable plantId: Long, @RequestParam userId: Long) =
		buyPlantService.buy(plantId, storeId, userId)

	class CreateStoreRequest(val name: String, val ownerId: Long)
	class AddPlantRequest(val name: String, val scientificName: String, val price: BigDecimal)

	class UserResponse(val name: String)
	class StoreResponse(val name: String, val user: UserResponse)
	class PlantResponse(val name: String, val scientificName: String, val price: BigDecimal)
}