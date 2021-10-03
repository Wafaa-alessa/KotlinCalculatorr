package com.example.kotlincalculatorr

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincalculatorr.R

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    private lateinit var divide: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var sex: Button
    private lateinit var multy: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var sub: Button
    private lateinit var plusminus: Button
    private lateinit var zero: Button
    private lateinit var point: Button
    private lateinit var add: Button
    private lateinit var delete: Button
    private lateinit var clear: Button
    private lateinit var equals: Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewModel = ViewModelProvider(this).get(NewCalc::class.java)

        display = findViewById(R.id.Display)

        display.text = viewModel.displayText

        seven = findViewById(R.id.button7)
        seven.setOnClickListener { viewModel.setNum('7'); display.text = viewModel.displayText }
        eight = findViewById(R.id.button8)
        eight.setOnClickListener { viewModel.setNum('8'); display.text = viewModel.displayText }
        nine = findViewById(R.id.button9)
        nine.setOnClickListener { viewModel.setNum('9'); display.text = viewModel.displayText }
        divide = findViewById(R.id.buttondidive)
        divide.setOnClickListener { viewModel.handleOperator('/'); display.text = viewModel.displayText }
        four = findViewById(R.id.button4)
        four.setOnClickListener { viewModel.setNum('4'); display.text = viewModel.displayText }
        five = findViewById(R.id.button5)
        five.setOnClickListener { viewModel.setNum('5'); display.text = viewModel.displayText }
        sex = findViewById(R.id.button6)
        sex.setOnClickListener { viewModel.setNum('6'); display.text = viewModel.displayText }
        multy = findViewById(R.id.buttonmulty)
        multy.setOnClickListener { viewModel.handleOperator('*'); display.text = viewModel.displayText }
        one = findViewById(R.id.button1)
        one.setOnClickListener { viewModel.setNum('1'); display.text = viewModel.displayText }
        two = findViewById(R.id.button2)
        two.setOnClickListener { viewModel.setNum('2'); display.text = viewModel.displayText }
        three = findViewById(R.id.button3)
        three.setOnClickListener { viewModel.setNum('3'); display.text = viewModel.displayText }
        sub = findViewById(R.id.buttonsub)
        sub.setOnClickListener { viewModel.handleOperator('-'); display.text = viewModel.displayText }
        plusminus = findViewById(R.id.buttonminumsplus)
        plusminus.setOnClickListener { viewModel.onClickPlusMinus(); display.text = viewModel.displayText }
        zero = findViewById(R.id.button0)
        zero.setOnClickListener { viewModel.setNum('0'); display.text = viewModel.displayText }
        point = findViewById(R.id.buttonpoint)
        point.setOnClickListener { viewModel.onClickDecimal(); display.text = viewModel.displayText }
        add = findViewById(R.id.buttonadd)
        add.setOnClickListener { viewModel.handleOperator('+'); display.text = viewModel.displayText }
        delete = findViewById(R.id.buttondelete)
        delete.setOnClickListener { viewModel.deleteLast(); display.text = viewModel.displayText }
        clear = findViewById(R.id.buttonclear)
        clear.setOnClickListener { viewModel.clearAll(); display.text = viewModel.displayText }
        equals = findViewById(R.id.buttonequal)
        equals.setOnClickListener { viewModel.calculate(); display.text = viewModel.displayText }

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            display.setPadding(0,0,24,0)
            display.textSize = 24f
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            display.setPadding(0,24,24,0)
            display.textSize = 32f
        }
    }
}