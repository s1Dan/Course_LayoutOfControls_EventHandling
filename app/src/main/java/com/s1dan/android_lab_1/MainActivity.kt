package com.s1dan.android_lab_1

import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.*
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var boldButton: Button
    private lateinit var italicButton: Button
    private lateinit var textView: TextView
    private lateinit var btnPlus: Button
    private lateinit var btnMinus: Button

    private lateinit var rBtnSansSerif: RadioButton
    private lateinit var rBtnSerif: RadioButton
    private lateinit var rBtnMono: RadioButton

    private lateinit var btnRed: ImageButton
    private lateinit var btnBlue: ImageButton
    private lateinit var btnGreen: ImageButton
    private lateinit var btnTurquoise: ImageButton
    private lateinit var btnPink: ImageButton
    private lateinit var btnYellow: ImageButton
    private lateinit var btnBlack: ImageButton

    private lateinit var edText: EditText
    var mTextSize = 14f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //// set links
        // toggle and buttons
        boldButton = findViewById(R.id.tgBtnBoldStyle)
        italicButton = findViewById(R.id.tgBtnItalicStyle)
        textView = findViewById(R.id.textView)
        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMin)

        // radio buttons
        rBtnSansSerif = findViewById(R.id.rBtnSansSerif)
        rBtnSerif = findViewById(R.id.rBtnSerif)
        rBtnMono = findViewById(R.id.rBtnMono)

        // color buttons
        btnRed = findViewById(R.id.btnRed)
        btnBlue = findViewById(R.id.btnBlue)
        btnGreen = findViewById(R.id.btnGreen)
        btnTurquoise = findViewById(R.id.btnTurquoise)
        btnPink = findViewById(R.id.btnPink)
        btnYellow = findViewById(R.id.btnYellow)
        btnBlack = findViewById(R.id.btnBlack)

        // edit text
        edText = findViewById(R.id.edText)
        edText.setText("Форматируемый текст")

        onClick()
        textView()
    }

    private fun onClick() {
        //Change Style Buttons
        boldButton.setOnClickListener {
            when (edText.typeface.style) {
                Typeface.ITALIC -> { edText.setTypeface(edText.typeface, Typeface.BOLD_ITALIC) }
                Typeface.BOLD_ITALIC -> { edText.setTypeface(edText.typeface, Typeface.ITALIC) }
                Typeface.BOLD -> { edText.typeface = Typeface.create(edText.typeface, Typeface.NORMAL) }
                else -> edText.setTypeface(edText.typeface, Typeface.BOLD)
            }
        }

        italicButton.setOnClickListener {
            when (edText.typeface.style) {
                Typeface.BOLD -> { edText.setTypeface(edText.typeface, Typeface.BOLD_ITALIC) }
                Typeface.BOLD_ITALIC -> { edText.setTypeface(edText.typeface, Typeface.BOLD) }
                Typeface.ITALIC -> { edText.typeface = Typeface.create(edText.typeface, Typeface.NORMAL) }
                else -> edText.setTypeface(edText.typeface, Typeface.ITALIC)
            }
        }
        // RadioButton's
        rBtnSansSerif.setOnClickListener {
            when (edText.typeface.style) {
                Typeface.ITALIC -> { edText.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC) }
                Typeface.BOLD_ITALIC -> { edText.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC) }
                Typeface.BOLD -> { edText.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD) }
                else -> edText.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL)
            }
        }
        rBtnMono.setOnClickListener {
            when (edText.typeface.style) {
                Typeface.ITALIC -> { edText.setTypeface(Typeface.MONOSPACE, Typeface.ITALIC) }
                Typeface.BOLD_ITALIC -> { edText.setTypeface(Typeface.MONOSPACE, Typeface.BOLD_ITALIC) }
                Typeface.BOLD -> { edText.setTypeface(Typeface.MONOSPACE, Typeface.BOLD) }
                else -> edText.setTypeface(Typeface.MONOSPACE, Typeface.NORMAL)
            }
        }
        rBtnSerif.setOnClickListener {
            when (edText.typeface.style) {
                Typeface.ITALIC -> { edText.setTypeface(Typeface.SERIF, Typeface.ITALIC) }
                Typeface.BOLD_ITALIC -> { edText.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC) }
                Typeface.BOLD -> { edText.setTypeface(Typeface.SERIF, Typeface.BOLD) }
                else -> edText.setTypeface(Typeface.SERIF, Typeface.NORMAL)
            }
        }

        // Change Color Buttons
        btnRed.setOnClickListener { edText.setTextColor(ContextCompat.getColor(this, R.color.red)) }
        btnBlue.setOnClickListener { edText.setTextColor(ContextCompat.getColor(this, R.color.blue)) }
        btnGreen.setOnClickListener { edText.setTextColor(ContextCompat.getColor(this, R.color.green)) }
        btnTurquoise.setOnClickListener { edText.setTextColor(ContextCompat.getColor(this, R.color.turquoise)) }
        btnPink.setOnClickListener { edText.setTextColor(ContextCompat.getColor(this, R.color.pink)) }
        btnYellow.setOnClickListener { edText.setTextColor(ContextCompat.getColor(this, R.color.yellow)) }
        btnBlack.setOnClickListener { edText.setTextColor(ContextCompat.getColor(this, R.color.black)) }

        // "+" & "-" Buttons
        btnPlus.setOnClickListener {
            mTextSize += 2f
            edText.setTextSize(TypedValue.COMPLEX_UNIT_SP,mTextSize)
            textView()
        }

        btnMinus.setOnClickListener {
            mTextSize -= 2f
            edText.setTextSize(TypedValue.COMPLEX_UNIT_SP,mTextSize )
            textView()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun textView() {
        textView.text = "TextSize: $mTextSize"
    }
}