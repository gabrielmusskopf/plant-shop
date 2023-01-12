package br.com.gabrielmusskopf.api.service.user

data class UpdateUserDto(val id: Long, val name: String?, val nickname: String?, val email: String?)