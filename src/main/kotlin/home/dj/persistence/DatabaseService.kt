package home.dj.persistence

import home.dj.jooq.model.tables.Users
import home.dj.jooq.model.tables.references.USERS
import io.micronaut.context.annotation.Context
import io.micronaut.context.annotation.Requires
import org.jooq.DSLContext

@Context
@Requires(notEnv = ["test"])
class DatabaseService(
    private val context: DSLContext
) {
    fun getUserById(id: Long) =
        context.select(
            Users.USERS.ID,
            Users.USERS.NAME,
            Users.USERS.TYPE
        )
            .from(USERS)
            .where(Users.USERS.ID.eq(id.toInt()))
            .fetch()

}