package com.example.tipcalculator

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat
import java.util.Locale

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundUpWith3Persons() {
        val amount = 10.00
        val tipPercent = 20.00
        val person = 3
        val expectedTip  = NumberFormat.getCurrencyInstance().format(0.67)
        val  actualTip = NumberFormat.getCurrencyInstance()
            .format(calculateTip(amount, tipPercent, person,false))

        assertEquals(expectedTip, actualTip)

    }
    @Test
    fun calculateTip_20PercentRoundUpWith3Persons() {
        val amount = 10.00
        val tipPercent = 20.00
        val person = 3
        val expectedTip  = NumberFormat.getCurrencyInstance().format(1)
        val  actualTip = NumberFormat.getCurrencyInstance()
            .format(calculateTip(amount, tipPercent, person,true))

        assertEquals(expectedTip, actualTip)

    }

    @Test
    fun calculateTip_20PercentNoRoundUp() {
        val amount = 10.00
        val tipPercent = 20.00
        val person = 1
        val expectedTip  = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(2)
        val  actualTip = NumberFormat.getCurrencyInstance(Locale.getDefault())
            .format(calculateTip(amount, tipPercent, person,false))

        assertEquals(expectedTip, actualTip)

    }

    @Test
    fun calculateTotalBill_100BillAmountPlusTip20() {
        val amount = 100.00
        val tip = 20.00
        val expectedTotal = NumberFormat
            .getCurrencyInstance(Locale.getDefault()).format(120)
        val actualTotal = NumberFormat.getCurrencyInstance(Locale.getDefault())
            .format(calculateTotalBill(amount, tip))

        assertEquals(expectedTotal, actualTotal)
    }

    @Test
    fun calculateBill_3Persons() {
        val amount = 120.00
        val person = 3
        val expectedBill = NumberFormat.getCurrencyInstance(Locale.getDefault())
            .format(40)
        val actualBill = NumberFormat.getCurrencyInstance(Locale.getDefault())
            .format(calculateBill(amount, person))

        assertEquals(expectedBill, actualBill)
    }
}