package com.example.task_5_activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.task_5_activities.databinding.ActivitySecondBinding

class ActivitySecond : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)



        receiveData()

        binding.returnBackBtn.setOnClickListener {
            returnData()
        }
        binding.openThirdActivityBtn.setOnClickListener {
            openThirdActivity()
        }

    }

    private fun receiveData(){
       val data = intent.getStringExtra("key")
        if(data != null){
            binding.receivedDataTv.text = data
        }

    }


    private fun returnData(){
        val textToReturn = binding.sendDataBackEt.text.toString()
        val intent = intent.putExtra("input", textToReturn)
        setResult(RESULT_OK, intent)
        onBackPressed()
    }

    private fun openThirdActivity(){

        val intent = Intent(this, ActivityThird::class.java)
        startActivity(intent)

    }
}