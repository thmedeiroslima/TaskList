package com.example.tasklist.ui

import com.example.tasklist.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tasklist.databinding.FragmentTodoBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TodoFragment : Fragment() {

    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        val rootView = _binding?.root
        val button = rootView?.findViewById<Button>(R.id.btnRequest)

        button?.setOnClickListener {
            val serviceSinesp = ServiceSinesp.buildService(ApiService::class.java)
            val call = serviceSinesp.getPost()
            call.enqueue(object : Callback<MutableList<PostModel>> {
                override fun onResponse(
                    call: Call<MutableList<PostModel>>,
                    response: Response<MutableList<PostModel>>
                ) {
                    if (response.isSuccessful) {
                        Log.e("Sucesso", response.body().toString())
                    }
                }

                override fun onFailure(call: Call<MutableList<PostModel>>, t: Throwable) {
                    t.printStackTrace()
                    Log.e("Erro", t.message.toString())
                }
            })
        }
        return rootView!!
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}