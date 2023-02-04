/*
 * This file is generated by jOOQ.
 */
package home.dj.jooq.model.tables


import home.dj.jooq.model.LandlordApp
import home.dj.jooq.model.enums.CostCategory
import home.dj.jooq.model.keys.INVOICES_PKEY
import home.dj.jooq.model.keys.INVOICES__INVOICES_AGREEMENT_ID_FKEY
import home.dj.jooq.model.tables.records.InvoicesRecord

import java.math.BigDecimal
import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row11
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
open class Invoices(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, InvoicesRecord>?,
    aliased: Table<InvoicesRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<InvoicesRecord>(
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
         * The reference instance of <code>landlord_app.invoices</code>
         */
        val INVOICES = Invoices()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<InvoicesRecord> = InvoicesRecord::class.java

    /**
     * The column <code>landlord_app.invoices.id</code>.
     */
    val ID: TableField<InvoicesRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>landlord_app.invoices.start_date</code>.
     */
    val START_DATE: TableField<InvoicesRecord, LocalDateTime?> = createField(DSL.name("start_date"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>landlord_app.invoices.end_date</code>.
     */
    val END_DATE: TableField<InvoicesRecord, LocalDateTime?> = createField(DSL.name("end_date"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>landlord_app.invoices.agreement_id</code>.
     */
    val AGREEMENT_ID: TableField<InvoicesRecord, Int?> = createField(DSL.name("agreement_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>landlord_app.invoices.amount</code>.
     */
    val AMOUNT: TableField<InvoicesRecord, BigDecimal?> = createField(DSL.name("amount"), SQLDataType.NUMERIC.nullable(false), this, "")

    /**
     * The column <code>landlord_app.invoices.cost_category</code>.
     */
    val COST_CATEGORY: TableField<InvoicesRecord, CostCategory?> = createField(DSL.name("cost_category"), SQLDataType.VARCHAR.nullable(false).asEnumDataType(home.dj.jooq.model.enums.CostCategory::class.java), this, "")

    /**
     * The column <code>landlord_app.invoices.file_name</code>.
     */
    val FILE_NAME: TableField<InvoicesRecord, String?> = createField(DSL.name("file_name"), SQLDataType.VARCHAR(100).nullable(false), this, "")

    /**
     * The column <code>landlord_app.invoices.file_content</code>.
     */
    val FILE_CONTENT: TableField<InvoicesRecord, ByteArray?> = createField(DSL.name("file_content"), SQLDataType.BLOB.nullable(false), this, "")

    /**
     * The column <code>landlord_app.invoices.created_at</code>.
     */
    val CREATED_AT: TableField<InvoicesRecord, LocalDateTime?> = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>landlord_app.invoices.updated_at</code>.
     */
    val UPDATED_AT: TableField<InvoicesRecord, LocalDateTime?> = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>landlord_app.invoices.created_by</code>.
     */
    val CREATED_BY: TableField<InvoicesRecord, String?> = createField(DSL.name("created_by"), SQLDataType.VARCHAR(50).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<InvoicesRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<InvoicesRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>landlord_app.invoices</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>landlord_app.invoices</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>landlord_app.invoices</code> table reference
     */
    constructor(): this(DSL.name("invoices"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, InvoicesRecord>): this(Internal.createPathAlias(child, key), child, key, INVOICES, null)
    override fun getSchema(): Schema = LandlordApp.LANDLORD_APP
    override fun getIdentity(): Identity<InvoicesRecord, Int?> = super.getIdentity() as Identity<InvoicesRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<InvoicesRecord> = INVOICES_PKEY
    override fun getKeys(): List<UniqueKey<InvoicesRecord>> = listOf(INVOICES_PKEY)
    override fun getReferences(): List<ForeignKey<InvoicesRecord, *>> = listOf(INVOICES__INVOICES_AGREEMENT_ID_FKEY)

    private lateinit var _agreements: Agreements
    fun agreements(): Agreements {
        if (!this::_agreements.isInitialized)
            _agreements = Agreements(this, INVOICES__INVOICES_AGREEMENT_ID_FKEY)

        return _agreements;
    }
    override fun `as`(alias: String): Invoices = Invoices(DSL.name(alias), this)
    override fun `as`(alias: Name): Invoices = Invoices(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Invoices = Invoices(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Invoices = Invoices(name, null)

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row11<Int?, LocalDateTime?, LocalDateTime?, Int?, BigDecimal?, CostCategory?, String?, ByteArray?, LocalDateTime?, LocalDateTime?, String?> = super.fieldsRow() as Row11<Int?, LocalDateTime?, LocalDateTime?, Int?, BigDecimal?, CostCategory?, String?, ByteArray?, LocalDateTime?, LocalDateTime?, String?>
}
