package com.example.minesweepergame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.minesweepergame.databinding.ActivityCustomBoardBinding


class CustomBoard : AppCompatActivity() {

    private lateinit var binding: ActivityCustomBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //edit Text

        binding.btnSubmit.setOnClickListener{
            //after clicking submit button, this will transfer or pass the value which the user has entered
            var getHeight = Integer.parseInt(binding.height.editText?.text.toString())
            var getWidth = Integer.parseInt(binding.width.editText?.text.toString())
            var getMine = Integer.parseInt(binding.mines.editText?.text.toString())

            /* passing the values to the gameplay activity */
            val intent = Intent(this, GamePlayActivity::class.java).apply {
                putExtra("height", getHeight)  //put the value
                putExtra("width", getWidth)
                putExtra("mines", getMine)
            }
            startActivity(intent)
        }


    }
}