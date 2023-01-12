package br.com.gabrielmusskopf.api.controller

import br.com.gabrielmusskopf.api.model.Plant
import br.com.gabrielmusskopf.api.model.User
import br.com.gabrielmusskopf.api.service.user.CreateUserService
import br.com.gabrielmusskopf.api.service.user.DeleteUserService
import br.com.gabrielmusskopf.api.service.user.GetUserService
import br.com.gabrielmusskopf.api.service.user.UpdateUserDto
import br.com.gabrielmusskopf.api.service.user.UpdateUserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("users")
class UserController(
	private val createUserService: CreateUserService,
	private val getUserService: GetUserService,
	private val updateUserService: UpdateUserService,
	private val deleteUserService: DeleteUserService
) {

	@PostMapping
	fun create(@RequestBody createUserRequest: CreateUserRequest) : UserResponse {
		val user = createUserService.create(User(createUserRequest.name, createUserRequest.nickname, createUserRequest.email))
		val wallet = WalletResponse(user.wallet.amount)

		return UserResponse(user.name, user.nickname, user.email, wallet, user.plants)
	}

	@GetMapping("{id}")
	fun get(@PathVariable id: Long) : UserResponse {
		val user = getUserService.get(id)
		val wallet = WalletResponse(user.wallet.amount)

		return UserResponse(user.name, user.nickname, user.email, wallet, user.plants)
	}

	@PatchMapping
	fun update(@RequestBody updateUserRequest: UpdateUserRequest) : User {
		val user = UpdateUserDto(updateUserRequest.id, updateUserRequest.name, updateUserRequest.nickname, updateUserRequest.email)

		return updateUserService.update(user)
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	fun delete(@PathVariable id: Long) = deleteUserService.delete(id)

	class CreateUserRequest(val name: String, val nickname: String, val email: String)
	class UpdateUserRequest(val id: Long, val name: String?, val nickname: String?, val email: String?)

	class WalletResponse(val credit: BigDecimal)
	class UserResponse(val name: String, val nickname: String, val email: String, val wallet: WalletResponse, val plants: List<Plant>)

}