package com.example.compose.rally

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.text.toUpperCase
import com.example.compose.rally.ui.components.RallyTopAppBar
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {


    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myTest(){
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(allScreens = allScreens,
                onTabSelected = {},
                currentScreen = RallyScreen.Accounts
            )
        }
        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")

        composeTestRule
            .onNode(
                hasText(RallyScreen.Accounts.name.uppercase()) and
                        hasParent(
                            hasContentDescription(RallyScreen.Accounts.name)
                        ),
                useUnmergedTree = true
            )
            .assertExists()
    }
    @Test
    fun differentTabTest1(){
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(allScreens = allScreens,
                onTabSelected = {},
                currentScreen = RallyScreen.Overview)
        }
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Overview.name)
            .assertExists()
    }
    @Test
    fun differentTabTest2(){
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(allScreens = allScreens,
                onTabSelected = {},
                currentScreen = RallyScreen.Bills)
        }
        composeTestRule
            .onNode(
                hasText(RallyScreen.Bills.name.uppercase()) and
                        hasParent(hasContentDescription(RallyScreen.Bills.name)),
                useUnmergedTree = true
            )
            .assertExists()
    }
}