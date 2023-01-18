    package com.example.tasklist.ui


    import android.content.Intent
    import android.os.Bundle
    import androidx.appcompat.app.AppCompatActivity
    import com.example.tasklist.R
    import com.example.tasklist.ui.APIs.FipeAPI
    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory
    import java.io.IOException

    class PlacaActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.layout_activity_placa)

            val retrofit = Retrofit.Builder()
                .baseUrl("https://placa-fipe.apibrasil.com.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val fipeAPI = retrofit.create(FipeAPI::class.java)
            val call = fipeAPI.getPlaca("OAE2911")

            try {
                val response = call.execute()
                if (response.isSuccessful) {
                    val placa = response.body()
                    val intent = Intent(this@PlacaActivity, MainActivity::class.java)
                    intent.putExtra("placa", placa)
                    startActivity(intent)
                } else {
                    // exibir mensagem de erro
                }
            } catch (e: IOException) {
                // exibir mensagem de erro
            }
        }
    }





