package info.startupbuilder.springk8.api.shared

import org.springframework.data.repository.CrudRepository
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Work(
        @Id val id: Long,
        val name: String,
        val description: String
)

interface WorkRepository : CrudRepository<Work, Long>