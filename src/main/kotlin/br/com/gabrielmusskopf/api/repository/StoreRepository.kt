package br.com.gabrielmusskopf.api.repository

import br.com.gabrielmusskopf.api.model.Store
import org.springframework.data.jpa.repository.JpaRepository

interface StoreRepository : JpaRepository<Store, Long> {
}