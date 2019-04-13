package com.example.hellojson

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.hellojson.connect.Connecter.api
import kotlinx.android.synthetic.main.activity_post.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        tvPost.onClick {
            api.post(hashMapOf(
                "title" to titleEditText,
                "body" to bodyEditText
            )).enqueue(object: Callback<Unit>{
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    toast("good")
                    Log.d("post", "성공")
                }

                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    toast("네트워크 연결을 확인해 주세요")
                    Log.d("post", "실패")
                }
            })
            hashMapOf("title" to titleEditText)

            //finish()
        }
    }
}
