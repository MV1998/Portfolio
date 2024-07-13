package screens

import InMemoryDataBase
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import custom_composable.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import practice.composeapp.generated.resources.Res
import practice.composeapp.generated.resources.compose_multiplatform
import practice.composeapp.generated.resources.opensans
import textContentColor
import textStyle

@Composable
fun mobileHomeScreen(modifier: Modifier = Modifier,
                     db : InMemoryDataBase) {

    val scrollState = rememberScrollState()
    val snackBarState = SnackbarHostState()
    val drawerState = DrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = ScaffoldState(drawerState, snackBarState)
    Box(modifier = Modifier.fillMaxSize()
        .background(Brush.linearGradient(colors = listOf(Color(0xff000428), Color(0xff004e92))))
        .padding(horizontal = 10.dp)) {
        Scaffold(
            backgroundColor = Color.Transparent,
            scaffoldState = scaffoldState,) {
            Column(modifier.verticalScrollbar(scrollState).verticalScroll(state = scrollState),
                horizontalAlignment = Alignment.CenterHorizontally) {

                scalableImage()

                Text("Hi, my name is", style = textStyle.plus(TextStyle(color = Color(0xff5EE4C6), fontWeight = FontWeight.Normal)))
                Spacer(modifier = modifier.height(10.dp))
                Text(
                    "Mohit Varma", style = textStyle.plus(TextStyle(color = Color(0xff5EE4C6),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 40.sp,
                        fontFamily = FontFamily(Font(Res.font.opensans))
                    )))
                Spacer(modifier = modifier.height(10.dp))
                Text("I'm a software engineer specializing in building and designing exceptional android application.", style = textStyle.copy(
                    fontWeight = FontWeight.ExtraLight,
                    textAlign = TextAlign.Center
                ))
                Spacer(modifier = modifier.height(10.dp))
                Text("An experienced Android Application Developer with 4 years of experience developing and maintaining mobile applications with Kotlin, Java, XMLs and Jetpack Compose. Providing seamless user experience by incorporating industry best practices for mobile application like MVVM architecture and various Jetpack features.", style = textStyle.copy(
                    fontWeight = FontWeight.ExtraLight,
                    color = Color.LightGray,
                    textAlign = TextAlign.Center
                ))
                Spacer(modifier = modifier.height(10.dp))

                Row {
                    mainButton(url = "https://www.linkedin.com/in/mohitkishorvarma/", buttonContent = "Contact me")
                    Spacer(modifier = modifier.width(10.dp))
                    mainButton(url = "https://drive.google.com/file/d/1pGuttWDPmK7Np89qTROkTRTAgVwJOBRK/view?usp=drive_link", buttonContent = "Download CV")
                }

                Spacer(modifier = modifier.height(50.dp))

                conceptCard(modifier, db.conceptSkills)

                experience()

                Spacer(modifier = modifier.height(50.dp))

                projects(projects = db.projectList)

                Spacer(modifier = modifier.height(50.dp))

                technicalSkill(modifier)

                Spacer(modifier = modifier.height(50.dp))

                education(modifier)

                Spacer(modifier = modifier.height(20.dp))
            }
        }
    }
}