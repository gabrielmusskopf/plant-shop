package br.com.gabrielmusskopf.api.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	val id: Long? = null,
	val name: String,
	val email: String,
	val nickname: String = name,
	@JoinColumn(name = "id_wallet")
	@OneToOne(cascade = [CascadeType.ALL])
	val wallet: Wallet = Wallet(),
	@OneToMany
	val plants: List<Plant> = arrayListOf()

) {
	constructor(name: String, email: String, nickname: String) : this(null, name, email, nickname)
}
