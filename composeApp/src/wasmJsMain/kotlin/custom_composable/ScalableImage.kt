package custom_composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import practice.composeapp.generated.resources.Res
import practice.composeapp.generated.resources.compose_multiplatform

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun scalableImage(modifier: Modifier = Modifier) {
    val scaled = remember { mutableStateOf(.9f) }
    Image(painter = painterResource(Res.drawable.compose_multiplatform), contentDescription = "",
        modifier.fillMaxWidth(1f)
            .onPointerEvent(eventType = PointerEventType.Exit) {
                scaled.value = .9f
            }.onPointerEvent(eventType = PointerEventType.Enter) {
                scaled.value = 1f
            }.scale(scaled.value),
        alignment = Alignment.Center,
        contentScale = ContentScale.Fit)
}