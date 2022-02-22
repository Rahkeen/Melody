import android.graphics.Path
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.rikin.melody.ui.theme.ButtonBackgroundBlue
import com.rikin.melody.ui.theme.ButtonTextBlue

@Preview
@Composable
fun Playground() {
  var selected by remember { mutableStateOf(false) }
  val transition = updateTransition(targetState = selected, label = "")
  val progress by transition.animateFloat(transitionSpec = { tween(500) }, label = "") { state ->
    if (state) 0F else 1F
  }


  Box(
    modifier = Modifier
      .size(100.dp)
      .background(ButtonTextBlue),
    contentAlignment = Alignment.Center
  ) {
    Text("Hello", color = Color.White)
  }

  Box(
    modifier = Modifier
      .size(100.dp)
      .clip(ClipShape(progress = progress))
      .clickable { selected = !selected }
  ) {
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(ButtonBackgroundBlue),
      contentAlignment = Alignment.Center
    ) {
      Text("Hello")
    }
  }


}

class ClipShape(private val progress: Float = 0F) : Shape {

  override fun createOutline(
    size: Size,
    layoutDirection: LayoutDirection,
    density: Density
  ): Outline {
    val path: Path = Path().apply {
      addRect(
        0F,
        0F,
        size.width,
        size.height * progress,
        Path.Direction.CW
      )
    }

    return Outline.Generic(path.asComposePath())
  }
}
