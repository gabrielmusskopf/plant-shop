package br.com.gabrielmusskopf.api.service.user.implementation

import br.com.gabrielmusskopf.api.model.User
import br.com.gabrielmusskopf.api.repository.UserRepository
import br.com.gabrielmusskopf.api.service.user.GetUserService
import br.com.gabrielmusskopf.api.service.user.UpdateUserDto
import br.com.gabrielmusskopf.api.service.user.UpdateUserService
import org.springframework.stereotype.Service

@Service
internal class UpdateUserImpl(
	private val userRepository: UserRepository,
	private val getUserService: GetUserService
) : UpdateUserService {

	override fun update(updateUserDto: UpdateUserDto): User {

		val user = getUserService.get(updateUserDto.id)

		val updatedUser = user.copy(
				name = updateUserDto.name ?: user.name,
				nickname = updateUserDto.nickname ?: user.nickname,
				email = updateUserDto.email ?: user.email
		)

		return userRepository.save(updatedUser)
	}

}