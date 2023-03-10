package com.example.minesweepergame

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.minesweepergame.R.*
import com.example.minesweepergame.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    //Glb Declare
    private lateinit var binding : ActivityMainBinding
    private var gameLevels = ""
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = this.getSharedPreferences("time", Context.MODE_PRIVATE)
        binding.tvBestTime.text = sharedPreferences.getString("Best","00:00")
        val ltime: String? = sharedPreferences.getString("Last","00:00")

        binding.tvLastGameTime.text = ltime
        //Declaration of UI Elements
//        val btnCustomBoard = findViewById<Button>(id.btn_CustomBoard)
//        val btnStart = findViewById<Button>(id.btn_Start)
//
//        val tvBestTime = findViewById<TextView>(id.tv_BestTime)
//        val tvLastTime = findViewById<TextView>(id.tv_LastGameTime)
//
//        val gameRules = findViewById<Button>(id.btn_GameRules)
        binding.btnCustomBoard.setOnClickListener{
            val intent = Intent(this@MainActivity, CustomBoard::class.java).apply{
                putExtra("height", 9)  //put the value
                putExtra("width", 9)
                putExtra("mines", 40)
            }
            startActivity(intent)
        }
        /* if user clicks on easy radio button */
        binding.rbEasyLevel.setOnClickListener{
            gameLevels = "easy"
        }
        /* if user clicks on medium difficulty radio button */
        binding.rbMediumLevel.setOnClickListener{
            gameLevels="medium"
        }

        /* if user clicks on hard difficulty radio button */
        binding.rbHardLevel.setOnClickListener{
            gameLevels="hard"
        }

        /* if user clicks start button after choosing difficulty level */
        binding.btnStart.setOnClickListener{
            if(gameLevels==""){
                Toast.makeText(this, "Choose Valid Option", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, GamePlayActivity::class.java).apply {
                    putExtra("selectedLevel", gameLevels)
                    putExtra("flag", 1)
                }
                startActivity(intent)
            }
        }
        binding.btnGameRules.setOnClickListener{
            showInstructions()
        }
    }

    private fun showInstructions() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)

        builder.setTitle("INSTRUCTIONS")
        builder.setMessage("The purpose of the game is to open all the cells of the board which do not contain a bomb. You lose if you set off a bomb cell.\n" +
                "\n" +
                "Every non-bomb cell you open will tell you the total number of bombs in the eight neighboring cells. Once you are sure that a cell contains a bomb, you can right-click to put a flag it on it as a reminder. Once you have flagged all the bombs around an open cell, you can quickly open the remaining non-bomb cells by shift-clicking on the cell.\n" +
                "\n" +
                "To start a new game (abandoning the current one), just click on the yellow face button.\n" +
                "\n" +
                "Happy mine hunting!")

        builder.setCancelable(false)

        builder.setPositiveButton("OK"
        ){ dialog, which ->

        }
        val alertDialog = builder.create()
        alertDialog.show()
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        finishAffinity()
    }
}