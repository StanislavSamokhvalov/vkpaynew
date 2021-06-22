import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun transferVisa_WithMinCommission() {
        val PERCENT_VISA = 0.0075
        val MIN_COMMISSION_VISA = 3500
        val amount = 5000

        val result = transferVisa(
            MIN_COMMISSION_VISA = MIN_COMMISSION_VISA,
            PERCENT_VISA = PERCENT_VISA,
            amount = amount
        )

        assertEquals(3500, result)

    }


    @Test
    fun transferVisa_WithoutMinCommission() {
        val PERCENT_VISA = 0.0075
        val MIN_COMMISSION_VISA = 3500
        val amount = 50000000

        val result = transferVisa(
            MIN_COMMISSION_VISA = MIN_COMMISSION_VISA,
            PERCENT_VISA = PERCENT_VISA,
            amount = amount
        )

        assertEquals(375000.0, result)

    }

    @Test
    fun transferMaster_OverLimit() {
        val PERCENT_MASTER = 0.006
        val ADDITIONAL_COMMISSION_MASTER = 20000
        val amount = 30000000
        val limit = 20000000

        val result = transferMaster(
            ADDITIONAL_COMMISSION_MASTER = ADDITIONAL_COMMISSION_MASTER,
            PERCENT_MASTER = PERCENT_MASTER,
            amount = amount,
            limit = limit
        )

        assertEquals(200000.0, result)

    }

    @Test
    fun transferMaster_BelowLimit() {
        val PERCENT_MASTER = 0.006
        val ADDITIONAL_COMMISSION_MASTER = 20000
        val amount = 500000
        val limit = 0

        val result = transferMaster(
            ADDITIONAL_COMMISSION_MASTER = ADDITIONAL_COMMISSION_MASTER,
            PERCENT_MASTER = PERCENT_MASTER,
            amount = amount,
            limit = limit
        )

        assertEquals(0, result)

    }

    @Test
    fun transferCommission_VkPay() {
        val paymentSystem = "VkPay"
        val amount = 500000
        val limit = 0

        val result = transferCommission(
            paymentSystem = paymentSystem,
            amount = amount,
            limit = limit

        )
        assertEquals(0, result)
    }

    @Test
    fun transferCommission_Visa() {
        val paymentSystem = "Visa"
        val amount = 50000
        val limit = 0

        val result = transferCommission(
            paymentSystem = paymentSystem,
            amount = amount,
            limit = limit

        )
        assertEquals(3500, result)
    }

    @Test
    fun transferCommission_Master() {
        val paymentSystem = "Master"
        val amount = 500000
        val limit = 0

        val result = transferCommission(
            paymentSystem = paymentSystem,
            amount = amount,
            limit = limit

        )
        assertEquals(0, result)
    }

}