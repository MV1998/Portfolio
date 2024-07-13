package screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import practice.composeapp.generated.resources.Res
import practice.composeapp.generated.resources.compose_multiplatform

val headerNavSpace = 25.dp

@Composable
fun instagramPage() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.White,
        topBar = {
            header()
        }
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            firstSection()
            greenLine()
            serviceSection()
            aboutMeSection()
            experienceSection()
        }
    }
}

@Composable
fun header() {
    TopAppBar (
        backgroundColor = Color.White,
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val id = remember { mutableStateOf(0) }
            Row {
                Image(painter = painterResource(Res.drawable.compose_multiplatform),
                    contentDescription = "Image", modifier = Modifier.height(35.dp)
                        .width(35.dp))
                Text("Mohit Varma", fontSize = 30.sp)
            }

            Row{
                customNavButton("Home", 0, id.value) { it ->
                    id.value = it
                }
                Spacer(modifier = Modifier.width(headerNavSpace))
                customNavButton("Services",1, id.value) {
                    id.value = it
                }
                Spacer(modifier = Modifier.width(headerNavSpace))
                customNavButton("About", 2, id.value) {
                    id.value = it
                }
                Spacer(modifier = Modifier.width(headerNavSpace))
                customNavButton("Projects",3, id.value) {
                    id.value = it
                }
                Spacer(modifier = Modifier.width(headerNavSpace))
                customNavButton("Blogs",4, id.value) {
                    id.value = it
                }
                Spacer(modifier = Modifier.width(headerNavSpace))
                customNavButton("Testimonials", 5, id.value) {
                    id.value = it
                }
            }

            Button(onClick = {

            }, shape = RoundedCornerShape(30.dp),
                contentPadding = PaddingValues(20.dp)
            ) {
                Text("Contact Me")
            }
        }
    }
}

@Composable
fun customNavButton(name : String, id : Int, selected: Int, onClick: (Int) -> Unit) {
    Column(modifier = Modifier.clickable { onClick.invoke(id) }){
        Text(name, color = Color.Black)
        if (id == selected) {
            Divider(thickness = 1.dp, color = Color.Black, modifier = Modifier.width(40.dp))
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun firstSection() {
    Box(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight(.8f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(alignment = Alignment.TopCenter)
                .padding(top = 100.dp)
        ) {
            Text("-- Hello")
            Spacer(modifier = Modifier.height(20.dp))
            Text("I'm Mohit,", fontSize = 70.sp)
            Text("An Android Engineer", fontSize = 70.sp)
        }
        Image(painter = painterResource(Res.drawable.compose_multiplatform),
            contentScale = ContentScale.Fit,
            contentDescription = "",
            modifier = Modifier.align(alignment = Alignment.BottomCenter)
                .fillMaxWidth(.8f)
                .padding(top = 200.dp))

        Column(modifier = Modifier.align(alignment = Alignment.Center)
            .padding(end = 1000.dp, top = 200.dp)) {
            Text("450+", fontWeight = FontWeight.Bold, color = Color.Black
            , fontSize = 24.sp)
            Text("Happy Clients")
        }
    }
}

@Composable
fun greenLine() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color.Green)
    ) {
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(imageVector = Icons.Default.Star, contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))
            Text("Firebase")
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(imageVector = Icons.Default.Star, contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))
            Text("Git")
        }
        Row (
            modifier = Modifier.padding(10.dp)
        ){
            Icon(imageVector = Icons.Default.Star, contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))
            Text("UI/UX")
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(imageVector = Icons.Default.Star, contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))
            Text("Best Practices")
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(imageVector = Icons.Default.Star, contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))
            Text("Clean Architecture")
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(imageVector = Icons.Default.Star, contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))
            Text("MVVM")
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(imageVector = Icons.Default.Star, contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))
            Text("Kotlin")
        }
    }
}

