package br.com.gabrielmusskopf.api.service.user

import br.com.gabrielmusskopf.api.model.User

interface CreateUserService {

	fun create(user: User) : User


}