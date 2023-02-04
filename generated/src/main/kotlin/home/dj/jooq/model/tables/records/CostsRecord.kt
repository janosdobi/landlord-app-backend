/*
 * This file is generated by jOOQ.
 */
package home.dj.jooq.model.tables.records


import home.dj.jooq.model.enums.CostCategory
import home.dj.jooq.model.tables.Costs

import java.math.BigDecimal
import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record10
import org.jooq.Row10
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class CostsRecord() : UpdatableRecordImpl<CostsRecord>(Costs.COSTS), Record10<Int?, LocalDateTime?, LocalDateTime?, Int?, Int?, BigDecimal?, CostCategory?, LocalDateTime?, LocalDateTime?, String?> {

    var id: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var startDate: LocalDateTime?
        set(value) = set(1, value)
        get() = get(1) as LocalDateTime?

    var endDate: LocalDateTime?
        set(value) = set(2, value)
        get() = get(2) as LocalDateTime?

    var agreementId: Int?
        set(value) = set(3, value)
        get() = get(3) as Int?

    var invoiceId: Int?
        set(value) = set(4, value)
        get() = get(4) as Int?

    var amount: BigDecimal?
        set(value) = set(5, value)
        get() = get(5) as BigDecimal?

    var costCategory: CostCategory?
        set(value) = set(6, value)
        get() = get(6) as CostCategory?

    var createdAt: LocalDateTime?
        set(value) = set(7, value)
        get() = get(7) as LocalDateTime?

    var updatedAt: LocalDateTime?
        set(value) = set(8, value)
        get() = get(8) as LocalDateTime?

    var createdBy: String?
        set(value) = set(9, value)
        get() = get(9) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row10<Int?, LocalDateTime?, LocalDateTime?, Int?, Int?, BigDecimal?, CostCategory?, LocalDateTime?, LocalDateTime?, String?> = super.fieldsRow() as Row10<Int?, LocalDateTime?, LocalDateTime?, Int?, Int?, BigDecimal?, CostCategory?, LocalDateTime?, LocalDateTime?, String?>
    override fun valuesRow(): Row10<Int?, LocalDateTime?, LocalDateTime?, Int?, Int?, BigDecimal?, CostCategory?, LocalDateTime?, LocalDateTime?, String?> = super.valuesRow() as Row10<Int?, LocalDateTime?, LocalDateTime?, Int?, Int?, BigDecimal?, CostCategory?, LocalDateTime?, LocalDateTime?, String?>
    override fun field1(): Field<Int?> = Costs.COSTS.ID
    override fun field2(): Field<LocalDateTime?> = Costs.COSTS.START_DATE
    override fun field3(): Field<LocalDateTime?> = Costs.COSTS.END_DATE
    override fun field4(): Field<Int?> = Costs.COSTS.AGREEMENT_ID
    override fun field5(): Field<Int?> = Costs.COSTS.INVOICE_ID
    override fun field6(): Field<BigDecimal?> = Costs.COSTS.AMOUNT
    override fun field7(): Field<CostCategory?> = Costs.COSTS.COST_CATEGORY
    override fun field8(): Field<LocalDateTime?> = Costs.COSTS.CREATED_AT
    override fun field9(): Field<LocalDateTime?> = Costs.COSTS.UPDATED_AT
    override fun field10(): Field<String?> = Costs.COSTS.CREATED_BY
    override fun component1(): Int? = id
    override fun component2(): LocalDateTime? = startDate
    override fun component3(): LocalDateTime? = endDate
    override fun component4(): Int? = agreementId
    override fun component5(): Int? = invoiceId
    override fun component6(): BigDecimal? = amount
    override fun component7(): CostCategory? = costCategory
    override fun component8(): LocalDateTime? = createdAt
    override fun component9(): LocalDateTime? = updatedAt
    override fun component10(): String? = createdBy
    override fun value1(): Int? = id
    override fun value2(): LocalDateTime? = startDate
    override fun value3(): LocalDateTime? = endDate
    override fun value4(): Int? = agreementId
    override fun value5(): Int? = invoiceId
    override fun value6(): BigDecimal? = amount
    override fun value7(): CostCategory? = costCategory
    override fun value8(): LocalDateTime? = createdAt
    override fun value9(): LocalDateTime? = updatedAt
    override fun value10(): String? = createdBy

    override fun value1(value: Int?): CostsRecord {
        this.id = value
        return this
    }

    override fun value2(value: LocalDateTime?): CostsRecord {
        this.startDate = value
        return this
    }

    override fun value3(value: LocalDateTime?): CostsRecord {
        this.endDate = value
        return this
    }

    override fun value4(value: Int?): CostsRecord {
        this.agreementId = value
        return this
    }

    override fun value5(value: Int?): CostsRecord {
        this.invoiceId = value
        return this
    }

    override fun value6(value: BigDecimal?): CostsRecord {
        this.amount = value
        return this
    }

    override fun value7(value: CostCategory?): CostsRecord {
        this.costCategory = value
        return this
    }

    override fun value8(value: LocalDateTime?): CostsRecord {
        this.createdAt = value
        return this
    }

    override fun value9(value: LocalDateTime?): CostsRecord {
        this.updatedAt = value
        return this
    }

    override fun value10(value: String?): CostsRecord {
        this.createdBy = value
        return this
    }

    override fun values(value1: Int?, value2: LocalDateTime?, value3: LocalDateTime?, value4: Int?, value5: Int?, value6: BigDecimal?, value7: CostCategory?, value8: LocalDateTime?, value9: LocalDateTime?, value10: String?): CostsRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        this.value7(value7)
        this.value8(value8)
        this.value9(value9)
        this.value10(value10)
        return this
    }

    /**
     * Create a detached, initialised CostsRecord
     */
    constructor(id: Int? = null, startDate: LocalDateTime? = null, endDate: LocalDateTime? = null, agreementId: Int? = null, invoiceId: Int? = null, amount: BigDecimal? = null, costCategory: CostCategory? = null, createdAt: LocalDateTime? = null, updatedAt: LocalDateTime? = null, createdBy: String? = null): this() {
        this.id = id
        this.startDate = startDate
        this.endDate = endDate
        this.agreementId = agreementId
        this.invoiceId = invoiceId
        this.amount = amount
        this.costCategory = costCategory
        this.createdAt = createdAt
        this.updatedAt = updatedAt
        this.createdBy = createdBy
    }
}
