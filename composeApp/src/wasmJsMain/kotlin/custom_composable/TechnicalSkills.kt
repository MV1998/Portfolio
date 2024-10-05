package custom_composable

import InMemoryDataBase
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import textStyle


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun technicalSkill(modifier: Modifier) {
    val headerStyle = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        color = Color.White,
        fontSize = 24.sp
    )

    Column(
        modifier = modifier
            .wrapContentHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            "My Technical Skills", style = textStyle.plus(
                TextStyle(
                    color = Color(0xff5EE4C6),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 28.sp
                )
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column {
            Text("Languages : ", style = headerStyle)
            FlowRow(modifier = modifier.padding(top = 5.dp)) {
                Card(modifier = modifier.padding(5.dp)) {
                    Text(
                        "Kotlin",
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        modifier = modifier.padding(10.dp)
                    )
                }
                Card(modifier = modifier.padding(5.dp)) {
                    Text(
                        "Java",
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        modifier = modifier.padding(10.dp)
                    )
                }
                Card(modifier = modifier.padding(5.dp)) {
                    Text(
                        "Dart",
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        modifier = modifier.padding(10.dp)
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(10.dp))
        Column {
            Text("Development Tools and IDEs : ", style = headerStyle)
            FlowRow(modifier = modifier.padding(top = 5.dp)) {
                Card(modifier = modifier.padding(5.dp)) {
                    Text(
                        "Android Studio",
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        modifier = modifier.padding(10.dp)
                    )
                }
                Card(modifier = modifier.padding(5.dp)) {
                    Text(
                        "Firebase",
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        modifier = modifier.padding(10.dp)
                    )
                }
                Card(modifier = modifier.padding(5.dp)) {
                    Text(
                        "Git",
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        modifier = modifier.padding(10.dp)
                    )
                }
                Card(modifier = modifier.padding(5.dp)) {
                    Text(
                        "Postman",
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        modifier = modifier.padding(10.dp)
                    )
                }
                Card(modifier = modifier.padding(5.dp)) {
                    Text(
                        "CI/CD",
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        modifier = modifier.padding(10.dp)
                    )
                }
                Card(modifier = modifier.padding(5.dp)) {
                    Text(
                        "Figma",
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        modifier = modifier.padding(10.dp)
                    )
                }
                Card(modifier = modifier.padding(5.dp)) {
                    Text(
                        "XCode",
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        modifier = modifier.padding(10.dp)
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(10.dp))

        Column {
            Text("Android Skills : ", style = headerStyle, modifier = modifier.padding(bottom = 10.dp))
            FlowRow(horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier.padding(top = 5.dp)) {
                repeat(InMemoryDataBase.skillList.size) {
                    Card(modifier = modifier.padding(5.dp)) {
                        Text(
                            InMemoryDataBase.skillList[it].skillName,
                            style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                            modifier = modifier.padding(10.dp)
                        )
                    }
                }
            }
        }
    }
}