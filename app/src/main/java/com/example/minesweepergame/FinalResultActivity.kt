package com.example.minesweepergame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.minesweepergame.databinding.ActivityFinalResultBinding

class FinalResultActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFinalResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalResultBinding.inflate(layoutInflater)

        setContentView(binding.root)
        // get values from gameplay
        var intent = getIntent()
        var showName = intent.getStringExtra("player_name")
        var showResult = intent.getStringExtra("result")

        /* showing the result on screen*/
        binding.showName.text = showName
        binding.showResult.text = showResult

        binding.btnTryAgain.setOnClickListener{
            Toast.makeText(this, "Thank You For Playing", Toast.LENGTH_SHORT).show()
            val intentCallMainActivity = Intent(this, MainActivity::class.java).apply{}
            startActivity(intentCallMainActivity)
        }
    }
    override fun onBackPressed() {
        //super.onBackPressed()
        finishAffinity()
    }
}