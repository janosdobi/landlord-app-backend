/*
 * This file is generated by jOOQ.
 */
package home.dj.jooq.model.tables


import home.dj.jooq.model.LandlordApp
import home.dj.jooq.model.enums.CostCategory
import home.dj.jooq.model.indexes.COST_END_DATE_IDX
import home.dj.jooq.model.indexes.COST_START_DATE_IDX
import home.dj.jooq.model.keys.COSTS_PKEY
import home.dj.jooq.model.keys.COSTS__COSTS_AGREEMENT_ID_FKEY
import home.dj.jooq.model.keys.COSTS__COSTS_INVOICE_ID_FKEY
import home.dj.jooq.model.tables.records.CostsRecord

import java.math.BigDecimal
import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Index
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row10
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
open class Costs(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, CostsRecord>?,
    aliased: Table<CostsRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<CostsRecord>(
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
         * The reference instance of <code>landlord_app.costs</code>
         */
        val COSTS = Costs()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<CostsRecord> = CostsRecord::class.java

    /**
     * The column <code>landlord_app.costs.id</code>.
     */
    val ID: TableField<CostsRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>landlord_app.costs.start_date</code>.
     */
    val START_DATE: TableField<CostsRecord, LocalDateTime?> = createField(DSL.name("start_date"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>landlord_app.costs.end_date</code>.
     */
    val END_DATE: TableField<CostsRecord, LocalDateTime?> = createField(DSL.name("end_date"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>landlord_app.costs.agreement_id</code>.
     */
    val AGREEMENT_ID: TableField<CostsRecord, Int?> = createField(DSL.name("agreement_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>landlord_app.costs.invoice_id</code>.
     */
    val INVOICE_ID: TableField<CostsRecord, Int?> = createField(DSL.name("invoice_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>landlord_app.costs.amount</code>.
     */
    val AMOUNT: TableField<CostsRecord, BigDecimal?> = createField(DSL.name("amount"), SQLDataType.NUMERIC.nullable(false), this, "")

    /**
     * The column <code>landlord_app.costs.cost_category</code>.
     */
    val COST_CATEGORY: TableField<CostsRecord, CostCategory?> = createField(DSL.name("cost_category"), SQLDataType.VARCHAR.nullable(false).asEnumDataType(home.dj.jooq.model.enums.CostCategory::class.java), this, "")

    /**
     * The column <code>landlord_app.costs.created_at</code>.
     */
    val CREATED_AT: TableField<CostsRecord, LocalDateTime?> = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>landlord_app.costs.updated_at</code>.
     */
    val UPDATED_AT: TableField<CostsRecord, LocalDateTime?> = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>landlord_app.costs.created_by</code>.
     */
    val CREATED_BY: TableField<CostsRecord, String?> = createField(DSL.name("created_by"), SQLDataType.VARCHAR(50).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<CostsRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<CostsRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>landlord_app.costs</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>landlord_app.costs</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>landlord_app.costs</code> table reference
     */
    constructor(): this(DSL.name("costs"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, CostsRecord>): this(Internal.createPathAlias(child, key), child, key, COSTS, null)
    override fun getSchema(): Schema = LandlordApp.LANDLORD_APP
    override fun getIndexes(): List<Index> = listOf(COST_END_DATE_IDX, COST_START_DATE_IDX)
    override fun getIdentity(): Identity<CostsRecord, Int?> = super.getIdentity() as Identity<CostsRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<CostsRecord> = COSTS_PKEY
    override fun getKeys(): List<UniqueKey<CostsRecord>> = listOf(COSTS_PKEY)
    override fun getReferences(): List<ForeignKey<CostsRecord, *>> = listOf(COSTS__COSTS_AGREEMENT_ID_FKEY, COSTS__COSTS_INVOICE_ID_FKEY)

    private lateinit var _agreements: Agreements
    private lateinit var _invoices: Invoices
    fun agreements(): Agreements {
        if (!this::_agreements.isInitialized)
            _agreements = Agreements(this, COSTS__COSTS_AGREEMENT_ID_FKEY)

        return _agreements;
    }
    fun invoices(): Invoices {
        if (!this::_invoices.isInitialized)
            _invoices = Invoices(this, COSTS__COSTS_INVOICE_ID_FKEY)

        return _invoices;
    }
    override fun `as`(alias: String): Costs = Costs(DSL.name(alias), this)
    override fun `as`(alias: Name): Costs = Costs(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Costs = Costs(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Costs = Costs(name, null)

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row10<Int?, LocalDateTime?, LocalDateTime?, Int?, Int?, BigDecimal?, CostCategory?, LocalDateTime?, LocalDateTime?, String?> = super.fieldsRow() as Row10<Int?, LocalDateTime?, LocalDateTime?, Int?, Int?, BigDecimal?, CostCategory?, LocalDateTime?, LocalDateTime?, String?>
}