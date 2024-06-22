package com.example.tugasm3_6958

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.tugasm3_6958.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        binding = ActivityPlayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.txtGameOver.isVisible = false

        val arrPanel: ArrayList<ArrayList<Button>> = arrayListOf(
            arrayListOf(binding.panel11,binding.panel12,binding.panel13),
            arrayListOf(binding.panel21,binding.panel22,binding.panel23),
            arrayListOf(binding.panel31,binding.panel32,binding.panel33)
        )

        for (i in arrPanel){
            for (j in i){
                j.text = ""
                j.setBackgroundColor(resources.getColor(R.color.tile))
            }
        }

        var rndInitX = (0..2).random()
        var rndInitY = (0..2).random()

        val firstBtn = arrPanel[rndInitY][rndInitX]
        firstBtn.text = ("2").toString()
        firstBtn.setBackgroundColor(resources.getColor(R.color.no2))

        var score = 0

        var gameOver = false

        binding.btnUp.setOnClickListener {

            var move = true;
            var next = false;

            // MOVE UP
            while (move){
                move = false

                for (i in 0..2){
                    for (j in 0..2){
                        if (j > 0 && arrPanel[j][i].text != ""){
                            if (arrPanel[j-1][i].text == ""){
                                arrPanel[j-1][i].text = arrPanel[j][i].text
                                arrPanel[j][i].text = ""

                                //
                                when (arrPanel[j-1][i].text){
                                    "2" -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.no4))
                                    }
                                    "8" -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[j][i].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true

                            } else if (arrPanel[j-1][i].text == arrPanel[j][i].text){

                                score += arrPanel[j-1][i].text.toString().toInt()
                                binding.txtScore.text = score.toString()

                                arrPanel[j-1][i].text = (arrPanel[j-1][i].text.toString().toInt() * 2).toString()
                                arrPanel[j][i].text = ""

                                //
                                when (arrPanel[j-1][i].text){
                                    "2" -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.no4))
                                    }
                                    "8" -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[j][i].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true
                            }
                        }
                    }
                }
            }

            // NEXT TILE
            if (next){
                do {
                    rndInitY = (0..2).random()
                    rndInitX = (0..2).random()
                } while (arrPanel[rndInitY][rndInitX].text != "")

                val nextTile = arrPanel[rndInitY][rndInitX]
                nextTile.text = ("2").toString()
                nextTile.setBackgroundColor(resources.getColor(R.color.no2))
            }

            // GAME OVER
            if (isGameOver(arrPanel) && !next){
                binding.txtGameOver.isVisible = true
                Toast.makeText(this, "Game Over", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnDown.setOnClickListener {

            var move = true;
            var next = false;

            // MOVE DOWN
            while (move){
                move = false

                for (i in 0..2){
                    for (j in 2 downTo 0){
                        if (j < 2 && arrPanel[j][i].text != ""){
                            if (arrPanel[j+1][i].text == ""){
                                arrPanel[j+1][i].text = arrPanel[j][i].text
                                arrPanel[j][i].text = ""

                                //
                                when (arrPanel[j+1][i].text){
                                    "2" -> {
                                        arrPanel[j+1][i].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[j+1][i].setBackgroundColor(resources.getColor(R.color.no4))
                                    }
                                    "8" -> {
                                        arrPanel[j+1][i].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[j+1][i].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[j+1][i].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[j+1][i].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[j][i].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true

                            } else if (arrPanel[j+1][i].text == arrPanel[j][i].text){

                                score += arrPanel[j+1][i].text.toString().toInt()
                                binding.txtScore.text = score.toString()

                                arrPanel[j+1][i].text = (arrPanel[j+1][i].text.toString().toInt() * 2).toString()
                                arrPanel[j][i].text = ""

                                //
                                when (arrPanel[j+1][i].text){
                                    "2" -> {
                                        arrPanel[j+1][i].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[j+1][i].setBackgroundColor(resources.getColor(R.color.no4))
                                    }
                                    "8" -> {
                                        arrPanel[j+1][i].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[j+1][i].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[j+1][i].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[j+1][i].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[j][i].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true
                            }
                        }
                    }
                }
            }

            // NEXT TILE
            if (next){
                do {
                    rndInitY = (0..2).random()
                    rndInitX = (0..2).random()
                } while (arrPanel[rndInitY][rndInitX].text != "")

                val nextTile = arrPanel[rndInitY][rndInitX]
                nextTile.text = ("2").toString()
                nextTile.setBackgroundColor(resources.getColor(R.color.no2))
            }

            // GAME OVER
            if (isGameOver(arrPanel) && !next){
                binding.txtGameOver.isVisible = true
                Toast.makeText(this, "Game Over", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnLeft.setOnClickListener {

            var move = true;
            var next = false;

            // MOVE LEFT
            while (move){
                move = false

                for (i in 0..2){
                    for (j in 0..2){
                        if (i > 0 && arrPanel[j][i].text != ""){
                            if (arrPanel[j][i-1].text == ""){
                                arrPanel[j][i-1].text = arrPanel[j][i].text
                                arrPanel[j][i].text = ""

                                //
                                when (arrPanel[j][i-1].text){
                                    "2" -> {
                                        arrPanel[j][i-1].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[j][i-1].setBackgroundColor(resources.getColor(R.color.no4))
                                    }
                                    "8" -> {
                                        arrPanel[j][i-1].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[j][i-1].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[j][i-1].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[j][i-1].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[j][i].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true

                            } else if (arrPanel[j][i-1].text == arrPanel[j][i].text){

                                score += arrPanel[j][i-1].text.toString().toInt()
                                binding.txtScore.text = score.toString()

                                arrPanel[j][i-1].text = (arrPanel[j][i-1].text.toString().toInt() * 2).toString()
                                arrPanel[j][i].text = ""

                                //
                                when (arrPanel[j][i-1].text){
                                    "2" -> {
                                        arrPanel[j][i-1].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[j][i-1].setBackgroundColor(resources.getColor(R.color.no4))
                                    }
                                    "8" -> {
                                        arrPanel[j][i-1].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[j][i-1].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[j][i-1].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[j][i-1].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[j][i].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true
                            }
                        }
                    }
                }
            }

            // NEXT TILE
            if (next){
                do {
                    rndInitY = (0..2).random()
                    rndInitX = (0..2).random()
                } while (arrPanel[rndInitY][rndInitX].text != "")

                val nextTile = arrPanel[rndInitY][rndInitX]
                nextTile.text = ("2").toString()
                nextTile.setBackgroundColor(resources.getColor(R.color.no2))
            }

            // GAME OVER
            if (isGameOver(arrPanel) && !next){
                binding.txtGameOver.isVisible = true
                Toast.makeText(this, "Game Over", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnRight.setOnClickListener {

            var move = true;
            var next = false;

            // MOVE UP
            while (move){
                move = false

                for (i in 2 downTo 0){
                    for (j in 0..2){
                        if (i < 2 && arrPanel[j][i].text != ""){
                            if (arrPanel[j][i+1].text == ""){
                                arrPanel[j][i+1].text = arrPanel[j][i].text
                                arrPanel[j][i].text = ""

                                //
                                when (arrPanel[j][i+1].text){
                                    "2" -> {
                                        arrPanel[j][i+1].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[j][i+1].setBackgroundColor(resources.getColor(R.color.no4))
                                    }
                                    "8" -> {
                                        arrPanel[j][i+1].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[j][i+1].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[j][i+1].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[j][i+1].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[j][i].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true

                            } else if (arrPanel[j][i+1].text == arrPanel[j][i].text){

                                score += arrPanel[j][i+1].text.toString().toInt()
                                binding.txtScore.text = score.toString()

                                arrPanel[j][i+1].text = (arrPanel[j][i+1].text.toString().toInt() * 2).toString()
                                arrPanel[j][i].text = ""

                                //
                                when (arrPanel[j][i+1].text){
                                    "2" -> {
                                        arrPanel[j][i+1].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[j][i+1].setBackgroundColor(resources.getColor(R.color.no4))
                                    }
                                    "8" -> {
                                        arrPanel[j][i+1].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[j][i+1].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[j][i+1].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[j][i+1].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[j-1][i].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[j][i].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true
                            }
                        }
                    }
                }
            }

            // NEXT TILE
            if (next){
                do {
                    rndInitY = (0..2).random()
                    rndInitX = (0..2).random()
                } while (arrPanel[rndInitY][rndInitX].text != "")

                val nextTile = arrPanel[rndInitY][rndInitX]
                nextTile.text = ("2").toString()
                nextTile.setBackgroundColor(resources.getColor(R.color.no2))
            }

            // GAME OVER
            if (isGameOver(arrPanel) && !next){
                binding.txtGameOver.isVisible = true
                Toast.makeText(this, "Game Over", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnBackPlay.setOnClickListener {
            finish()
        }

    }
}

fun isGameOver(arrPanel: ArrayList<ArrayList<Button>>): Boolean {
    for (i in 0..2){
        for (j in 0..2){
            if (arrPanel[i][j].text == ""){
                return false
            } else if (i > 0 && arrPanel[i][j].text == arrPanel[i-1][j].text) {
                return false
            } else if (i < 2 && arrPanel[i][j].text == arrPanel[i+1][j].text){
                return false
            } else if (j > 0 && arrPanel[i][j].text == arrPanel[i][j-1].text) {
                return false
            } else if (j < 2 && arrPanel[i][j].text == arrPanel[i][j+1].text){
                return false
            }
        }
    }
    return true
}