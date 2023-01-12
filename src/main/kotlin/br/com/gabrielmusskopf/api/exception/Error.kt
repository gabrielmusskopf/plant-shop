package br.com.gabrielmusskopf.api.exception

import org.springframework.http.HttpStatusCode

data class Error(
		val message: String?,
		val code: Int,
		val path: String?
){
	constructor(message: String?, code: HttpStatusCode, path: String?) : this(message, code.value(), path)
	constructor(message: String?, code: HttpStatusCode) : this(message, code.value(), null)
}