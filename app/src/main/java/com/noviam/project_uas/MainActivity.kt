package com.noviam.project_uas


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.kuliner.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        private  lateinit var objectadapter: objectrecycleradapter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            initRecyclerView()
            tambahDataSet()
        }
        private  fun tambahDataSet(){
            val data = sumberdata.buatSetData()
            objectadapter.submitList(data)
        }

        private fun initRecyclerView() {
            recyler_view.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                val spacingAtas = DekorasiSpasiGambar(padding = 20)
                addItemDecoration(spacingAtas)
                objectadapter = objectrecycleradapter()
                adapter = objectadapter
            }
        }
    }

    }



