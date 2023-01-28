package home.dj.persistence

import home.dj.jooq.model.tables.UserCredentials
import home.dj.jooq.model.tables.Users
import home.dj.jooq.model.tables.references.USERS
import home.dj.jooq.model.tables.references.USER_CREDENTIALS
import io.micronaut.context.annotation.Context
import io.micronaut.context.annotation.Requires
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jooq.DSLContext

@Context
@Requires(notEnv = ["test"])
class DatabaseService(
    private val context: DSLContext
) {
    suspend fun getCredentialForUser(userName: String): String? =
        withContext(Dispatchers.IO) {
            context.select(
                UserCredentials.USER_CREDENTIALS.CREDENTIAL
            )
                .from(USERS)
                .join(USER_CREDENTIALS).on(USER_CREDENTIALS.USER_ID.eq(USERS.ID))
                .where(Users.USERS.NAME.eq(userName))
                .fetchOne()?.let { it.get(UserCredentials.USER_CREDENTIALS.CREDENTIAL)!! }
        }
}