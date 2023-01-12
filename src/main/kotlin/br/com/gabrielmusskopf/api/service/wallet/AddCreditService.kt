package br.com.gabrielmusskopf.api.service.wallet

import java.math.BigDecimal

interface AddCreditService {

	fun add(userId: Long, credit: BigDecimal)

}