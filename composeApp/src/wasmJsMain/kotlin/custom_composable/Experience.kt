package custom_composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
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
fun experience(modifier: Modifier = Modifier) {
    Column (modifier = modifier
        .wrapContentHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        Text("My Experience", style = textStyle.plus(
            TextStyle(color = Color(0xff5EE4C6),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 28.sp
        )
        ))
        Spacer(modifier = Modifier.height(10.dp))
        mobileProgrammingLLC(modifier)
        Spacer(modifier = Modifier.height(30.dp))
        virimExperience(modifier)
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun virimExperience(modifier: Modifier) {
    Column {
        Row(modifier= modifier.fillMaxWidth().
            padding(end = 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Virim Infotech Pvt. Ltd. (Indore)", color = Color.White,
                fontSize = 24.sp)
            if (window.innerWidth > 1000) {
                Text("June 2020 - Apr 2024", color = Color.White, fontSize = 14.sp)
            }
        }
        if (window.innerWidth < 1000) {
            Text("June 2020 - Apr 2024", color = Color.White, fontSize = 14.sp)
        }
        Text("Android Application Developer", color = Color.White, fontSize = 18.sp,
            modifier = modifier.padding(end = 20.dp))
        Spacer(modifier = modifier.height(10.dp))
        resumeItem("Crafted 4 android application from scratch with MVVM architecture and industry best practices.")
        resumeItem("Experienced in providing seamless UI/UX by obeying guidelines of material design libraries.")
        resumeItem("Proficiently used REST APIs and networking libraries to provide prime experience.")
        resumeItem("Implemented offline-first support by utilizing ROOM and WorkManager comprehensive jetpack library.")
        resumeItem("Improved code quality by consolidating the kotlin language features scope functions, higher-order functions.")
        resumeItem("Utilized a content provider to access and manage centralized data in the application.")
        resumeItem("Used the service component to complete important tasks in the background and provided a better user experience.")
        resumeItem("Considered constructor injection, dependency injection tools have been effectively employed to ensure loose coupling of objects.")
        resumeItem("Applications were managed and deployed using CI/CD tools to minimize manual user interaction.")
        resumeItem("Involved in all activities from application development to code review and deployment by keeping Agile methodology in mind.")
    }
}

@Composable
fun mobileProgrammingLLC(modifier: Modifier) {
    Column {
        Row(modifier= modifier.fillMaxWidth().
        padding(end = 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Mobile Programming LLC (Pune)", color = Color.White,
                fontSize = 24.sp)
            if (window.innerWidth > 1000) {
                Text("May 2024 - Present", color = Color.White, fontSize = 14.sp)
            }
        }
        if (window.innerWidth < 1000) {
            Text("May 2024 - Present", color = Color.White, fontSize = 14.sp)
        }
        Text("Android Application Developer", color = Color.White, fontSize = 18.sp,
            modifier = modifier.padding(end = 20.dp))
    }
}

@Composable
fun companyDetails(companyName: String,
                   designation: String,
                   year: String) {
    Row {
        Column {
            Text(companyName, color = Color.White,
                fontSize = 24.sp)
            Text(designation, color = Color.White, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
        }
        Spacer(modifier = Modifier.width(20.dp))
        Text(year, color = Color.White, fontSize = 18.sp)
//        Column {
//            Text("Mobile Programming LLC. (Pune)", color = Color.White,
//                fontSize = 24.sp)
//            Text("Android Application Developer", color = Color.White, fontSize = 18.sp)
//        }
//        Spacer(modifier = Modifier.width(20.dp))
//        Text("May 2024 - Present", color = Color.White, fontSize = 18.sp)
    }
}

@Composable
fun resumeItem(description: String, modifier : Modifier = Modifier) {
    Row {
        Icon(imageVector = Icons.Filled.Check, contentDescription = "CheckedIcon",
            modifier = modifier.padding(end = 5.dp), tint = Color.White)
        Text(description, color = Color.White,  style = TextStyle(fontSize = 14.sp))
    }
}

