/*
 * This file is generated by jOOQ.
 */
package home.dj.jooq.model.tables.records


import home.dj.jooq.model.tables.Users

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record5
import org.jooq.Row5
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class UsersRecord() : UpdatableRecordImpl<UsersRecord>(Users.USERS), Record5<Int?, String?, LocalDateTime?, LocalDateTime?, String?> {

    var id: Int?
        set(value) = set(0, value)
        get() = get(0) as Int?

    var name: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var createdAt: LocalDateTime?
        set(value) = set(2, value)
        get() = get(2) as LocalDateTime?

    var updatedAt: LocalDateTime?
        set(value) = set(3, value)
        get() = get(3) as LocalDateTime?

    var createdBy: String?
        set(value) = set(4, value)
        get() = get(4) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row5<Int?, String?, LocalDateTime?, LocalDateTime?, String?> = super.fieldsRow() as Row5<Int?, String?, LocalDateTime?, LocalDateTime?, String?>
    override fun valuesRow(): Row5<Int?, String?, LocalDateTime?, LocalDateTime?, String?> = super.valuesRow() as Row5<Int?, String?, LocalDateTime?, LocalDateTime?, String?>
    override fun field1(): Field<Int?> = Users.USERS.ID
    override fun field2(): Field<String?> = Users.USERS.NAME
    override fun field3(): Field<LocalDateTime?> = Users.USERS.CREATED_AT
    override fun field4(): Field<LocalDateTime?> = Users.USERS.UPDATED_AT
    override fun field5(): Field<String?> = Users.USERS.CREATED_BY
    override fun component1(): Int? = id
    override fun component2(): String? = name
    override fun component3(): LocalDateTime? = createdAt
    override fun component4(): LocalDateTime? = updatedAt
    override fun component5(): String? = createdBy
    override fun value1(): Int? = id
    override fun value2(): String? = name
    override fun value3(): LocalDateTime? = createdAt
    override fun value4(): LocalDateTime? = updatedAt
    override fun value5(): String? = createdBy

    override fun value1(value: Int?): UsersRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): UsersRecord {
        this.name = value
        return this
    }

    override fun value3(value: LocalDateTime?): UsersRecord {
        this.createdAt = value
        return this
    }

    override fun value4(value: LocalDateTime?): UsersRecord {
        this.updatedAt = value
        return this
    }

    override fun value5(value: String?): UsersRecord {
        this.createdBy = value
        return this
    }

    override fun values(value1: Int?, value2: String?, value3: LocalDateTime?, value4: LocalDateTime?, value5: String?): UsersRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        return this
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    constructor(id: Int? = null, name: String? = null, createdAt: LocalDateTime? = null, updatedAt: LocalDateTime? = null, createdBy: String? = null): this() {
        this.id = id
        this.name = name
        this.createdAt = createdAt
        this.updatedAt = updatedAt
        this.createdBy = createdBy
    }
}
