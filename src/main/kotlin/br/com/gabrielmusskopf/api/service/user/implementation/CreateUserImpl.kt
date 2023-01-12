package br.com.gabrielmusskopf.api.service.user.implementation

import br.com.gabrielmusskopf.api.exception.BusinessException
import br.com.gabrielmusskopf.api.model.User
import br.com.gabrielmusskopf.api.repository.UserRepository
import br.com.gabrielmusskopf.api.service.user.CreateUserService
import org.springframework.stereotype.Service

@Service
internal class CreateUserImpl(
		private val userRepository: UserRepository
) : CreateUserService {

	override fun create(user: User): User {

		val existingUser = userRepository.findByEmail(user.email)

		if (existingUser.isPresent)
			throw BusinessException("This email is already being used.")

		return userRepository.save(user)
	}
}