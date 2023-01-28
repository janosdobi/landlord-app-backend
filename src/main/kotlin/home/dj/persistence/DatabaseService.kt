package home.dj.persistence

import home.dj.jooq.model.tables.UserCredentials
import home.dj.jooq.model.tables.UserRoles
import home.dj.jooq.model.tables.Users
import home.dj.jooq.model.tables.references.USERS
import home.dj.jooq.model.tables.references.USER_CREDENTIALS
import home.dj.jooq.model.tables.references.USER_ROLES
import io.micronaut.context.annotation.Context
import io.micronaut.context.annotation.Requires
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jooq.DSLContext
import home.dj.domain.UserRole as InternalUserRole

@Context
@Requires(notEnv = ["test"])
class DatabaseService(
    private val context: DSLContext
) {
    suspend fun getCredentialAndIdForUser(userName: String): Pair<String, Int> =
        withContext(Dispatchers.IO) {
            context.select(
                UserCredentials.USER_CREDENTIALS.CREDENTIAL,
                Users.USERS.ID
            )
                .from(USERS)
                .join(USER_CREDENTIALS).on(USER_CREDENTIALS.USER_ID.eq(USERS.ID))
                .where(Users.USERS.NAME.eq(userName))
                .fetchOne()
                ?.let {
                    it[UserCredentials.USER_CREDENTIALS.CREDENTIAL]!! to it[Users.USERS.ID]!!
                } ?: ("" to -1)
        }

    suspend fun getUserRoles(uid: Int): List<InternalUserRole> =
        withContext(Dispatchers.IO) {
            context.select(
                UserRoles.USER_ROLES.ROLE_NAME
            )
                .from(USER_ROLES)
                .where(USER_ROLES.USER_ID.eq(uid))
                .fetch().map { InternalUserRole.valueOf(it[UserRoles.USER_ROLES.ROLE_NAME]?.name ?: "") }
        }
}
