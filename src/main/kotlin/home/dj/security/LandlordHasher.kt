package home.dj.security

import io.micronaut.context.annotation.Context
import io.micronaut.context.annotation.Value
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec


private const val ALG = "HmacSHA512"

@Context
class LandlordHasher(
    @Value("\${landlord.app.hash.key}") private val hashKey: String,
) {

    private val secretKeySpec = SecretKeySpec(hashKey.toByteArray(), ALG)
    private val mac = Mac.getInstance(ALG)

    init {
        mac.init(secretKeySpec)
    }

    fun calculateHash(data: String): String {
        return toHexString(mac.doFinal(data.toByteArray()))
    }

    private fun toHexString(bytes: ByteArray): String {
        val formatter = Formatter()
        for (b in bytes) {
            formatter.format("%02x", b)
        }
        return formatter.toString()
    }
}