package com.example.authentication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
 /*   private lateinit var buttonSignUp: Button
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var textViewResponse: TextView */



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      /*  val buttonSignUp: Button = findViewById(R.id.buttonSignUp)
        val editTextPassword: EditText = findViewById(R.id.editTextPassword)
        val editTextEmail: EditText = findViewById(R.id.editTextEmail)
        val textViewResponse: TextView = findViewById(R.id.textViewResponse) */



        buttonSignUp.setOnClickListener {
        }
 //       val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            if (editTextEmail.text.toString().isNullOrEmpty() || editTextPassword.text.toString()
                    .isNullOrEmpty()
            )
                textViewResponse.text = "Email Address or Password is not provided"
            else {
                auth.createUserWithEmailAndPassword(
                    editTextEmail.text.toString(),
                    editTextPassword.text.toString()
                )
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            textViewResponse.text =
                                "Sign Up successfull. Email and Password created"
                            val user = auth.currentUser
                            updateUI(user)
                        } else {
                            textViewResponse.text = "Sign Up Failed"
                            updateUI(null)
                        }
                    }
            }
        }

    private fun updateUI(currentUser: FirebaseUser?) {

    }


    }


