const val PERCENT_VISA = 0.0075
const val MIN_COMMISSION_VISA = 3500
const val PERCENT_MASTER = 0.006
const val ADDITIONAL_COMMISSION_MASTER = 20000


fun transferVisa(
    MIN_COMMISSION_VISA: Int,
    PERCENT_VISA: Double,
    amount: Int
): Number {
    return if (amount * PERCENT_VISA <= MIN_COMMISSION_VISA) MIN_COMMISSION_VISA else amount * PERCENT_VISA
}

fun transferMaster(
    ADDITIONAL_COMMISSION_MASTER: Int,
    PERCENT_MASTER: Double,
    amount: Int,
    limit: Int
): Number {
    return if (limit + amount > 7500000) amount * PERCENT_MASTER + ADDITIONAL_COMMISSION_MASTER else 0
}


fun transferCommission(
    paymentSystem: String = "VkPay",
    amount: Int,
    limit: Int = 0
): Number {
    return when (paymentSystem) {
        "VkPay" -> 0
        "Visa", "Мир" -> transferVisa(MIN_COMMISSION_VISA, PERCENT_VISA, amount)
        "Mastercard", "Maestro" -> transferMaster(ADDITIONAL_COMMISSION_MASTER, PERCENT_MASTER, amount, limit)
        else -> 0
    }
}

fun main() {
    val result = transferCommission(paymentSystem = "Visa", amount = 50000000)
    println("комиссия составит: $result (в копейках)")
}