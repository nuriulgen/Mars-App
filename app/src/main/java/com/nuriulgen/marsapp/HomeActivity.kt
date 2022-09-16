package com.nuriulgen.marsapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.nuriulgen.marsapp.data.repository.MarsApiImpl
import com.nuriulgen.marsapp.databinding.ActivityHomeBinding
import com.nuriulgen.marsapp.presentation.home.model.RealeStateModel
import kotlinx.android.synthetic.main.recycler_row.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var recyclerAdapter: HomeRecyclerAdapter

    private var postlist = ArrayList<RealeStateModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_home)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        val myLayoutManager = GridLayoutManager(this,2)
        binding.recyclerView2.layoutManager = myLayoutManager

        recyclerAdapter = HomeRecyclerAdapter(postlist)
        binding.recyclerView2.adapter = recyclerAdapter

        getData()
    }

    private fun getData(){
        MarsApiImpl.retrofitService.getProperties().enqueue(object : Callback<List<RealeStateModel>> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<List<RealeStateModel>>, response: Response<List<RealeStateModel>>) {
                if(response.isSuccessful && response.body() !=null){
                    postlist.addAll(response.body()!!)
                    println(postlist)
                    recyclerAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<RealeStateModel>>, t: Throwable) {
                Toast.makeText(this@HomeActivity,t.message,Toast.LENGTH_LONG).show()

            }
        })
    }

}