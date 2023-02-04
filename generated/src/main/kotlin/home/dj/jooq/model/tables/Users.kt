/*
 * This file is generated by jOOQ.
 */
package home.dj.jooq.model.tables


import home.dj.jooq.model.LandlordApp
import home.dj.jooq.model.indexes.USERS_NAME_IDX
import home.dj.jooq.model.keys.USERS_NAME_KEY
import home.dj.jooq.model.keys.USERS_PKEY
import home.dj.jooq.model.tables.records.UsersRecord

import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Index
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row5
import org.jooq.Schema
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Users(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, UsersRecord>?,
    aliased: Table<UsersRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<UsersRecord>(
    alias,
    LandlordApp.LANDLORD_APP,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>landlord_app.users</code>
         */
        val USERS = Users()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<UsersRecord> = UsersRecord::class.java

    /**
     * The column <code>landlord_app.users.id</code>.
     */
    val ID: TableField<UsersRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>landlord_app.users.name</code>.
     */
    val NAME: TableField<UsersRecord, String?> = createField(DSL.name("name"), SQLDataType.VARCHAR(50).nullable(false), this, "")

    /**
     * The column <code>landlord_app.users.created_at</code>.
     */
    val CREATED_AT: TableField<UsersRecord, LocalDateTime?> = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>landlord_app.users.updated_at</code>.
     */
    val UPDATED_AT: TableField<UsersRecord, LocalDateTime?> = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>landlord_app.users.created_by</code>.
     */
    val CREATED_BY: TableField<UsersRecord, String?> = createField(DSL.name("created_by"), SQLDataType.VARCHAR(50).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<UsersRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<UsersRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>landlord_app.users</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>landlord_app.users</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>landlord_app.users</code> table reference
     */
    constructor(): this(DSL.name("users"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, UsersRecord>): this(Internal.createPathAlias(child, key), child, key, USERS, null)
    override fun getSchema(): Schema = LandlordApp.LANDLORD_APP
    override fun getIndexes(): List<Index> = listOf(USERS_NAME_IDX)
    override fun getIdentity(): Identity<UsersRecord, Int?> = super.getIdentity() as Identity<UsersRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<UsersRecord> = USERS_PKEY
    override fun getKeys(): List<UniqueKey<UsersRecord>> = listOf(USERS_PKEY, USERS_NAME_KEY)
    override fun `as`(alias: String): Users = Users(DSL.name(alias), this)
    override fun `as`(alias: Name): Users = Users(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Users = Users(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Users = Users(name, null)

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row5<Int?, String?, LocalDateTime?, LocalDateTime?, String?> = super.fieldsRow() as Row5<Int?, String?, LocalDateTime?, LocalDateTime?, String?>
}
