package custom_composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.RenderIntent
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun mainButton(modifier: Modifier = Modifier, url : String,
               buttonContent : String) {

    val backgroundColor = remember { mutableStateOf(Color.Transparent) }
    val borderStroke = remember { mutableStateOf(BorderStroke(1.dp, color = Color.White)) }
    val contentColor = remember { mutableStateOf(Color.White) }
    val pointerIcon = remember { mutableStateOf(PointerIcon.Default) }

    val buttonClick = remember { mutableStateOf(false) }

    val shadow = remember { mutableStateOf(0.dp) }

    if (buttonClick.value) {
        buttonClick.value = false
        LocalUriHandler.current.openUri(url)
    }

    OutlinedButton(onClick = {
        buttonClick.value = true
    },
        border = borderStroke.value,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor.value,
            contentColor = contentColor.value),
        modifier = modifier.onPointerEvent(eventType = PointerEventType.Enter) {
            backgroundColor.value = Color.Cyan
            borderStroke.value = BorderStroke(1.dp, color = Color.Cyan)
            contentColor.value = Color.Black
            pointerIcon.value = PointerIcon.Hand
            shadow.value = 20.dp
        }.onPointerEvent(eventType = PointerEventType.Exit) {
            backgroundColor.value = Color.Transparent
            borderStroke.value = BorderStroke(1.dp, color = Color.White)
            contentColor.value = Color.White
            pointerIcon.value = PointerIcon.Default
            shadow.value = 0.dp
        }.pointerHoverIcon(icon = pointerIcon.value)
            .shadow(shadow.value, spotColor = Color.Cyan)
    ) {
        Text(buttonContent)
    }
}