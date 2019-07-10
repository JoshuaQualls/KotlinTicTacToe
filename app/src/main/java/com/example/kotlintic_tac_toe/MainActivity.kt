package com.example.kotlintic_tac_toe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var xTurn: Boolean = true
    private var boxes: List<TextView> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boxes = listOf(box0, box1, box2, box3, box4, box5, box6, box7, box8)

        setListeners()
        reset.setOnClickListener { reset() }

        share.setOnClickListener {
            val myIntent = Intent(Intent.ACTION_SEND)
            myIntent.type = "text/plain"

            val shareBody = "I'm a BEAST at Tic-Tac-Toe!"
            val shareSub = "Tic-Tac-Toe Champion"

            myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub)
            myIntent.putExtra(Intent.EXTRA_TEXT, shareBody)

            startActivity(Intent.createChooser(myIntent, "Share Using"))


        }
    }

    private fun boxClicked(box: TextView) {
        if (xTurn) {
            box.text = "X"
            playerTurn.text = "O's Turn"
            xTurn = false
        } else {
            box.text = "O"
            playerTurn.text = "X's Turn"
            xTurn = true
        }
        checkWinner()
    }

    private fun checkWinner() {
        val box0Text = box0.text.toString()
        val box1Text = box1.text.toString()
        val box2Text = box2.text.toString()
        val box3Text = box3.text.toString()
        val box4Text = box4.text.toString()
        val box5Text = box5.text.toString()
        val box6Text = box6.text.toString()
        val box7Text = box7.text.toString()
        val box8Text = box8.text.toString()

        when {
            box0Text != "" && box0Text.equals(box1Text) && box1Text.equals(box2Text) -> {
                playerTurn.text = "Player $box0Text wins!"
                removeListeners()
                box0.setBackgroundResource(R.drawable.textview_winner_border)
                box1.setBackgroundResource(R.drawable.textview_winner_border)
                box2.setBackgroundResource(R.drawable.textview_winner_border)
            }

            box3Text != "" && box3Text.equals(box4Text) && box4Text.equals(box5Text) -> {
                playerTurn.text = "Player $box3Text wins!"
                removeListeners()
                box3.setBackgroundResource(R.drawable.textview_winner_border)
                box4.setBackgroundResource(R.drawable.textview_winner_border)
                box5.setBackgroundResource(R.drawable.textview_winner_border)
            }

            box6Text != "" && box6Text.equals(box7Text) && box7Text.equals(box8Text) -> {
                playerTurn.text = "Player $box6Text wins!"
                removeListeners()
                box6.setBackgroundResource(R.drawable.textview_winner_border)
                box7.setBackgroundResource(R.drawable.textview_winner_border)
                box8.setBackgroundResource(R.drawable.textview_winner_border)
            }

            box0Text != "" && box0Text.equals(box3Text) && box3Text.equals(box6Text) -> {
                playerTurn.text = "Player $box0Text wins!"
                removeListeners()
                box0.setBackgroundResource(R.drawable.textview_winner_border)
                box3.setBackgroundResource(R.drawable.textview_winner_border)
                box6.setBackgroundResource(R.drawable.textview_winner_border)
            }

            box1Text != "" && box1Text.equals(box4Text) && box4Text.equals(box7Text) -> {
                playerTurn.text = "Player $box1Text wins!"
                removeListeners()
                box1.setBackgroundResource(R.drawable.textview_winner_border)
                box4.setBackgroundResource(R.drawable.textview_winner_border)
                box7.setBackgroundResource(R.drawable.textview_winner_border)
            }

            box2Text != "" && box2Text.equals(box5Text) && box5Text.equals(box8Text) -> {
                playerTurn.text = "Player $box2Text wins!"
                removeListeners()
                box2.setBackgroundResource(R.drawable.textview_winner_border)
                box5.setBackgroundResource(R.drawable.textview_winner_border)
                box8.setBackgroundResource(R.drawable.textview_winner_border)
            }

            box0Text != "" && box0Text.equals(box4Text) && box4Text.equals(box8Text) -> {
                playerTurn.text = "Player $box0Text wins!"
                removeListeners()
                box0.setBackgroundResource(R.drawable.textview_winner_border)
                box4.setBackgroundResource(R.drawable.textview_winner_border)
                box8.setBackgroundResource(R.drawable.textview_winner_border)
            }

            box2Text != "" && box2Text.equals(box4Text) && box4Text.equals(box6Text) -> {
                playerTurn.text = "Player $box0Text wins!"
                removeListeners()
                box2.setBackgroundResource(R.drawable.textview_winner_border)
                box4.setBackgroundResource(R.drawable.textview_winner_border)
                box6.setBackgroundResource(R.drawable.textview_winner_border)
            }

        }
    }

    private fun setListeners() {

        boxes.forEach { box ->
            box.isClickable = true
            box.setOnClickListener { boxClicked(box) }
        }

    }

    private fun removeListeners() {
        boxes.forEach { box -> box.isClickable = false }
    }

    private fun reset() {
        boxes.forEach { box ->
            box.text = ""
            box.setBackgroundResource(R.drawable.textview_border)}
        xTurn = true
        playerTurn.text = "X's Turn"
        setListeners()
    }
}
