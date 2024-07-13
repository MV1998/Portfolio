import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import kotlinx.browser.window

val backgroundMainColor = Color(0xff0D192D)
val textContentColor = Color.White

var textStyle = TextStyle(
    color = textContentColor,
    fontSize = if (window.innerWidth < 1000) 14.sp else 18.sp
)