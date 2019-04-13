package com.example.hellojson

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.hellojson.adapter.FeedAdapter
import com.example.hellojson.connect.Connecter.api
import com.example.hellojson.model.FeedModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedActivity : AppCompatActivity() {

    lateinit var mArrayList: ArrayList<FeedModel>
    lateinit var mRecyclerView: RecyclerView
    lateinit var mAdapter: FeedAdapter
    lateinit var mLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        mRecyclerView = findViewById(R.id.feed_recyclerview)
        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = mLayoutManager

        mArrayList = ArrayList()

        setAdapterData()

    }

    fun setAdapterData(): ArrayList<FeedModel> {
        var feedData = ArrayList<FeedModel>()
        api.getFeed().enqueue(object: Callback<ArrayList<FeedModel>> {
            override fun onResponse(call: Call<ArrayList<FeedModel>>, response: Response<ArrayList<FeedModel>>) {
                mArrayList = response!!.body()!!
                mAdapter = FeedAdapter(mArrayList)
                mRecyclerView.adapter = mAdapter

                mAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<ArrayList<FeedModel>>, t: Throwable) {
                Toast.makeText(this@FeedActivity, "피드를 가져올 수 없습니다", Toast.LENGTH_SHORT).show()
            }

        })
        return feedData
    }
}
