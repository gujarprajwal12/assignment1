package com.example.assignmet

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmet.Adapter.EventAdapter
import com.example.assignmet.Data.Event

class MainActivity : AppCompatActivity() {

    private val apiRepository = ApiRepository()
    private lateinit var recyclerView: RecyclerView
    private lateinit var eventAdapter: EventAdapter
    private lateinit var eventList: List<Event>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchEventData()
    }

//
//    private fun fetchEventData() {
//        lifecycleScope.launch {
//            try {
//                val response = apiRepository.getEventData("0056t000004og7kAAA", "Eventdex")
//                withContext(Dispatchers.Main) {
//                    if (response.isSuccessful) {
//                        val eventData = response.body()!!.Events[0]
//                        Log.d(TAG, "fetchEventData:  $eventData")
//                        tvCompany.text = eventData.company
//                        tvStartDate.text = eventData.startDate
//                        tvEndDate.text = eventData.endDate
//                        ivEventImage.load(eventData.image) {
//                            crossfade(true)
//                            placeholder(R.drawable.ic_launcher_background)
//                        }
//                    } else {
//                        Toast.makeText(this@MainActivity, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            } catch (e: Exception) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(this@MainActivity, "Exception: ${e.message}", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }


    private fun fetchEventData() {
        lifecycleScope.launch {
            try {
                // Making the API call
                val response = apiRepository.getEventData("0056t000004og7kAAA", "Eventdex")

                // Switching to the main thread to update the UI
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        // Handle success
                        eventList = response.body()!!.Events // Get list of events
                        eventAdapter = EventAdapter(eventList)
                        recyclerView.adapter = eventAdapter
                    } else {
                        // Handle API error
                        Toast.makeText(this@MainActivity, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                // Handle exceptions such as network issues
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Exception: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}



