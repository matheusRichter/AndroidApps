package com.example.lettershaffle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var shaffleResult: TextView
    private lateinit var sorteadas: TextView
    private lateinit var button: Button
    private lateinit var clear: Button
    private lateinit var apply: Button
    private lateinit var excluded: EditText

    var alphabeto: CharArray = charArrayOf('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z')

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shaffleResult = findViewById(R.id.shaffleResult)
        sorteadas = findViewById(R.id.sorteadas)
        button = findViewById(R.id.button)
        clear = findViewById(R.id.clearButton)
        apply = findViewById(R.id.applyButton)
        excluded = findViewById(R.id.excludedInput)

        button.setOnClickListener { shaffle() }
        clear.setOnClickListener { clearScreen() }
    }

    private fun generateIndex(): Int{
        return (alphabeto.indices).random()
    }

    private fun sortear(): String{
        var index:Int = generateIndex()
        var letra:String = ""
        var excluidas = IntArray(excluded.text.toString().length)
        if (excluded.text.toString().trim().isNotEmpty()) {
            if (excluded.text.toString().trim().length > 5){
                val text = "You can only exclude up to 5 letters!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            } else {
                when(excluded.text.toString().trim().length){
                    1 -> if (alphabeto[index] != excluded.text.toString()[0]) letra = alphabeto[index].toString()
                    2 -> if ((alphabeto[index] != excluded.text.toString()[0]) && (alphabeto[index] != excluded.text.toString()[1])){
                        letra = alphabeto[index].toString()
                    }
                    3 -> if ((alphabeto[index] != excluded.text.toString()[0]) && (alphabeto[index] != excluded.text.toString()[1])
                        && (alphabeto[index] != excluded.text.toString()[2])){
                        letra = alphabeto[index].toString()
                    }
                    4 -> if ((alphabeto[index] != excluded.text.toString()[0]) && (alphabeto[index] != excluded.text.toString()[1])
                        && (alphabeto[index] != excluded.text.toString()[2]) && (alphabeto[index] != excluded.text.toString()[3])){
                        letra = alphabeto[index].toString()
                    }
                    5 -> if ((alphabeto[index] != excluded.text.toString()[0]) && (alphabeto[index] != excluded.text.toString()[1])
                        && (alphabeto[index] != excluded.text.toString()[2]) && (alphabeto[index] != excluded.text.toString()[3])
                        && (alphabeto[index] != excluded.text.toString()[4])){
                        letra = alphabeto[index].toString()
                    }
                }
            }
        } else letra = alphabeto[index].toString()
        return letra
    }

    private fun shaffle() {
        val letra = sortear()
        shaffleResult.text = letra.toString()
        sorteadas.text = sorteadas.text.toString() + " " + letra.toString()
    }

    private fun clearScreen() {
        shaffleResult.text = ""
        sorteadas.text = "Results:"
    }
}