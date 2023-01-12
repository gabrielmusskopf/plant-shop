package br.com.gabrielmusskopf.api.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name =  "store")
data class Store(
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	val id: Long? = null,

	val name: String,

	@ManyToOne
	@JoinColumn(name = "id_user")
	val owner: User,

	@OneToMany
	val plants: List<Plant> = arrayListOf(),

	val money: BigDecimal = BigDecimal.ZERO
){
	constructor(name: String, owner: User) : this(null, name, owner)
}