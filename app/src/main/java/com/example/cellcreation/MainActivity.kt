package com.example.cellcreation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        button = findViewById(R.id.button)
        linView = findViewById(R.id.lin)
        scroll = findViewById(R.id.scroll)
    }
    private lateinit var button: Button
    private lateinit var linView: LinearLayout
    private lateinit var scroll: ScrollView
    private var flagLife = 0
    private var lifeCount = 0
    private var deadCount = 0
    private var idCount = 0

    fun createCell(view: View){
        val ltInflater: LayoutInflater = layoutInflater
        val inflater: LayoutInflater = layoutInflater
        val choice = (0..10).random()
        if (choice % 2 == 0){
            val frameFrag: View = ltInflater.inflate(R.layout.death_cell, linView, false)
            val fragment: LinearLayout = frameFrag as LinearLayout
            fragment.setId(idCount)
            idCount += 1
            linView.addView(fragment)
            lifeCount = 0
            deadCount += 1
            scroll.fullScroll(ScrollView.FOCUS_DOWN)
        }
        else {
            val frameFrag: View = ltInflater.inflate(R.layout.life_cell_cell, linView, false)
            val fragment: LinearLayout = frameFrag as LinearLayout
            fragment.setId(idCount)
            idCount += 1
            linView.addView(fragment)
            lifeCount += 1
            flagLife = 0
            deadCount = 0
            scroll.fullScroll(ScrollView.FOCUS_DOWN)
        }
        if (lifeCount == 3){
            val frameFrag1: View = inflater.inflate(R.layout.life_cell, linView, false)
            val fragment1: LinearLayout = frameFrag1 as LinearLayout
            fragment1.setId(idCount)
            idCount += 1
            linView.addView(fragment1)
            flagLife = fragment1.getId()
        }
        if (deadCount == 3 && flagLife != 0){
            linView.removeViewAt(flagLife)
        }
        scrollDialogDown()
    }
    private fun scrollDialogDown() {
        scroll.post(Runnable { scroll.fullScroll(ScrollView.FOCUS_DOWN) })
    }
}
