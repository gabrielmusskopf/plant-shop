package br.com.gabrielmusskopf.api.service.user

import br.com.gabrielmusskopf.api.model.User

interface UpdateUserService {

	fun update(updateUserDto: UpdateUserDto) : User

}
