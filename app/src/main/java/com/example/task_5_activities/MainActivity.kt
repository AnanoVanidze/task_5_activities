package com.example.task_5_activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.task_5_activities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val registerForActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == Activity.RESULT_OK){
                binding.resultTv.text = it.data?.getStringExtra("input")
            }
        }


        binding.openSecondActivityBtn.setOnClickListener {
            val text = binding.textToSendET.text.toString()
            val intent = Intent(this, ActivitySecond::class.java).apply {
                putExtra("key", text)
            }

            registerForActivity.launch(intent)
        }
    }




}