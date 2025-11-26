package com.example.polyline

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.polyline.ui.theme.PolylineTheme
import com.google.android.gms.maps.model.*
import com.google.maps.android.compose.*

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PolylineTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.Transparent
                    ) {
                    MapScreen(
                        onMessage = { msg ->
                            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MapScreen(onMessage: (String) -> Unit) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            LatLng(37.4219999, -122.0840575), 15f
        )
    }

    // Sample trail
    val trailPoints = listOf(
        LatLng(37.4219, -122.0840),
        LatLng(37.4225, -122.0850),
        LatLng(37.4230, -122.0860)
    )

    // Sample park polygon
    val parkPoints = listOf(
        LatLng(37.4215, -122.0835),
        LatLng(37.4225, -122.0835),
        LatLng(37.4225, -122.0825),
        LatLng(37.4215, -122.0825)
    )

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        onMapClick = { }
    ) {
        // Polyline (trail)
        Polyline(
            points = trailPoints,
            color = Color(0xFFFF0000),  // red
            width = 10f,
            clickable = true,
            onClick = {
                onMessage("Trail clicked!")
            }
        )

        // Polygon (park)
        Polygon(
            points = parkPoints,
            strokeColor = Color(0xFF0000FF), // blue outline
            strokeWidth = 5f,
            fillColor = Color(0x440000FF),   // semi-transparent
            clickable = true,
            onClick = {
                onMessage("Park clicked!")
            }
        )
    }
}
