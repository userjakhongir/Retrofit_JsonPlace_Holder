package com.example.retrofit_jsonplace_holder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_jsonplace_holder.model.Post
import com.example.retrofit_jsonplace_holder.model.UsersItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recyclerviewrespons)
        // Retrofit build
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
             .addConverterFactory(GsonConverterFactory.create())
             .build()
        // Retrofit bilan Api ni bodhg'lash
        val api:API = retrofit.create(API::class.java)
        //Zapros qayerga
        val call: Call<ArrayList<Post>> = api.getAllPosts()
        val call1: Call<ArrayList<UsersItem>> = api.getAllUsers()
        // Zapros go
//        call.enqueue(object :Callback<ArrayList<Post>>{
//            override fun onResponse(
//                call1: Call<ArrayList<Post>>,
//                response: Response<ArrayList<Post>>
//            ) {
//                // Natija
//                if (response.code()==200){
//
//                    Toast.makeText(this@MainActivity,response.code().toString(), Toast.LENGTH_SHORT).show()
//                    val arralist= response.body()
//                    recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
//                    val postAdapter = PostAdapter(this@MainActivity,arralist!!)
//                    recyclerView.adapter=postAdapter
//                }
//            }
//
//            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
//
//            }
//
//        })
        call1.enqueue(object :Callback<ArrayList<UsersItem>>{
            override fun onResponse(
                call: Call<ArrayList<UsersItem>>,
                response: Response<ArrayList<UsersItem>>
            ) {
                if (response.code()==200){
                    val arralist1= response.body()
                    recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
                    val postAdapter = PostAdapter(this@MainActivity, arralist1)
                    recyclerView.adapter=postAdapter
                }
            }

            override fun onFailure(call: Call<ArrayList<UsersItem>>, t: Throwable) {

            }

        })


    }
}