package by.it.academy.app11task

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

private var STATE_APP = false
const val STATE_APP_KEY = "state app key"
const val INTENT_TAG = "intent tag"

class MainActivity : AppCompatActivity() {

    private lateinit var broadcastReceiver: BroadcastReceiver
    private lateinit var localAdapter: LogInfoAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onStart() {
        STATE_APP = true
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initBroadcastReceiver()
        getCurrentLog()
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)

        localAdapter = LogInfoAdapter()
        recyclerView.apply {
            adapter = localAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        }
    }

    private fun getCurrentLog() {
        try {
            val logFilePath = File(filesDir.toString().plus("/log.txt"))
            BufferedReader(FileReader(logFilePath)).apply {
                val list = mutableListOf<LogData>()
                try {
                    while (true) {
                        val line = this.readLine()
                        if (line != "") {
                            list.add(Gson().fromJson(line, LogData::class.java))
                        } else {
                            continue
                        }
                    }
                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity,"Exception in MainActivity.getCurrentLog: $e",Toast.LENGTH_LONG).show()
                    Log.i("TAG_TAG", "Exception in MainActivity.getCurrentLog: $e")
                }
                if (list.size > 0) {
                    localAdapter.updateList(list)
                }
            }
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity,e.toString(),Toast.LENGTH_LONG).show()
            Log.i("TAG_TAG", "Log is not created yet")
        }
    }

    fun updateFileList() {
        getCurrentLog()
    }

    private fun initBroadcastReceiver() {
        val filter = IntentFilter().apply {
            addAction("FILE_UPDATED")
            addAction(Intent.ACTION_TIMEZONE_CHANGED)
            addAction(Intent.ACTION_TIME_CHANGED)
            addAction(Intent.ACTION_BATTERY_LOW)
        }

        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (!intent?.action.equals("FILE_UPDATED")) {
                    context?.startService(
                            Intent(context, BroadcastService::class.java).putExtra(
                                    INTENT_TAG,
                                    intent?.action
                            )
                    )
                } else if (intent?.action.equals("FILE_UPDATED") && STATE_APP) {
                    updateFileList()
                }
            }
        }
        registerReceiver(broadcastReceiver, filter)
    }

    override fun onDestroy() {
        STATE_APP = false
        getPreferences(MODE_PRIVATE).edit().apply {
            putBoolean(STATE_APP_KEY, STATE_APP)
        }.apply()
        super.onDestroy()
    }
}