package br.com.gabrielmusskopf.api.service.wallet.implementation

import br.com.gabrielmusskopf.api.repository.UserRepository
import br.com.gabrielmusskopf.api.service.user.GetUserService
import br.com.gabrielmusskopf.api.service.wallet.AddCreditService
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
internal class AddCreditImpl(val getUserService: GetUserService, val userRepository: UserRepository)
	: AddCreditService {

	override fun add(userId: Long, credit: BigDecimal) {
		val user = getUserService.get(userId)

		user.wallet.amount += credit;

		userRepository.save(user)
	}

}