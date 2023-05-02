package com.example.cardinfoscreentestapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val isMoving = false

    var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking {
            //findRepository.searchRestaurant(searchType = SearchType.BOUND)
        }

        findViewById<Button>(R.id.btn).setOnClickListener {
            cardMoveTest()
        }

        findViewById<Button>(R.id.btn_show).setOnClickListener {
            lifecycleScope.launch {
                //findRepository.clickMap()
            }
        }

        var tvShow = findViewById<TextView>(R.id.tv_show)
        lifecycleScope.launch {
            /*findRepository.showRestaurantCardAndFilter().collect(FlowCollector{
                tvShow.text = it.toString()
            })*/
        }

    }

    private fun cardMoveTest() {
        lifecycleScope.launch {
            if (job == null) {
                job = lifecycleScope.launch {
                    while (true) {
                        delay(1000)
                        val position = java.util.Random().nextInt(20)
                        findViewById<TextView>(R.id.tv).text = "카드이동:$position"

                    }
                }
                findViewById<TextView>(R.id.tv).text = "카드이동"
                job!!.start()
            } else {
                if (job!!.isActive) {
                    findViewById<TextView>(R.id.tv).text = "카드멈춤"
                    job!!.cancel()
                } else {
                    job = lifecycleScope.launch {
                        while (true) {
                            delay(1000)
                            val position = java.util.Random().nextInt(20)
                            findViewById<TextView>(R.id.tv).text = "카드이동:$position"

                        }
                    }
                    findViewById<TextView>(R.id.tv).text = "카드이동"
                    job!!.start()
                }
            }

        }
    }


}