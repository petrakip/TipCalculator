package com.example.tipcalculator

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

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

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        composeTestRule.onNodeWithText(expectedTip)
            .assertExists("No node with this text was found.")
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

        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("40")

        composeTestRule.onNodeWithText("+")
            .performClick()

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        composeTestRule.onNodeWithText(expectedTip)
            .assertExists("No node with this text was found.")
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

        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("40")

        composeTestRule.onNodeWithText("+")
            .performClick()

        val expectedBill = NumberFormat.getCurrencyInstance().format(5)

        composeTestRule.onNodeWithText(expectedBill)
            .assertExists("No node with this text was found.")
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

        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("40")

        composeTestRule.onNodeWithText("+")
            .performClick()

        val expectedTotal = NumberFormat.getCurrencyInstance().format(7)

        composeTestRule.onNodeWithText(expectedTotal)
            .assertExists("No node with this text was found.")
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

        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("40")

        composeTestRule.onNodeWithText("+")
            .performClick()
        composeTestRule.onNodeWithText("+")
            .performClick()

        composeTestRule.onNodeWithTag("round_switch")
            .performClick()

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        composeTestRule.onNodeWithText(expectedTip)
            .assertExists("No node with this text was found.")
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

        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("40")

        composeTestRule.onNodeWithText("+")
            .performClick()
        composeTestRule.onNodeWithText("+")
            .performClick()

        val expectedTip = NumberFormat.getCurrencyInstance().format(1.33)

        composeTestRule.onNodeWithText(expectedTip)
            .assertExists("No node with this text was found.")
    }
}