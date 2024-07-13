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
fun education(modifier: Modifier) {
    val headerStyle = TextStyle(fontWeight = FontWeight.Bold,
        color = Color.White
    )
    val subHeading = TextStyle(fontWeight = FontWeight.Normal,
        color = Color(0xff5EE4C6), fontSize = 12.sp
    )
    Column (modifier = modifier
        .wrapContentHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        Text("My Education ", style = textStyle.plus(
            TextStyle(color = Color(0xff5EE4C6),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 28.sp
            )
        ))
        Spacer(modifier = modifier.height(10.dp))
        header("Thakur Shivkumar Singh Memorial Engineering College",
            "Zhiri, Burhanpur (M.P.)",
            modifier,headerStyle
        )
        subHeading("Bachelor Of Engineering in Computer Science",
            "Sep 2016 – July 2020", modifier, subHeading
        )
        Spacer(modifier = modifier.height(10.dp))
        header("Shree Ganesh Higher Secondary School",
            "Burhanpur, Madhya Pradesh",
            modifier,headerStyle
            )
        subHeading("Secondary Higher Education ",
            "Aug 2015 – Aug 2016", modifier, subHeading
        )
    }
}

@Composable
fun header(universityName : String, place: String, modifier: Modifier, headerStyle : TextStyle) {
    if (window.innerWidth > 1000) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth().padding(end = 10.dp)) {
            Text(universityName, style = headerStyle)
            Text(place, style = headerStyle)
        }
    }else {
        Column (modifier = modifier.fillMaxWidth().padding(end = 10.dp)) {
            Text(universityName, style = headerStyle)
            Text(place, style = headerStyle)
        }
    }
}

@Composable
fun subHeading(degreeName : String, period: String, modifier: Modifier, subHeadingStyle : TextStyle) {
    if (window.innerWidth > 1000) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth().padding(end = 10.dp)) {
            Text(degreeName, style = subHeadingStyle)
            Text(period
                , style = subHeadingStyle)
        }
    }else {
        Column (modifier = modifier.fillMaxWidth().padding(end = 10.dp)) {
            Text(degreeName, style = subHeadingStyle)
            Text(period
                , style = subHeadingStyle)
        }
    }
}