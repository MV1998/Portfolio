package custom_composable

import ConceptSkill
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import kotlinx.browser.window
import kotlinx.coroutines.flow.Flow
import textStyle


@Composable
@OptIn(ExperimentalLayoutApi::class, ExperimentalComposeUiApi::class)
fun conceptCard(modifier: Modifier, concepts : List<ConceptSkill>) {
    val toolTip = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier.wrapContentHeight().fillMaxWidth(1f),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Concepts that I know in Android and Kotlin ", style = textStyle.plus(
                    TextStyle(
                        color = Color(0xff5EE4C6),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp
                    )
                )
            )
            Icon(imageVector = Icons.Filled.Info, contentDescription = "Info",
                modifier.onPointerEvent(eventType = PointerEventType.Enter) {
                    toolTip.value = true
                }.onPointerEvent(eventType = PointerEventType.Exit) {
                    toolTip.value = false
                }, tint = Color.White)
            if (toolTip.value) {
                Text("Links are clickable.",
                    color = Color.White, modifier = modifier.padding(start = 5.dp),
                    fontSize = 14.sp)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        FlowRow {
            repeat(concepts.size) { index ->
                mainButton(
                    modifier = Modifier.padding(5.dp),
                    url = concepts[index].link,
                    buttonContent = concepts[index].skillName
                )
            }
        }
//        FlowRow {
//
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/1hqxzEJXMN5UVaaHzEZR9f7UktHy0zr6AsnKCvalSGyA/edit?usp=sharing",
//                buttonContent = "Kotlin QnA"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/17W8-YGcFjZaEMGN1DosF9V_VaYjsIZpyD--80lgu7rs/edit?usp=sharing",
//                buttonContent = "OOPs"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/19nALFdmWFIUxOrPH-9DqTa1Ahkcm97JiQy8s7DD078E/edit?usp=sharing",
//                buttonContent = "Collection Framework"
//            )
//            mainButton(modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/1Dh_MGU6QH7vc8NsCevs0sHLJm6MprDbL__9QtyPRwmY/edit?usp=sharing",
//                buttonContent = "Flow APIs")
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/1ahxkvfIfAzFMKOvMU6AotYv0aPSGx0gu_AifFP92ou8/edit?usp=sharing",
//                buttonContent = "Recycler View"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "http://www.linkedin.com",
//                buttonContent = "Jetpack Navigation"
//            )
//            mainButton(modifier = Modifier.padding(5.dp), url = "http://www.linkedin.com", buttonContent = "Room DB")
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "http://www.linkedin.com",
//                buttonContent = "View and Data Binding"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "http://www.linkedin.com",
//                buttonContent = "Security And Privacy"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "http://www.linkedin.com",
//                buttonContent = "Exception Handling"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "http://www.linkedin.com",
//                buttonContent = "Design Pattern"
//            )
//            mainButton(modifier = Modifier.padding(5.dp), url = "http://www.linkedin.com", buttonContent = "HTTP Lib.")
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/1WSRNOnkPIBL_cdMJ85Nyd6cMvmAdjqeyRJzVvhhE9sg/edit?usp=drive_link",
//                buttonContent = "Coroutine"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/1Srv3dGO6HaSHeb1PNSNPdsQSekIBxYSZN5MARB71lpQ/edit?usp=sharing",
//                buttonContent = "Jetpack Compose"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/1Srv3dGO6HaSHeb1PNSNPdsQSekIBxYSZN5MARB71lpQ/edit?usp=sharing",
//                buttonContent = "Side Effect"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/1Srv3dGO6HaSHeb1PNSNPdsQSekIBxYSZN5MARB71lpQ/edit?usp=sharing",
//                buttonContent = "Firebase components"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/1Srv3dGO6HaSHeb1PNSNPdsQSekIBxYSZN5MARB71lpQ/edit?usp=sharing",
//                buttonContent = "Android Architecture"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/1Srv3dGO6HaSHeb1PNSNPdsQSekIBxYSZN5MARB71lpQ/edit?usp=sharing",
//                buttonContent = "Android System Internal"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/1Srv3dGO6HaSHeb1PNSNPdsQSekIBxYSZN5MARB71lpQ/edit?usp=sharing",
//                buttonContent = "Android Unit Testing"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/1Srv3dGO6HaSHeb1PNSNPdsQSekIBxYSZN5MARB71lpQ/edit?usp=sharing",
//                buttonContent = "Android Tools And Technologies"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/1Srv3dGO6HaSHeb1PNSNPdsQSekIBxYSZN5MARB71lpQ/edit?usp=sharing",
//                buttonContent = "Application Components"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/1Srv3dGO6HaSHeb1PNSNPdsQSekIBxYSZN5MARB71lpQ/edit?usp=sharing",
//                buttonContent = "Best Practices"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/1RC-EKBhzctDVPxnI32-b3TlwnEhFYzgrI0luGwEXOS0/edit?usp=sharing",
//                buttonContent = "DI (Dependency Injection)"
//            )
//            mainButton(
//                modifier = Modifier.padding(5.dp),
//                url = "https://docs.google.com/document/d/1tSgFVFSNY1EzVpvMVZKK9Zc9B9DUGhjyBzfiFhuv_5c/edit?usp=sharing",
//                buttonContent = "Git (Version Control)"
//            )
//
//        }
    }
}
