package com.coba.submision1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerList()
    }

    private val listUser: ArrayList<User>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataLocation = resources.getStringArray(R.array.data_location)
            val dataAvatar = resources.obtainTypedArray(R.array.data_avatar)
            val dataUsername = resources.getStringArray(R.array.data_username)
            val dataRepository = resources.obtainTypedArray(R.array.data_repository)
            val dataFollowers = resources.obtainTypedArray(R.array.data_followers)
            val dataFollowing = resources.obtainTypedArray(R.array.data_following)
            val dataCompany = resources.getStringArray(R.array.data_company)
            val listHero = ArrayList<User>()

            for (i in dataName.indices) {
                val user = User(
                    dataName[i],
                    dataUsername[i],
                    dataAvatar.getResourceId(i, -1),
                    dataLocation[i],
                    dataCompany[i],
                    dataRepository.getIndex(i),
                    dataFollowers.getResourceId(i, -1),
                    dataFollowing.getResourceId(i, -1)

                   )
                listHero.add(user)
            }
            return listHero
        }
    private fun showRecyclerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListUserAdapter(list)
        rvUsers.adapter = listHeroAdapter
    }
}