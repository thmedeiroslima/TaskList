package com.example.tasklist.ui



import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.tasklist.R
import com.example.tasklist.R.*

class CapturarPlaca : AppCompatActivity() {

    private val CAMERA_REQUEST_CODE = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_capturar_placa)

        //Botão para abrir a câmera
        val btnOpenCamera = findViewById<Button>(id.btn_open_camera)
        btnOpenCamera.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
        }
    }
}