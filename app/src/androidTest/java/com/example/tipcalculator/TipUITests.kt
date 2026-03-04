package com.example.tipcalculator

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat
import java.util.Locale

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                TipCalculatorLayout()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")

        composeTestRule.onNodeWithText("20%")
            .performClick()

        val expectedTip = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(2)

        composeTestRule
            .onNodeWithTag("tip_amount")
            .assertTextEquals(expectedTip)
    }

    @Test
    fun calculate_40_percent_tip_2_persons() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                TipCalculatorLayout()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")

        composeTestRule.onNodeWithTag("tip_input")
            .performTextInput("40")

        composeTestRule.onNodeWithTag("person_plus").performClick()
        composeTestRule.waitForIdle()

        val expectedTip = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(2)

        composeTestRule
            .onNodeWithTag("tip_amount")
            .assertTextEquals(expectedTip)
    }

    @Test
    fun calculate_40_percent_tip_2_persons_bill() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                TipCalculatorLayout()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")

        composeTestRule.onNodeWithTag("tip_input")
            .performTextInput("40")

        composeTestRule.onNodeWithTag("person_plus").performClick()
        composeTestRule.waitForIdle()

        val expectedBill = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(5)

        composeTestRule
            .onNodeWithTag("bill_amount")
            .assertTextEquals(expectedBill)
    }

    @Test
    fun calculate_40_percent_tip_2_persons_total() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                TipCalculatorLayout()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")

        composeTestRule.onNodeWithTag("tip_input")
            .performTextInput("40")

        composeTestRule.onNodeWithTag("person_plus").performClick()
        composeTestRule.waitForIdle()

        val expectedTotal = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(7)

        composeTestRule
            .onNodeWithTag("total_amount")
            .assertTextEquals(expectedTotal)
    }

    @Test
    fun calculate_40_percent_tip_3_persons_roundUp() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                TipCalculatorLayout()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")

        composeTestRule.onNodeWithTag("tip_input")
            .performTextInput("40")

        composeTestRule.onNodeWithTag("person_plus").performClick()
        composeTestRule.onNodeWithTag("person_plus").performClick()
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithTag("round_switch")
            .performClick()

        val expectedTip = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(2)

        composeTestRule
            .onNodeWithTag("tip_amount")
            .assertTextEquals(expectedTip)
    }

    @Test
    fun calculate_40_percent_tip_3_persons() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                TipCalculatorLayout()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")

        composeTestRule.onNodeWithTag("tip_input")
            .performTextInput("40")

        composeTestRule.onNodeWithTag("person_plus").performClick()
        composeTestRule.onNodeWithTag("person_plus").performClick()
        composeTestRule.waitForIdle()

        val expectedTip = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(1.33)

        composeTestRule
            .onNodeWithTag("tip_amount")
            .assertTextEquals(expectedTip)
    }
}