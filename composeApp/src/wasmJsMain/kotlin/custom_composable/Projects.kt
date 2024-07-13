package custom_composable

import Project
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
import kotlinx.browser.window
import textStyle


@OptIn(ExperimentalLayoutApi::class, ExperimentalComposeUiApi::class)
@Composable
fun projects(modifier: Modifier = Modifier,
             projects : List<Project>) {
    val headerStyle = TextStyle(fontWeight = FontWeight.Bold,
        color = Color.White
    )
    val subHeading = TextStyle(fontWeight = FontWeight.Normal,
        color = Color(0xff5EE4C6), fontSize = 12.sp
    )

    var hoveredIndex by remember {
        mutableStateOf(-1)
    }

    Column (modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        Text("My Projects", style = textStyle.plus(
            TextStyle(color = Color(0xff5EE4C6),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 28.sp,
            )
        ))
        FlowRow (modifier = Modifier.align(Alignment.CenterHorizontally)) {
            repeat(projects.size) { index ->
             Box(modifier = Modifier.padding(4.dp)
                 .wrapContentHeight()
                 .width((window.innerWidth/if (window.innerWidth < 1000) 1 else 3).dp)
                 .onPointerEvent(eventType = PointerEventType.Enter) {
                     hoveredIndex = index
                 }.onPointerEvent(eventType = PointerEventType.Exit) {
                     hoveredIndex = -1
                 }.
                border(if (index == hoveredIndex) 2.dp else 1.dp, color = Color.White, shape = RoundedCornerShape(10.dp)).padding(10.dp)) {
                Column {
                    Text(projects[index].projectName, color = Color.Cyan, fontWeight = FontWeight.Bold,
                        fontSize = 18.sp)
                    Text("About : ${projects[index].aboutProject}", color = Color.White, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    repeat(projects[index].thingsImplementedInProject.size) { thingsIndex->
                        Text(projects[index].thingsImplementedInProject[thingsIndex], color = Color.White,
                            fontSize = 12.sp)
                    }
                    Spacer(modifier = Modifier.height(3.dp))
                    Text("Tech Stack : ${projects[index].projectTechStack.joinToString(", ")}",
                        color = Color.Cyan, fontSize = 14.sp)
//                    if (index == hoverdIndex) {
//                        repeat(projects[index].thingsImplementedInProject.size) { thingsIndex->
//                            Text(projects[index].thingsImplementedInProject[thingsIndex], color = Color.White,
//                                fontSize = 14.sp)
//                        }
//                    }
                }
            }
            }
        }
//        FlowRow() {
//            Box(modifier = Modifier.padding(4.dp).wrapContentHeight()
//                .wrapContentWidth().
//                border(1.dp, color = Color.White, shape = RoundedCornerShape(10.dp)).padding(10.dp)) {
//                Column {
//                    Text("MJetpack Compose", color = Color.White, fontWeight = FontWeight.Bold)
//                    Text("- Studied and Used all material 3 components ", color = Color.White,
//                        fontSize = 14.sp)
//                    Text("- Jetpack Compose Navigation", color = Color.White, fontSize = 14.sp)
//                    Text("- Light And Dark Theme", color = Color.White, fontSize = 14.sp)
//                }
//            }
//            Box(modifier = Modifier.padding(4.dp).wrapContentHeight()
//                .wrapContentWidth()
//                .onPointerEvent(eventType = PointerEventType.Enter) {
//                    visible = true
//                }.onPointerEvent(eventType = PointerEventType.Exit) {
//                    visible = true
//                }.
//                border(1.dp, color = Color.White, shape = RoundedCornerShape(10.dp)).padding(10.dp)) {
//                Column {
//                    Text("Repnet2.0", color = Color.White, fontWeight = FontWeight.Bold)
//                    if (visible) {
//                        Text("- Developed an application from scratch using MVVM architecture and Jetpack component.", color = Color.White,
//                            fontSize = 14.sp)
//                        Text("- Used Google Map SDK, Networking Retrofit library and WorkManager to execute task in the background.", color = Color.White, fontSize = 14.sp)
//                        Text("- Implemented offline-first approach using Room database when device is in offline state.", color = Color.White, fontSize = 14.sp)
//                    }
//                }
//            }
//            Box(modifier = Modifier.padding(4.dp).wrapContentHeight()
//                .wrapContentWidth().
//                border(1.dp, color = Color.White, shape = RoundedCornerShape(10.dp)).padding(10.dp)) {
//                Column {
//                    Text("Kratinn", color = Color.White, fontWeight = FontWeight.Bold)
//                    Text("- Added MQTT library to make communications with IoT devices like Smart Switch and WOL.", color = Color.White,
//                        fontSize = 14.sp)
//                    Text("- Used WiFi Manager system services to listing the available WiFi devices, WorkManager to scheduling Task.", color = Color.White,
//                        fontSize = 14.sp)
//                    Text("- Enhanced efficiency by using Coroutine and Flows APIs. Integrated Firebase Push Service.", color = Color.White,
//                        fontSize = 14.sp)
//                }
//            }
//            Box(modifier = Modifier.padding(4.dp).wrapContentHeight()
//                .wrapContentWidth().
//                border(1.dp, color = Color.White, shape = RoundedCornerShape(10.dp)).padding(10.dp)) {
//                Column {
//                    Text("Vscan", color = Color.White, fontWeight = FontWeight.Bold)
//                    Text("- Used document scanner library and merged with custom filters.", color = Color.White, fontSize = 14.sp)
//                    Text("- Performed CRUD operation on the file system and filtered images can be saved in the gallery with scoped storage.", color = Color.White, fontSize = 14.sp)
//                    Text("- Generated PDF with watermarks and shared with sharing intent feature.", color = Color.White, fontSize = 14.sp)
//                }
//            }
//            Box(modifier = Modifier.padding(4.dp).wrapContentHeight()
//                .wrapContentWidth().
//                border(1.dp, color = Color.White, shape = RoundedCornerShape(10.dp)).padding(10.dp)) {
//                Column {
//                    Text("NetUtility", color = Color.White, fontWeight = FontWeight.Bold)
//                    Text("Room, Flow, Data Binding", color = Color.White)
//                }
//            }
//            Box(modifier = Modifier.padding(4.dp).wrapContentHeight()
//                .wrapContentWidth().
//                border(1.dp, color = Color.White, shape = RoundedCornerShape(10.dp)).padding(10.dp)) {
//                Column {
//                    Text("Notes", color = Color.White, fontWeight = FontWeight.Bold)
//                    Text("Room, Flow, Data Binding", color = Color.White)
//                }
//            }
//            Box(modifier = Modifier.padding(4.dp).wrapContentHeight()
//                .wrapContentWidth().
//                border(1.dp, color = Color.White, shape = RoundedCornerShape(10.dp)).padding(10.dp)) {
//                Column {
//                    Text("Apni Mandi (Grocery App)", color = Color.White, fontWeight = FontWeight.Bold)
//                    Text("Room, Flow, Data Binding", color = Color.White)
//                }
//            }
//            Box(modifier = Modifier.padding(4.dp).wrapContentHeight()
//                .wrapContentWidth().
//                border(1.dp, color = Color.White, shape = RoundedCornerShape(10.dp)).padding(10.dp)) {
//                Column {
//                    Text("Color Palette", color = Color.White, fontWeight = FontWeight.Bold)
//                    Text("Room, Flow, Data Binding", color = Color.White)
//                }
//            }
//            Box(modifier = Modifier.padding(4.dp).wrapContentHeight()
//                .wrapContentWidth().
//                border(1.dp, color = Color.White, shape = RoundedCornerShape(10.dp)).padding(10.dp)) {
//                Column {
//                    Text("Coronis", color = Color.White, fontWeight = FontWeight.Bold)
//                    Text("Room, Flow, Data Binding", color = Color.White)
//                }
//            }
//        }
    }
}