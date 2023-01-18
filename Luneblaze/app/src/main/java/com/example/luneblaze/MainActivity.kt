package com.example.luneblaze

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var imageView: ImageView

    companion object{
        val IMAGE_REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btn_pick_image)
        imageView = findViewById(R.id.imageView)

        button.setOnClickListener {
            pickImageGallery()
            // Press Alt +Entxer
        }
    }


    private  fun pickImageGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            imageView.setImageURI(data?.data)
        }
    }

    //intent work
    fun openSecondActivity(view: View) {
        val intent = Intent(this,MainActivity2::class.java)
        intent.putExtra(MainActivity2.NAME_EXTRA,"msg")
        startActivity(intent)

        Toast.makeText(this, "Next Activity",Toast.LENGTH_SHORT).show()
    }
}