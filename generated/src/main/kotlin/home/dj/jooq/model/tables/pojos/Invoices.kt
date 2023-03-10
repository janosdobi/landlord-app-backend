/*
 * This file is generated by jOOQ.
 */
package home.dj.jooq.model.tables.pojos


import home.dj.jooq.model.enums.CostCategory

import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDateTime


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class Invoices(
    val id: Int? = null, 
    val startDate: LocalDateTime? = null, 
    val endDate: LocalDateTime? = null, 
    val agreementId: Int? = null, 
    val amount: BigDecimal? = null, 
    val costCategory: CostCategory? = null, 
    val fileName: String? = null, 
    val fileContent: ByteArray? = null, 
    val createdAt: LocalDateTime? = null, 
    val updatedAt: LocalDateTime? = null, 
    val createdBy: String? = null
): Serializable {

    override fun toString(): String {
        val sb = StringBuilder("Invoices (")

        sb.append(id)
        sb.append(", ").append(startDate)
        sb.append(", ").append(endDate)
        sb.append(", ").append(agreementId)
        sb.append(", ").append(amount)
        sb.append(", ").append(costCategory)
        sb.append(", ").append(fileName)
        sb.append(", ").append("[binary...]")
        sb.append(", ").append(createdAt)
        sb.append(", ").append(updatedAt)
        sb.append(", ").append(createdBy)

        sb.append(")")
        return sb.toString()
    }
}
