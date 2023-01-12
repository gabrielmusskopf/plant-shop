package br.com.gabrielmusskopf.api.service.user

import br.com.gabrielmusskopf.api.model.User

interface GetUserService {

	fun get(id: Long) : User

}