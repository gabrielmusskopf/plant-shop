package br.com.gabrielmusskopf.api.service.store

interface BuyPlantService {

	fun buy(plantId: Long, storeId: Long, userId: Long)

}