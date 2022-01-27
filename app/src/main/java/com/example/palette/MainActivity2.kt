package com.example.palette

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toolbar
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val toolMensaje = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val imagLogo = findViewById<ImageView>(R.id.imageView)

        val bundle = intent.extras
        val imagenSeleccionada = bundle!!.getInt("LOGO")

        toolMensaje.title = "PALETTE"

        imagLogo.setImageResource(bundle!!.getInt("LOGO"))

        val bitmap: Bitmap = BitmapFactory.decodeResource(resources, imagenSeleccionada)

        Palette.from(bitmap).generate { palette ->

            val vibrant: Palette.Swatch? = palette?.vibrantSwatch
            val darkvibrant: Palette.Swatch? = palette?.darkVibrantSwatch
            val lightvibrant: Palette.Swatch? = palette?.lightVibrantSwatch
            if (lightvibrant != null) {
                constraintLayout1.setBackgroundColor(lightvibrant.rgb)
                constraintLayout1.text = "LightVibrant"
            }
            val muted: Palette.Swatch? = palette?.mutedSwatch
            if (muted != null) {
                constraintLayout2.setBackgroundColor(muted.rgb)
                constraintLayout2.text = "Muted"
            }
            val darkmuted: Palette.Swatch? = palette?.darkMutedSwatch
            if (darkmuted != null) {
                constraintLayout3.setBackgroundColor(darkmuted.rgb)
                constraintLayout3.text = "DarkMuted"
            }
            val lightmuted: Palette.Swatch? = palette?.lightMutedSwatch
            if (lightmuted != null) {
                constraintLayout4.setBackgroundColor(lightmuted.rgb)
                constraintLayout4.text = "LightMuted"
            }

            if (vibrant != null) {
                toolbar.setBackgroundColor(vibrant.rgb)
                toolbar.setTitleTextColor(vibrant.titleTextColor)
            }
        }
    }
}