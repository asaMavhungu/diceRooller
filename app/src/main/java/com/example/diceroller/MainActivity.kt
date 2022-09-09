package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)

        val diceLeft: ImageView = findViewById(R.id.diceViewLeft)

        val diceRight: ImageView = findViewById(R.id.diceViewRight)


        val getImage = { x: Int ->
            when (x) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
        }


        val roll1 = dice.roll()
        val drawable = getImage(roll1)
        diceLeft.setImageResource(drawable)
        diceLeft.contentDescription = roll1.toString()


        val roll2 = dice.roll()
        val drawable2 = getImage(roll2)
        diceRight.setImageResource(drawable2)
        diceRight.contentDescription = roll2.toString()

        val result: Int = roll1 * roll2

        val toastText = when (result % 2) {
            1 -> "You Win!!"
            else -> "Try again"
        }

        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show()

    }

}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}