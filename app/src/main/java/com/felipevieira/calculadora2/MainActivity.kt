package com.felipevieira.calculadora2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        um.setOnClickListener { appendOnExpresstion("1", true)}
        dois.setOnClickListener { appendOnExpresstion("2", true)}
        tres.setOnClickListener { appendOnExpresstion("3", true)}
        quatro.setOnClickListener { appendOnExpresstion("4", true)}
        cinco.setOnClickListener { appendOnExpresstion("5", true)}
        seis.setOnClickListener { appendOnExpresstion("6", true)}
        sete.setOnClickListener { appendOnExpresstion("7", true)}
        oito.setOnClickListener { appendOnExpresstion("8", true)}
        nove.setOnClickListener { appendOnExpresstion("9", true)}
        zero.setOnClickListener { appendOnExpresstion("0", true)}
        ponto.setOnClickListener { appendOnExpresstion(".", true)}

        mais.setOnClickListener { appendOnExpresstion("+", true)}
        menos.setOnClickListener { appendOnExpresstion("-", true)}
        vezes.setOnClickListener { appendOnExpresstion("*", true)}
        div.setOnClickListener { appendOnExpresstion("/", true)}

        del.setOnClickListener { viewexpression.text = "" }


        igual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(viewexpression.text.toString()).build()
                val result = expression.evaluate()

                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    viewexpression.text = longResult.toString()
                else
                    viewexpression.text = result.toString()

            } catch (e:Exception) {
                //POP UP ALARM
                //Log.d("Error", " message : " + e.message)
                //System.out.println("Error Na questão")

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("Esta operação é invalida")
                builder.setPositiveButton("Continuar") { dialog, which -> }
                val dialog: AlertDialog = builder.create()
                dialog.show()
            }
        }
    }

    fun appendOnExpresstion (string: String, canClear : Boolean) {

        if(canClear) {
            igual.text = "="
            viewexpression.append(string)
        } else {
            viewexpression.append(viewexpression.text)
            viewexpression.append(string)
            viewexpression.text = ""
        }
    }
}
