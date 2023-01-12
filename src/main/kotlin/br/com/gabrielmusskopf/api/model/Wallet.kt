package br.com.gabrielmusskopf.api.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "wallet")
data class Wallet(
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	val id: Long? = null,
	var amount: BigDecimal = BigDecimal.ZERO
)