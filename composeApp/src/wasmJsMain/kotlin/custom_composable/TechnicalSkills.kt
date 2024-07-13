package custom_composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.browser.window
import textStyle


@Composable
fun technicalSkill(modifier: Modifier) {
    val headerStyle = TextStyle(fontWeight = FontWeight.ExtraBold,
        color = Color.White
    )
    val skillValueStyle = TextStyle(fontWeight = FontWeight.Normal,
        color = Color(0xff5EE4C6)
    )

    Column (modifier = modifier
        .wrapContentHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        Text("My Technical Skills", style = textStyle.plus(
            TextStyle(color = Color(0xff5EE4C6),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 28.sp
            )
        ))
        Spacer(modifier = Modifier.height(10.dp))
        if (window.innerWidth > 1000) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Languages : ", style = headerStyle)
                Text("Kotlin, Java, Dart", style = skillValueStyle)
            }
        }else{
            Column {
                Text("Languages : ", style = headerStyle)
                Text("Kotlin, Java, Dart", style = skillValueStyle)
            }
        }
        Spacer(modifier = modifier.height(10.dp))
        if (window.innerWidth > 1000) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Development Tools and IDEs : ", style = headerStyle)
                Text("Android Studio, Firebase Services Integration, Git, Postman, CI/CD"
                    , style = skillValueStyle)
            }
        }else {
            Column {
                Text("Development Tools and IDEs : ", style = headerStyle)
                Text("Android Studio, Firebase Services Integration, Git, Postman, CI/CD"
                    , style = skillValueStyle)
            }
        }
        Spacer(modifier = modifier.height(10.dp))

        if (window.innerWidth > 1000) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth()) {
                Text("Android Skills : ", style = headerStyle)
                Text("XML Layouts, ViewModel, LiveData, View Binding, Data Binding, Room DB, WorkManager, Foreground and\n" +
                        "Background Services, MVVM Architecture, Jetpack Compose, Coroutines and Flow, Dependency Injection Dagger Hilt,\n" +
                        "Retrofit or OkHttp, App Components (Activity, Intent and Broadcast Receiver, Content Provider, Service), Google Maps,\n" +
                        "Third-Party Libraries Integration, Admob, RecyclerView, Unit Testing and UI Testing, Performance Optimization, Play Store\n" +
                        "Submission", style = skillValueStyle)
            }
        }else {
            Column (modifier = modifier.fillMaxWidth()) {
                Text("Android Skills : ", style = headerStyle)
                Text("XML Layouts, ViewModel, LiveData, View Binding, Data Binding, Room DB, WorkManager, Foreground and\n" +
                        "Background Services, MVVM Architecture, Jetpack Compose, Coroutines and Flow, Dependency Injection Dagger Hilt,\n" +
                        "Retrofit or OkHttp, App Components (Activity, Intent and Broadcast Receiver, Content Provider, Service), Google Maps,\n" +
                        "Third-Party Libraries Integration, Admob, RecyclerView, Unit Testing and UI Testing, Performance Optimization, Play Store\n" +
                        "Submission", style = skillValueStyle)
            }
        }
    }
}