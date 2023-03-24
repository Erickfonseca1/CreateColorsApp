package com.example.createcolorsapp

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var sbVermelho: SeekBar
    private lateinit var sbVerde: SeekBar
    private lateinit var sbAzul: SeekBar
    private lateinit var tvCor: TextView
    private lateinit var layoutCor: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvCor = findViewById(R.id.tvCor)
        this.layoutCor = findViewById(R.id.layoutCor)

        this.sbVermelho = findViewById(R.id.sbVermelho)
        this.sbVermelho.progressTintList = ColorStateList.valueOf(Color.RED)
        this.sbVermelho.thumbTintList = ColorStateList.valueOf(Color.RED)

        this.sbVerde = findViewById(R.id.sbVerde)
        this.sbVerde.progressTintList = ColorStateList.valueOf(Color.GREEN)
        this.sbVerde.thumbTintList = ColorStateList.valueOf(Color.GREEN)

        this.sbAzul = findViewById(R.id.sbAzul)
        this.sbAzul.progressTintList = ColorStateList.valueOf(Color.BLUE)
        this.sbAzul.thumbTintList = ColorStateList.valueOf(Color.BLUE)

        this.alterarCorFinal()

        this.sbVermelho.setOnSeekBarChangeListener(OnChange())
        this.sbVerde.setOnSeekBarChangeListener(OnChange())
        this.sbAzul.setOnSeekBarChangeListener(OnChange())
    }

    private fun alterarCorFinal() {
        val vermelho = this.sbVermelho.progress
        val verde = this.sbVerde.progress
        val azul = this.sbAzul.progress
        val cor = Color.rgb(vermelho, verde, azul)

        if (255 - vermelho < vermelho - 0 && 255 - verde < verde - 0 && 255 - azul < azul - 0)
            this.tvCor.setBackgroundColor(Color.BLACK)
        else
            this.tvCor.setBackgroundColor(Color.WHITE)

        this.layoutCor.setBackgroundColor(cor)
        this.tvCor.setTextColor(cor)
        this.tvCor.text = String.format("#%02x%02x%02x", vermelho, verde, azul)
    }

    inner class OnChange: SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            this@MainActivity.alterarCorFinal()
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {}
        override fun onStopTrackingTouch(p0: SeekBar?) {}
    }
}