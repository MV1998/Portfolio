import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import kotlinx.browser.window
import org.jetbrains.compose.ui.tooling.preview.Preview
import screens.HomeScreen
import screens.mobileHomeScreen


@Composable
fun App() {
    val db = InMemoryDataBase

    MaterialTheme {

        //HomeScreen(db = db)
        val width = window.innerWidth

        if (width < 1000) {
            mobileHomeScreen(db = db)
        }else {
            HomeScreen(db = db)
        }
//        instagramPage()
    }
}

@Preview
@Composable
fun preView() {
    App()
}