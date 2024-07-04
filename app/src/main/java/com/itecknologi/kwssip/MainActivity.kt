package com.itecknologi.kwssip


import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.itecknologi.kwssip.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val REQUEST_IMAGE_CAPTURE = 100
    private val REQUEST_IMAGE_CAPTURE_2 = 101
    private val REQUEST_IMAGE_CAPTURE_3 = 102
    private val REQUEST_IMAGE_CAPTURE_4 = 103
    private val REQUEST_IMAGE_CAPTURE_5 = 104
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.imageView1.setOnClickListener {
            val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(camera_intent, REQUEST_IMAGE_CAPTURE)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Error" + e.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }

        binding.imageView2.setOnClickListener {
            val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(camera_intent, REQUEST_IMAGE_CAPTURE_2)

        }

        binding.imageView3.setOnClickListener {
            val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(camera_intent, REQUEST_IMAGE_CAPTURE_3)
        }

        binding.imageView4.setOnClickListener {
            val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(camera_intent, REQUEST_IMAGE_CAPTURE_4)
        }

        binding.imageView5.setOnClickListener {
            val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(camera_intent, REQUEST_IMAGE_CAPTURE_5)
        }

        binding.uploadButton.setOnClickListener{
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            count++
            when (requestCode) {
                REQUEST_IMAGE_CAPTURE -> {
                    val photo = data?.extras?.get("data") as? Bitmap
                    binding.imageView1.setImageBitmap(photo)
                    binding.cardView1.setCardBackgroundColor(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.teal)))
                }

                REQUEST_IMAGE_CAPTURE_2 -> {
                    val photo = data?.extras?.get("data") as? Bitmap
                    binding.imageView2.setImageBitmap(photo)
                    binding.cardView2.setCardBackgroundColor(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.teal)))
                }

                REQUEST_IMAGE_CAPTURE_3 -> {
                    val photo = data?.extras?.get("data") as? Bitmap
                    binding.imageView3.setImageBitmap(photo)
                    binding.cardView3.setCardBackgroundColor(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.teal)))
                }

                REQUEST_IMAGE_CAPTURE_4 -> {
                    val photo = data?.extras?.get("data") as? Bitmap
                    binding.imageView4.setImageBitmap(photo)
                    binding.cardView4.setCardBackgroundColor(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.teal)))
                }

                REQUEST_IMAGE_CAPTURE_5 -> {
                    val photo = data?.extras?.get("data") as? Bitmap
                    binding.imageView5.setImageBitmap(photo)
                    binding.cardView5.setCardBackgroundColor(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.teal)))
                }

                else -> {
                Toast.makeText(this, "Try again later", Toast.LENGTH_SHORT).show()
                }
            }

            if (count==5){
                binding.uploadButton.visibility = View.VISIBLE
            }
        }
    }
}


