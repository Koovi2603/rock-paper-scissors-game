package com.koovi.rpsgame

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    //declare
    private lateinit var textView: TextView
    private lateinit var imgResult: ImageView
    private lateinit var reset: Button
    private lateinit var imageView1Rock: ImageView
    private lateinit var imageView2Paper: ImageView
    private lateinit var imageView3Scissors: ImageView
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var resultMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //initialise
        textView = findViewById(R.id.textView)
        reset = findViewById(R.id.reset)
        imageView1Rock = findViewById(R.id.img2)
        imageView2Paper = findViewById(R.id.img3)
        imageView3Scissors = findViewById(R.id.img4)
        textView1 = findViewById(R.id.textView2)
        textView2 = findViewById(R.id.textView3)
        textView3 = findViewById(R.id.textView4)
        imgResult = findViewById(R.id.imageView2)
        resultMessage = findViewById(R.id.resultMessage)

        var random = (Math.random() *3).roundToInt() //generate a random number

        imageView1Rock.setOnClickListener {
            when (random) {
                1 -> { imgResult.setImageResource(R.drawable.equal)
                    resultMessage.text = "You Drew!"
                }
                2 -> { imgResult.setImageResource(R.drawable.greater)
                    resultMessage.text = "You Won!"
                }
                else -> { imgResult.setImageResource(R.drawable.less)
                    resultMessage.text = "You Lost!"
                }
            }
        }

        imageView2Paper.setOnClickListener {
            when (random) {
                2 -> { imgResult.setImageResource(R.drawable.equal)
                    resultMessage.text = "You Drew!"
                }
                3 -> { imgResult.setImageResource(R.drawable.greater)
                    resultMessage.text = "You Won!"
                }
                else -> { imgResult.setImageResource(R.drawable.less)
                    resultMessage.text = "You Lost!"
                }
            }
        }

        imageView3Scissors.setOnClickListener {
            when (random) {
                3 -> { imgResult.setImageResource(R.drawable.equal)
                    resultMessage.text = "You Drew!"
                }
                1 -> { imgResult.setImageResource(R.drawable.greater)
                    resultMessage.text = "You Won!"
                }
                else -> { imgResult.setImageResource(R.drawable.less)
                    resultMessage.text = "You Lost!"
                }
            }
        }

        reset.setOnClickListener {
            random = (Math.random() *3).roundToInt()
            imgResult.setImageResource(R.drawable.rps_result)
            resultMessage.text = ""
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}