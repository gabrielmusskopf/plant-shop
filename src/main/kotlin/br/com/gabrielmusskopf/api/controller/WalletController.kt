package br.com.gabrielmusskopf.api.controller

import br.com.gabrielmusskopf.api.service.wallet.AddCreditService
import br.com.gabrielmusskopf.api.service.wallet.GetWalletService
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("wallets")
class WalletController(
	val addCreditService: AddCreditService,
	val getWalletService: GetWalletService
) {

	@PostMapping("{userId}")
	fun addCredit(@PathVariable userId: Long, @RequestBody addCreditRequest: AddCreditRequest) =
		addCreditService.add(userId, addCreditRequest.credit)

	@GetMapping("{userId}")
	fun getUsersWallet(@PathVariable userId: Long) : WalletResponse {
		val wallet = getWalletService.get(userId)
		return WalletResponse(wallet.amount)
	}

	class AddCreditRequest(val credit: BigDecimal)
	class WalletResponse(val credit: BigDecimal)
}