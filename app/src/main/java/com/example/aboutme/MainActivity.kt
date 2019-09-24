package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName( "Joey")


    //lateinit var editText: EditText
    //lateinit var nicknameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        //findViewById<Button>(R.id.done_button).setOnClickListener {
        //    addNickname(it)
        //}

        binding.doneButton.setOnClickListener {
            addNickname(it)

        binding.resetButton.setOnClickListener {
            resetNickname(it)
        }

//        editText = findViewById(R.id.nickname_edit)
//        nicknameTextView = findViewById(R.id.nickname_text)
    }



    }

    private fun resetNickname(view: View) {
        binding.apply {
            myName?.nickname = ""
            invalidateAll()
            nicknameEdit.text.clear()
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE
            reset_button.visibility = View.GONE
        }
    }

    private fun addNickname(view: View) {
        if (nickname_edit.text.toString() != "") {
                binding.apply {
                //nicknameText.text = nicknameEdit.text
                myName?.nickname = nicknameEdit.text.toString()
                invalidateAll()
                nicknameEdit.visibility = View.GONE
                doneButton.visibility = View.GONE
                nicknameText.visibility = View.VISIBLE
                reset_button.visibility = View.VISIBLE
            }
        }
        //nicknameTextView.text = editText.text
        //editText.visibility = View.GONE
        //view.visibility = View.GONE
        //nicknameTextView.visibility = View.VISIBLE

        // hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
