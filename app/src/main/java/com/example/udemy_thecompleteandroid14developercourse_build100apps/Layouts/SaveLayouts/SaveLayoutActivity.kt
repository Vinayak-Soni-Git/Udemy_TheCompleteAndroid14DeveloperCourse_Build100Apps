package com.example.udemy_thecompleteandroid14developercourse_build100apps.Layouts.SaveLayouts

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream

class SaveLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_layout)

        val view = findViewById<View>(R.id.buttonGreen)
        view.isDrawingCacheEnabled = true
        val bitmap = view.drawingCache
        try {
            val file = File("")
            val outputStream = FileOutputStream(file)
            lifecycleScope.launch {
                bitmap.compress(Bitmap.CompressFormat.PNG, 95, outputStream)
            }
            outputStream.flush()
            outputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}