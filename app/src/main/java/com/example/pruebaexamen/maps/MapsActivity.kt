package com.example.pruebaexamen.maps

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.osmdroid.config.Configuration
import android.view.LayoutInflater
import com.example.pruebaexamen.R
import com.example.pruebaexamen.databinding.ActivityMainBinding
import com.example.pruebaexamen.databinding.ActivityMapsBinding
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.ItemizedIconOverlay
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus
import org.osmdroid.views.overlay.OverlayItem

class MapsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMapsBinding
    private lateinit var map: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Configuration.getInstance().load(applicationContext, this.getPreferences(Context.MODE_PRIVATE))
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val latitud = intent.getDoubleExtra("latitud", 0.0)
        val longitud = intent.getDoubleExtra("longitud", 0.0)

        Log.d("Latitud", latitud.toString())
        Log.d("longitud", longitud.toString())

        map = binding.map
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMultiTouchControls(true)
        val mapController = map.controller
        mapController.setZoom(9.5)
        val items: ArrayList<OverlayItem> = ArrayList()
        items.add(OverlayItem("Albania", "3.038.594", GeoPoint(41.1529058,20.1605717)))
        items.add(OverlayItem("Alemania", "81.305.856", GeoPoint(51.1642292, 10.4541194)))
        items.add(OverlayItem("Austria", "8.219.743", GeoPoint(47.6964719, 13.3457347)))
        val mOverlay: ItemizedOverlayWithFocus<OverlayItem> =
            ItemizedOverlayWithFocus(
                items,
                object : ItemizedIconOverlay.OnItemGestureListener<OverlayItem> {
                    override fun onItemSingleTapUp(index: Int, item: OverlayItem?): Boolean {
                        return true
                    }

                    override fun onItemLongPress(index: Int, item: OverlayItem?): Boolean {
                        return false
                    }


                }, applicationContext
            )
        mOverlay.setFocusItemsOnTap(true)
        map.overlays.add(mOverlay)
        mapController.setCenter(GeoPoint(latitud, longitud))

    }
    public override fun onResume(){
        super.onResume()
        map.onResume()
    }

    public override fun onPause(){
        super.onPause()
        map.onPause()
    }
}
