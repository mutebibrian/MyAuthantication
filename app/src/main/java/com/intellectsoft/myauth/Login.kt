package com.intellectsoft.myauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth
    }
    fun Signin(view:View){
        val emailet = findViewById<EditText>(R.id.etemail1)
        val loginpwd =findViewById<EditText>(R.id.etpwd2)
        if (TextUtils.isEmpty(emailet.toString()) || TextUtils.isEmpty(loginpwd.toString())){
            Toast.makeText(this,"Please fill all the fields",Toast.LENGTH_LONG).show()
        }else{
            auth.signInWithEmailAndPassword(emailet.toString(), loginpwd.toString()).addOnCompleteListener{ task->
                if(task.isSuccessful){
                    val intent =Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this,"Please enter correct Credentials",Toast.LENGTH_LONG).show()
                }

            }
        }
            //Text  Utilis is string splitter

    }
    fun goToRegister (view: View){
        val intent = Intent(this,Register::class.java)
        startActivity(intent)
    }
fun Forgot (view: View){
    val intent = Intent(this,ForgotActitivity::class.java)
    startActivity(intent)
}
}
