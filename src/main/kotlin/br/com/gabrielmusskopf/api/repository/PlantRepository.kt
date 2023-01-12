package br.com.gabrielmusskopf.api.repository

import br.com.gabrielmusskopf.api.model.Plant
import org.springframework.data.jpa.repository.JpaRepository

interface PlantRepository : JpaRepository<Plant, Long> {

	fun getAllByNameOrScientificName(name: String?, scientificName: String?) : List<Plant>

}