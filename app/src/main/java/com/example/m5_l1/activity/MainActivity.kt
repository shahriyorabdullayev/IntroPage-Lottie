package com.example.m5_l1.activity

import CirclePagerIndicatorDecoration
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle



import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l1.R

import com.example.m5_l1.adapter.CustomAdapter
import com.example.m5_l1.model.Fragment


class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var rvMain:RecyclerView
    private lateinit var fragment: List<Fragment>





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()



    }

    @SuppressLint("CutPasteId")
    private fun initViews() {

        context = this
        rvMain = findViewById(R.id.rv_main)
        val layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        rvMain.layoutManager = layoutManager

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvMain)

        fragment = prepareFragment()
        refreshAdapter(fragment)

        rvMain.addItemDecoration(CirclePagerIndicatorDecoration())


//        rvMain.setOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                val manager = recyclerView.layoutManager as LinearLayoutManager?
//                Log.d("indicator", "$newState")
//
//                var activePosition = 0
//                if (manager != null) {
//                    activePosition = manager.findFirstVisibleItemPosition()
//                }
//                if (activePosition != RecyclerView.NO_POSITION) return
//                Log.d("Active Position", "Active Position: $activePosition")
//            }
//
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//            }
//
//        })







    }

    private fun refreshAdapter(fragment: List<Fragment>) {
        val adapter = CustomAdapter(context, fragment)
        rvMain.adapter = adapter
    }

    private fun prepareFragment():List<Fragment> {
        val list = ArrayList<Fragment>()
            list.add(Fragment("contact_lottie1.json", "Say Hello to\n Global Top-Up", "Send mobile top-up to more than 500 networks\ninover 140 countries" ))
            list.add(Fragment("safe.json", "Safe, Trusted&\nFully Secure", "Encrypted transactions mean your payments &\nPrivacy and protected" ))
            list.add(Fragment("puzzle.json", "Easy to Use", "Pick a number, choose an amount, send your\nTop-up.Simple" ))

        return list
    }




}