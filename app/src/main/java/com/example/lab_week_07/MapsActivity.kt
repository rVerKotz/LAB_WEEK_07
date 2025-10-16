package com.example.lab_week_07

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_week_07.R
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class MapsActivity : AppCompatActivity() {
    private lateinit var map: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Configuration.getInstance().load(applicationContext, androidx.preference.PreferenceManager.getDefaultSharedPreferences(applicationContext))

        setContentView(R.layout.activity_maps)
        map = findViewById(R.id.map)
        map.setMultiTouchControls(true)

        val startPoint = GeoPoint(-6.200000, 106.816666) // Jakarta contoh
        val mapController = map.controller
        mapController.setZoom(12.0)
        mapController.setCenter(startPoint)

        val marker = Marker(map)
        marker.position = startPoint
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker.title = "Lokasi awal"
        map.overlays.add(marker)
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }
}