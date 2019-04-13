package com.example.hellojson

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.hellojson.adapter.PhotoAdapter
import com.example.hellojson.connect.Connecter.api
import com.example.hellojson.model.PhotoModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoActivity : AppCompatActivity() {

    lateinit var mArrayList: ArrayList<PhotoModel>
    lateinit var mRecyclerView: RecyclerView
    lateinit var mAdapter: PhotoAdapter
    lateinit var mLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        mRecyclerView = findViewById(R.id.photo_recyclerview)
        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager= mLayoutManager

        mArrayList = ArrayList()

        setAdapterData()
    }

    fun setAdapterData(): ArrayList<PhotoModel> {
        var photoData = ArrayList<PhotoModel>()
        api.getPhoto().enqueue(object: Callback<ArrayList<PhotoModel>> {
            override fun onResponse(call: Call<ArrayList<PhotoModel>>, response: Response<ArrayList<PhotoModel>>) {
                mArrayList = response!!.body()!!
                mAdapter = PhotoAdapter(mArrayList)
                mRecyclerView.adapter = mAdapter

                mAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<ArrayList<PhotoModel>>, t: Throwable) {
                Toast.makeText(this@PhotoActivity, "피드를 가져올 수 없습니다", Toast.LENGTH_SHORT).show()

            }
        })
        return photoData
    }
}
