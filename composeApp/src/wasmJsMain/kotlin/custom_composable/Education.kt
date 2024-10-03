package custom_composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.TabRowDefaults.Divider
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

    val educations = listOf(
        Education(
            year = "2016 - 2020",
            degree = "Bachelor of Engineering (CSE)",
            university = "Rajiv Gandhi Proudyogiki Vishwavidyalaya",
            address = "Madhya Pradesh, Bhopal",
            note = "I am becoming a good software engineering with best practice and domain knowledge. There is lots of learning" +
                    " in this field and continuously acquiring knowledge."
        ), Education(
            year = "2015 - 2016",
            degree = "Higher Secondary School",
            university = "Board Of Secondary Education",
            address = "Madhya Pradesh, Bhopal",
            note = "Physics, Chemistry and Mathematics were my favorite subjects. I have secured 88.8% in the Board Examinations."
        ), Education(
            year = "2012 - 2014",
            degree = "High School",
            university = "Board Of Secondary Education",
            address = "Madhya Pradesh, Bhopal",
            note = "High School was my turning point to give attention in the study. Practiced a lot of Math and English questions."
        )
    )

    Column(
        modifier = modifier
            .wrapContentHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            "My Education ", style = textStyle.plus(
                TextStyle(
                    color = Color(0xff5EE4C6),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 28.sp
                )
            )
        )

        buildEducation(educations)
    }
}

@Composable
fun buildEducation(educations: List<Education>, modifier: Modifier = Modifier) {
    if (window.innerWidth > 1000) {
        Row(
            modifier = modifier.fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            repeat(educations.size) {
                EducationSection(
                    education = educations[it],
                    modifier = modifier
                        .weight(.3f)
                        .wrapContentHeight()
                )
            }
        }
    } else {
        Column(modifier = modifier.fillMaxWidth().padding(top = 20.dp)) {
            repeat(educations.size) {
                EducationSection(
                    education = educations[it],
                    modifier = modifier
                        .padding(top = 20.dp)
                        .wrapContentHeight()
                        .wrapContentWidth()
                )
            }
        }
    }
}

@Composable
fun EducationSection(
    education: Education = Education(
        year = "2008 - 2010",
        degree = "Master of Computer Science",
        university = "UNIVERSITY OF NORTH CAROLINA",
        address = "North Carolina, USA",
        note = "Duis aute irure dolor in reprehenderit in vol patate velit esse cillum dolore eu fugiat nulla pari. Excepteur sint occana inna tecat cupidatat non proident."
    ),
    textColor: Color = Color.White,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Text(
            education.year, style = TextStyle(
                color = textColor,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp
            )
        )
        Text(
            education.degree,
            modifier = Modifier.padding(top = 10.dp),
            style = TextStyle(
                color = textColor
            )
        )
        Row(
            modifier = Modifier.padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .width(10.dp)
                    .background(color = textColor, shape = CircleShape)
            )
            Divider(
                thickness = 1.dp, color = textColor,
                modifier = Modifier.padding(start = 5.dp, end = 5.dp)
            )
        }
        Text(
            education.university,
            modifier = Modifier.padding(top = 20.dp),
            style = TextStyle(
                color = textColor,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )
        Text(
            education.address,
            modifier = Modifier.padding(top = 5.dp),
            style = TextStyle(
                color = textColor
            )
        )
        Text(
            education.note,
            modifier = Modifier.padding(top = 15.dp),
            style = TextStyle(
                color = Color.LightGray,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        )
    }
}

data class Education(
    val year: String,
    val degree: String,
    val university: String,
    val address: String,
    val note: String
)