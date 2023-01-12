package br.com.gabrielmusskopf.api.service.wallet

import br.com.gabrielmusskopf.api.model.Wallet

interface GetWalletService {

	fun get(userId: Long) : Wallet

}