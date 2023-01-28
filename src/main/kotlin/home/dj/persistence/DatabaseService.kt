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

    suspend fun getUserRoles(userName: String): List<InternalUserRole> =
        withContext(Dispatchers.IO) {
            context.select(
                UserRoles.USER_ROLES.ROLE_NAME
            )
                .from(USERS)
                .join(USER_ROLES).on(USER_ROLES.USER_ID.eq(USERS.ID))
                .where(Users.USERS.NAME.eq(userName))
                .fetch().map { InternalUserRole.valueOf(it[UserRoles.USER_ROLES.ROLE_NAME]?.name ?: "") }
        }
}
