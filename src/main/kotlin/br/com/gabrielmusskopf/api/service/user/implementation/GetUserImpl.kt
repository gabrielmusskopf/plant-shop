package br.com.gabrielmusskopf.api.service.user.implementation

import br.com.gabrielmusskopf.api.exception.BusinessException
import br.com.gabrielmusskopf.api.model.User
import br.com.gabrielmusskopf.api.repository.UserRepository
import br.com.gabrielmusskopf.api.service.user.GetUserService
import org.springframework.stereotype.Service

@Service
internal class GetUserImpl(
		private val userRepository: UserRepository
) : GetUserService {

	override fun get(id: Long): User {
		return userRepository.findById(id)
				.orElseThrow { BusinessException("User with '$id' not found.") }
	}

}