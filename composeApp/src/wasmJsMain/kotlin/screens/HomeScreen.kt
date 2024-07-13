package screens

import InMemoryDataBase
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import custom_composable.*
import kotlinx.browser.window
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(modifier : Modifier = Modifier,
               db : InMemoryDataBase) {
    //0xff000428
    //0xff004e92
    val scrollState = rememberScrollState()
    val snackBarState = SnackbarHostState()
    val drawerState = DrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = ScaffoldState(drawerState, snackBarState)
    Box(modifier = Modifier.fillMaxSize()
        .background(Brush.linearGradient(colors = listOf(Color(0xff000428), Color(0xff004e92))))
        .padding(horizontal = 70.dp)) {
        Scaffold(
            backgroundColor = Color.Transparent,
            scaffoldState = scaffoldState,
            topBar = {
                AppBar()
            }) {
            Column(modifier.verticalScrollbar(scrollState).verticalScroll(state = scrollState)) {
                Row(modifier = modifier.wrapContentHeight().
                    fillMaxWidth(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center ) {
                    Column(modifier = modifier.fillMaxWidth(.5f)) {
                        Text("Hi, my name is", style = textStyle.plus(TextStyle(color = Color(0xff5EE4C6), fontWeight = FontWeight.Normal)))
                        Spacer(modifier = modifier.height(10.dp))
                        Text(
                            "Mohit Varma", style = textStyle.plus(TextStyle(color = Color(0xff5EE4C6),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 70.sp,
                                fontFamily = FontFamily(Font(Res.font.opensans))
                        )))
                        Spacer(modifier = modifier.height(10.dp))
                        Text("I'm a software engineer specializing in building and designing exceptional android application.", style = textStyle.copy(
                            fontWeight = FontWeight.ExtraLight
                        ))
                        Spacer(modifier = modifier.height(10.dp))
                        Text("An experienced Android Application Developer with 4 years of experience developing and maintaining mobile applications with Kotlin, Java, XMLs and Jetpack Compose. Providing seamless user experience by incorporating industry best practices for mobile application like MVVM architecture and various Jetpack features.", style = textStyle.copy(
                            fontWeight = FontWeight.ExtraLight,
                            color = Color.LightGray
                        ), modifier = modifier.clickable {
                            CoroutineScope(Dispatchers.Main).launch {
                             scaffoldState.snackbarHostState.showSnackbar(message = "Your info description", duration = SnackbarDuration.Long, actionLabel = "Click")
                            }
                        })
                        Spacer(modifier = modifier.height(10.dp))
                        Row {
                            mainButton(url = "https://www.linkedin.com/in/mohitkishorvarma/", buttonContent = "Contact me")
                            Spacer(modifier = modifier.width(10.dp))
                            mainButton(url = "https://drive.google.com/file/d/1pGuttWDPmK7Np89qTROkTRTAgVwJOBRK/view?usp=drive_link", buttonContent = "Download CV")
                        }
                    }
                    scalableImage(modifier = Modifier)
                }
                Spacer(modifier = modifier.height(100.dp))

                // this is the Concept Section I have done.
                conceptCard(modifier, db.conceptSkills)

                Spacer(modifier = modifier.height(50.dp))

                // This is the experience section
                experience()

                Spacer(modifier = modifier.height(50.dp))

                projects(projects = db.projectList)

                Spacer(modifier = modifier.height(50.dp))

                technicalSkill(modifier)

                Spacer(modifier = modifier.height(50.dp))

                education(modifier)

                Spacer(modifier = modifier.height(50.dp))
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AppBar(modifier: Modifier = Modifier) {
    TopAppBar (
        backgroundColor = Color.Transparent,
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 30.dp),
        elevation = 0.dp,
    ) {
        val border = remember { mutableStateOf(BorderStroke(1.dp, color = Color.Transparent)) }
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()) {
            Text("Mohit Varma", color = textContentColor,
                style = TextStyle(
                    fontSize = 24.sp
                )
            )
            Spacer(modifier.width(10.dp))
        }
    }
}

@Composable
fun Modifier.verticalScrollbar(state: ScrollState, scrollbarWidth: Dp = 6.dp, color: Color = Color.LightGray): Modifier{
    val alpha by animateFloatAsState(targetValue = if(state.isScrollInProgress) 1f else 0.1f,
        animationSpec = tween(400, delayMillis = if(state.isScrollInProgress) 0 else 700)
    )

    return this then Modifier.drawWithContent {
        drawContent()

        val viewHeight = state.viewportSize.toFloat()
        val contentHeight = state.maxValue + viewHeight

        val scrollbarHeight = (viewHeight * (viewHeight / contentHeight )).coerceIn(10.dp.toPx() .. viewHeight)
        val variableZone = viewHeight - scrollbarHeight
        val scrollbarYoffset = (state.value.toFloat() / state.maxValue) * variableZone

        drawRoundRect(
            cornerRadius = CornerRadius(scrollbarWidth.toPx() / 2, scrollbarWidth.toPx() / 2),
            color = color,
            topLeft = Offset(this.size.width - scrollbarWidth.toPx(), scrollbarYoffset),
            size = Size(scrollbarWidth.toPx(), scrollbarHeight),
            alpha = alpha
        )
    }
}

