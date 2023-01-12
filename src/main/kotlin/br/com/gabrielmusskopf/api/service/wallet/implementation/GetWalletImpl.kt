package br.com.gabrielmusskopf.api.service.wallet.implementation

import br.com.gabrielmusskopf.api.model.Wallet
import br.com.gabrielmusskopf.api.service.user.GetUserService
import br.com.gabrielmusskopf.api.service.wallet.GetWalletService
import org.springframework.stereotype.Service

@Service
internal class GetWalletImpl(val getUserService: GetUserService) : GetWalletService {

	override fun get(userId: Long): Wallet = getUserService.get(userId).wallet

}