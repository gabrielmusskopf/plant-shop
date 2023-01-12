package br.com.gabrielmusskopf.api.service.user.implementation

import br.com.gabrielmusskopf.api.exception.BusinessException
import br.com.gabrielmusskopf.api.repository.UserRepository
import br.com.gabrielmusskopf.api.service.user.DeleteUserService
import org.springframework.stereotype.Service

@Service
internal class DeleteUserImpl(
		private val userRepository: UserRepository
) : DeleteUserService {

	override fun delete(id: Long) {

		val existingUser = userRepository.findById(id)

		if (existingUser.isEmpty)
			throw BusinessException("This user does not exist.")

		userRepository.deleteById(id)
	}
}