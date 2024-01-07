package com.example.login


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth as FirebaseAuth1


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth1
    override fun onCreate(savedInstanceState: Bundle?) {
        FirebaseApp.initializeApp(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth1.getInstance()


        val loginButton = findViewById<Button>(R.id.login_button)
        val signupButton = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editTextText)
        val editpasswordText = findViewById<EditText>(R.id.editTextTextPassword)


        loginButton.setOnClickListener{
            val usernametext = editText.text.toString()
            val passwordtext = editpasswordText.text.toString()

            // Use Firebase authentication to sign in
            auth.signInWithEmailAndPassword(usernametext, passwordtext)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Login successful, you can navigate to the next screen
                        showToast("login successful")
                    } else {

                        showToast("Login Failed")
                    }
                }


        }

        signupButton.setOnClickListener{

        }






    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}


