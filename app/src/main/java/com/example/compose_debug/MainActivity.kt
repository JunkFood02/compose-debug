package com.example.compose_debug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_debug.ui.theme.ComposeDebugTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PredictiveBackPreview()
        }
    }
}

@Composable
fun PredictiveBackPreview() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "page1",
        modifier = Modifier.fillMaxSize()
    ) {
        composable("page1") {
            OneButtonPage(
                text = "Navigate to next page",
                color = MaterialTheme.colorScheme.inversePrimary
            ) {
                navController.navigate("page2")
            }
        }
        composable("page2") {
            OneButtonPage(
                text = "Back to previous page",
                color = MaterialTheme.colorScheme.surface
            ) {
                navController.popBackStack("page1", false)
            }
        }
    }
}

@Composable
fun OneButtonPage(
    color: Color,
    text: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .background(color = color)
            .fillMaxSize()
    ) {
        Button(onClick = onClick, modifier = Modifier.align(Alignment.Center)) {
            Text(text = text)
        }
    }
}


