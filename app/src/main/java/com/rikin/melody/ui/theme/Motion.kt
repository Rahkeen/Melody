package com.rikin.melody.ui.theme

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.scale
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class Playful : Indication {
    @Composable
    override fun rememberUpdatedInstance(interactionSource: InteractionSource): IndicationInstance {
        val isPressed = interactionSource.collectIsPressedAsState()
        val scope = rememberCoroutineScope()
        return remember(interactionSource) { PlayfulInstance(isPressed, scope) }
    }
}

class PlayfulInstance(
    private val isPressed: State<Boolean>,
    private val scope: CoroutineScope
) : IndicationInstance {

    private val scale = Animatable(1.0F)

    override fun ContentDrawScope.drawIndication() {
        if (isPressed.value) {
            scope.launch {
                scale.animateTo(0.85F)
            }

            scale(scaleX = scale.value, scaleY = scale.value) {
                this@drawIndication.drawContent()
            }
        } else {
            scope.launch {
                scale.animateTo(1.0F)
            }
            scale(scaleX = scale.value, scaleY = scale.value) {
                this@drawIndication.drawContent()
            }
        }
    }
}