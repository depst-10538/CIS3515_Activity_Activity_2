package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

const val SIZE_KEY = "SIZE_KEY"

class DisplayActivity : AppCompatActivity() {

    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            it.data?.apply{
                // set text size equal to selected value
                lyricsDisplayTextView.textSize = getIntExtra(SIZE_KEY,22).toFloat()
            }
        }
    }
    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value

    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        // open selector on button click
        textSizeSelectorButton.setOnClickListener {
            val intent = Intent(this@DisplayActivity,TextSizeActivity::class.java)
            launcher.launch(intent)
        }
    }
}