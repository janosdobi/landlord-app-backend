/*
 * This file is generated by jOOQ.
 */
package home.dj.jooq.model


import home.dj.jooq.model.sequences.AGREEMENTS_ID_SEQ
import home.dj.jooq.model.sequences.COSTS_ID_SEQ
import home.dj.jooq.model.sequences.INVOICES_ID_SEQ
import home.dj.jooq.model.sequences.USERS_ID_SEQ
import home.dj.jooq.model.sequences.USER_CREDENTIALS_ID_SEQ
import home.dj.jooq.model.sequences.USER_ROLES_ID_SEQ
import home.dj.jooq.model.tables.Agreements
import home.dj.jooq.model.tables.Costs
import home.dj.jooq.model.tables.Invoices
import home.dj.jooq.model.tables.UserCredentials
import home.dj.jooq.model.tables.UserRoles
import home.dj.jooq.model.tables.Users

import kotlin.collections.List

import org.jooq.Catalog
import org.jooq.Sequence
import org.jooq.Table
import org.jooq.impl.SchemaImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class LandlordApp : SchemaImpl("landlord_app", DefaultCatalog.DEFAULT_CATALOG) {
    companion object {

        /**
         * The reference instance of <code>landlord_app</code>
         */
        val LANDLORD_APP = LandlordApp()
    }

    /**
     * The table <code>landlord_app.agreements</code>.
     */
    val AGREEMENTS get() = Agreements.AGREEMENTS

    /**
     * The table <code>landlord_app.costs</code>.
     */
    val COSTS get() = Costs.COSTS

    /**
     * The table <code>landlord_app.invoices</code>.
     */
    val INVOICES get() = Invoices.INVOICES

    /**
     * The table <code>landlord_app.user_credentials</code>.
     */
    val USER_CREDENTIALS get() = UserCredentials.USER_CREDENTIALS

    /**
     * The table <code>landlord_app.user_roles</code>.
     */
    val USER_ROLES get() = UserRoles.USER_ROLES

    /**
     * The table <code>landlord_app.users</code>.
     */
    val USERS get() = Users.USERS

    override fun getCatalog(): Catalog = DefaultCatalog.DEFAULT_CATALOG

    override fun getSequences(): List<Sequence<*>> = listOf(
        AGREEMENTS_ID_SEQ,
        COSTS_ID_SEQ,
        INVOICES_ID_SEQ,
        USER_CREDENTIALS_ID_SEQ,
        USER_ROLES_ID_SEQ,
        USERS_ID_SEQ
    )

    override fun getTables(): List<Table<*>> = listOf(
        Agreements.AGREEMENTS,
        Costs.COSTS,
        Invoices.INVOICES,
        UserCredentials.USER_CREDENTIALS,
        UserRoles.USER_ROLES,
        Users.USERS
    )
}
