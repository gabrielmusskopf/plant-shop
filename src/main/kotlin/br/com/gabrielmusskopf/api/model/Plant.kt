package br.com.gabrielmusskopf.api.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "plant")
data class Plant(val name: String, val scientificName: String, val price: BigDecimal) {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	val id: Long? = null
	val health: Int = 100
}