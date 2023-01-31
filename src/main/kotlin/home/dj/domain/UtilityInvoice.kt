package home.dj.domain

import com.fasterxml.jackson.annotation.JsonProperty
import home.dj.domain.request.InvoiceRequest
import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.Min

@Serdeable
data class UtilityInvoice(
    @field:Min(0)
    val id: Long = 0,
    @field:Min(0)
    val amount: Double,
    @field:JsonProperty("start_date")
    val startDate: LocalDate,
    @field:JsonProperty("end_date")
    val endDate: LocalDate,
    @field:Valid
    @field:JsonProperty("cost_category")
    val costCategory: CostCategory,
    @field:JsonProperty("file_name")
    val fileName: String,
    @field:JsonProperty("file_content")
    val fileContent: ByteArray,
    val agreementId: Long
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UtilityInvoice

        if (id != other.id) return false
        if (amount != other.amount) return false
        if (startDate != other.startDate) return false
        if (endDate != other.endDate) return false
        if (costCategory != other.costCategory) return false
        if (fileName != other.fileName) return false
        if (!fileContent.contentEquals(other.fileContent)) return false
        if (agreementId != other.agreementId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + amount.hashCode()
        result = 31 * result + startDate.hashCode()
        result = 31 * result + endDate.hashCode()
        result = 31 * result + costCategory.hashCode()
        result = 31 * result + fileName.hashCode()
        result = 31 * result + fileContent.contentHashCode()
        result = 31 * result + agreementId.toInt()
        return result
    }

    companion object {
        fun fromRequest(request: InvoiceRequest, fileContent: ByteArray) = UtilityInvoice(
            amount = request.amount,
            startDate = request.startDate,
            endDate = request.endDate,
            costCategory = request.costCategory,
            fileName = request.fileName,
            fileContent = fileContent,
            agreementId = request.agreementId
        )
    }
}