@Composable
fun serviceSection() {
    Box(
        modifier = Modifier.fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color(0xff5C5CAB))
            .padding(30.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(.9f)
            ) {
                Column {
                    Text("- Services", color = Color.White)
                    Text("My Service"
                        , fontWeight = FontWeight.Bold, color = Color.White
                        , fontSize = 24.sp)
                }

                Box(
                    modifier = Modifier
                        .width(310.dp)
                        .clip(shape = RoundedCornerShape(30.dp))
                        .background(color = Color.White)
                        .padding(3.dp)
                ) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, tint = Color.White,contentDescription = "",
                        modifier = Modifier.clip(shape = CircleShape).
                        background(color = Color(0xff5C5CAB))
                            .align(alignment = Alignment.CenterStart).padding(20.dp))
                    Text("View All Services",
                        color = Color.Black,modifier = Modifier.
                    clip(shape = RoundedCornerShape(30.dp))
                        .background(color = Color.Green).
                        align(Alignment.CenterEnd).padding(horizontal = 50.dp,
                            vertical = 20.dp))
                }

            }

            Spacer(modifier = Modifier.height(40.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                serviceCard("UI/UX Design")
                serviceCard("App Design")
                serviceCard("Web Design")
            }

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun serviceCard(serviceName: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(170.dp))
            .background(color = Color.White)
            .padding(70.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Icon(imageVector = Icons.Default.Home,
            contentDescription = "",
            modifier = Modifier.
            background(color = Color.LightGray).padding(30.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(serviceName,
            fontSize = 30.sp,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.height(20.dp))
        Text("Lorem ipsum dolor sit here \ndfas;dfjasdfsadjf;asdjfsd"
            , fontSize = 20.sp)
        Spacer(modifier = Modifier.height(70.dp))
        Text("Learn More ->", fontSize = 25.sp)
    }
}

@Composable
fun aboutMeSection() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
            .wrapContentHeight().
            background(color = Color.White).padding(100.dp)
    ) {
        Box(
            modifier = Modifier.wrapContentHeight()
                .width(500.dp)
                .background(color = Color.Blue)
        ) {
            Text("Mohit Varma",
                color = Color.White,
                fontSize = 50.sp,

                modifier = Modifier
                    .rotate(-90f)
                    .align(alignment = Alignment.TopStart)
                    .padding(bottom = 250.dp))
            Text("4+", modifier = Modifier.align(alignment = Alignment.CenterEnd),
                fontSize = 300.sp,
                color = Color.White,)
            Text("Years of Experience",
                fontSize = 30.sp,
                color = Color.White,modifier = Modifier.align(alignment = Alignment.BottomEnd))
        }

        Column(
            modifier = Modifier.padding(start = 50.dp)
        ) {
            Text("-- About Me",
                fontSize = 30.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text("Who is Mohit Varma?",
                fontSize = 60.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text("I am an Android Engineer.",
                fontSize = 15.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Column {
                    Text("600+", fontSize = 30.sp,
                        fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text("Project Completed",
                        fontSize = 20.sp)
                }
                Column {
                    Text("50+", fontSize = 30.sp,
                        fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text("Industry Covered",
                            fontSize = 20.sp)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Column {
                    Text("600+", fontSize = 30.sp,
                        fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text("Project Completed",
                        fontSize = 20.sp)
                }

                Column {
                    Text("50+", fontSize = 30.sp,
                        fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text("Industry Covered",
                        fontSize = 20.sp)
                }
            }
        }
    }
}

@Composable
fun experienceSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().
        padding(20.dp)
    ) {
        Text("- Education & Work",
            fontSize = 30.sp)
        Text("My Education & Work Experience",
            fontSize = 50.sp)

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.
                clip(shape = RoundedCornerShape(5.dp)).
            background(color = Color.LightGray).padding(50.dp)) {
                Row{
                    Icon(imageVector = Icons.Default.Home, contentDescription = "",
                        modifier = Modifier.height(48.dp)
                            .width(48.dp))
                    Text("Education", fontSize = 40.sp)
                }

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("Higher Secondary School 12th", fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text("Master in Visual Arts")
                    }
                    Spacer(modifier = Modifier.width(80.dp))
                    Text("2020 - 2020", modifier = Modifier.
                    clip(shape = RoundedCornerShape(5.dp))
                        .background(color = Color.White).padding(5.dp))
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("High School 10th", fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text("Master in Visual Arts")
                    }
                    Spacer(modifier = Modifier.width(80.dp))
                    Text("2020 - 2020", modifier = Modifier.
                    clip(shape = RoundedCornerShape(5.dp))
                        .background(color = Color.White).padding(5.dp))
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("Other school completed", fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text("Master in Visual Arts Here")
                    }
                    Spacer(modifier = Modifier.width(80.dp))
                    Text("2020 - 2020", modifier = Modifier.
                    clip(shape = RoundedCornerShape(5.dp))
                        .background(color = Color.White).padding(5.dp))
                }
            }
            Spacer(modifier = Modifier.width(50.dp))
            Column(modifier = Modifier.
            clip(shape = RoundedCornerShape(5.dp)).
            background(color = Color.LightGray).padding(50.dp)) {
                Row{
                    Icon(imageVector = Icons.Default.Home, contentDescription = "",
                        modifier = Modifier.height(48.dp)
                            .width(48.dp))
                    Text("Education", fontSize = 40.sp)
                }

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("Higher Secondary School 12th", fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text("Master in Visual Arts")
                    }
                    Spacer(modifier = Modifier.width(80.dp))
                    Text("2020 - 2020", modifier = Modifier.
                    clip(shape = RoundedCornerShape(5.dp))
                        .background(color = Color.White).padding(5.dp))
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("High School 10th", fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text("Master in Visual Arts")
                    }
                    Spacer(modifier = Modifier.width(80.dp))
                    Text("2020 - 2020", modifier = Modifier.
                    clip(shape = RoundedCornerShape(5.dp))
                        .background(color = Color.White).padding(5.dp))
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("Other school completed", fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text("Master in Visual Arts Here")
                    }
                    Spacer(modifier = Modifier.width(80.dp))
                    Text("2020 - 2020", modifier = Modifier.
                    clip(shape = RoundedCornerShape(5.dp))
                        .background(color = Color.White).padding(5.dp))
                }
            }
        }
    }
}