package br.com.gabrielmusskopf.api.service.store.implementation

import br.com.gabrielmusskopf.api.exception.BusinessException
import br.com.gabrielmusskopf.api.model.Wallet
import br.com.gabrielmusskopf.api.repository.StoreRepository
import br.com.gabrielmusskopf.api.repository.UserRepository
import br.com.gabrielmusskopf.api.service.store.BuyPlantService
import br.com.gabrielmusskopf.api.service.store.GetStoreService
import br.com.gabrielmusskopf.api.service.user.GetUserService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
internal class BuyPlantImpl(
	val getUserService: GetUserService,
	val getStoreService: GetStoreService,
	val storeRepository: StoreRepository,
	val userRepository: UserRepository
) : BuyPlantService {

	@Transactional
	override fun buy(plantId: Long, storeId: Long, userId: Long) {
		val store = getStoreService.get(storeId)

		val plant = store.plants.find { it.id == plantId }
			?: throw BusinessException("This store does not have this plant.")
		val user = getUserService.get(userId)

		if (user.wallet.amount < plant.price)
			throw BusinessException("This user does not have enough money to buy this plant.")

		val updatedStorePlants = store.plants.filter { it != plant }
		val updatedStore = store.copy(plants = updatedStorePlants, money = store.money + plant.price)

		val updatedWallet = user.wallet.copy(amount = user.wallet.amount - plant.price)
		val updatedUser = user.copy(plants = user.plants.plus(plant), wallet = updatedWallet)

		storeRepository.save(updatedStore)
		userRepository.save(updatedUser)
	}

}