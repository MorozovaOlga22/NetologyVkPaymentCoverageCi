import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun getCommission_defaultParams() {
        val currentAmount = 100_000_000

        val commission = getCommission(
            currentAmount = currentAmount
        )

        assertEquals(0, commission)
    }

    @Test
    fun getCommission_mastercardWithoutCommission() {
        val currentAmount = 100_000
        val cardType = CardType.Mastercard

        val commission = getCommission(
            currentAmount = currentAmount,
            cardType = cardType
        )

        assertEquals(0, commission)
    }

    @Test
    fun getCommission_mastercardWithCommission() {
        val currentAmount = 100_000_000
        val cardType = CardType.Mastercard

        val commission = getCommission(
            currentAmount = currentAmount,
            cardType = cardType
        )

        assertEquals(602000, commission)
    }

    @Test
    fun getCommission_visaWithMinCommission() {
        val currentAmount = 100_000
        val cardType = CardType.Visa

        val commission = getCommission(
            currentAmount = currentAmount,
            cardType = cardType
        )

        assertEquals(3500, commission)
    }

    @Test
    fun getCommission_visaWithPercentsCommission() {
        val currentAmount = 100_000_000
        val cardType = CardType.Visa

        val commission = getCommission(
            currentAmount = currentAmount,
            cardType = cardType
        )

        assertEquals(3500, commission)
    }
}