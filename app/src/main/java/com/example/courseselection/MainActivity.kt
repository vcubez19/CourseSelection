package com.example.courseselection


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    enum class LoginSuccess {
        Login,
        Password,
        Success,

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val username = findViewById<EditText>(R.id.idUsername)
        val password = findViewById<EditText>(R.id.idPassword)
        val login = findViewById<Button>(R.id.idLogin)


        login.setOnClickListener {
            when (checkIt(username.text.toString(), password.text.toString())) {
                LoginSuccess.Login -> {
                    Toast.makeText(
                        applicationContext, getString(R.string.error_message_username),
                        Toast.LENGTH_LONG
                    ).show()
                    username.requestFocus()
                }
                LoginSuccess.Password -> {
                    Toast.makeText(
                        applicationContext, getString(R.string.error_message_password),
                        Toast.LENGTH_LONG
                    ).show()
                    password.requestFocus()
                }
                else -> Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()


            }
        }


    }


    private fun checkIt(textUsername: String, textPassword: String): Any {
        val usernameValue = "Vincent"
        val passwordValue = "password"
        if (usernameValue != textUsername) {
            return LoginSuccess.Login
        }


        return if (passwordValue != textPassword) {
            return LoginSuccess.Password
        } else {
            LoginSuccess.Success
        }


    }


}

