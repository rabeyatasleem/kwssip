package com.itecknologi.kwssip


import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.PorterDuffXfermode
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.itecknologi.kwssip.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val REQUEST_IMAGE_CAPTURE = 100
    private val REQUEST_IMAGE_CAPTURE_2 = 101
    private val REQUEST_IMAGE_CAPTURE_3 = 102
    private val REQUEST_IMAGE_CAPTURE_4 = 103
    private val REQUEST_IMAGE_CAPTURE_5 = 104
    var count = 0

//    TODO
//    class LD(layers: Array<Drawable?>) : LayerDrawable(layers) {
//        private val paint = Paint().apply {
//            xfermode = PorterDuffXfermode(PorterDuff.Mode.MULTIPLY)
//        }
//
//        override fun draw(canvas: Canvas) {
//            super.draw(canvas)
//            val count = canvas.saveLayer(null, null)
//
//            for (i in 0 until numberOfLayers) {
//                getDrawable(i)?.draw(canvas)
//                canvas.saveLayer(null, paint)
//            }
//            canvas.restoreToCount(count)
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val sheet = findViewById<View>(R.id.bottomsheet)
        val bottomSheetBehavior = BottomSheetBehavior.from(sheet)


        val imgAngry = sheet.findViewById<ImageView>(R.id.emoji_1) as ImageView


        bottomSheetBehavior.peekHeight = 200
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        blendImages()

        binding.uploadButton.setOnClickListener {
//            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

            val sheet = findViewById<View>(R.id.bottomsheet)
            val bottomSheetBehavior = BottomSheetBehavior.from(sheet)
//            val d = it as BottomSheetDialog

            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

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


    }


//    private fun blendImages() {
//        val bottomSheet = findViewById<View>(R.id.bottomsheet)
////        val imageView = findViewById<ImageView>(R.id.imageView)
//        val drawable1 = AppCompatResources.getDrawable(this, R.drawable.emoji_1)
//        val drawable2 = AppCompatResources.getDrawable(this, R.drawable.emoji_2)
//        val drawable3 = AppCompatResources.getDrawable(this, R.drawable.emoji_3)
//
//        val layerDrawable = LD(arrayOf(drawable1, drawable2, drawable3))
//        imageView.setImageDrawable(layerDrawable)

//        val bottomSheet = findViewById<View>(R.id.bottomsheet)
//        val emoji1 = bottomSheet.findViewById<ImageView>(R.id.emoji_1)
//        val emoji2 = bottomSheet.findViewById<ImageView>(R.id.emoji_2)
//
//        emoji1?.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(this, R.color.blue), PorterDuff.Mode.MULTIPLY)
//        emoji2?.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(this, R.color.teal), PorterDuff.Mode.MULTIPLY)


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            count++
            when (requestCode) {
                REQUEST_IMAGE_CAPTURE -> {
                    val photo = data?.extras?.get("data") as? Bitmap
                    binding.imageView1.setImageBitmap(photo)
                    binding.cardView1.setCardBackgroundColor(
                        ColorStateList.valueOf(
                            ContextCompat.getColor(
                                getApplicationContext(),
                                R.color.teal
                            )
                        )
                    )
                }

                REQUEST_IMAGE_CAPTURE_2 -> {
                    val photo = data?.extras?.get("data") as? Bitmap
                    binding.imageView2.setImageBitmap(photo)
                    binding.cardView2.setCardBackgroundColor(
                        ColorStateList.valueOf(
                            ContextCompat.getColor(
                                getApplicationContext(),
                                R.color.teal
                            )
                        )
                    )
                }

                REQUEST_IMAGE_CAPTURE_3 -> {
                    val photo = data?.extras?.get("data") as? Bitmap
                    binding.imageView3.setImageBitmap(photo)
                    binding.cardView3.setCardBackgroundColor(
                        ColorStateList.valueOf(
                            ContextCompat.getColor(
                                getApplicationContext(),
                                R.color.teal
                            )
                        )
                    )
                }

                REQUEST_IMAGE_CAPTURE_4 -> {
                    val photo = data?.extras?.get("data") as? Bitmap
                    binding.imageView4.setImageBitmap(photo)
                    binding.cardView4.setCardBackgroundColor(
                        ColorStateList.valueOf(
                            ContextCompat.getColor(
                                getApplicationContext(),
                                R.color.teal
                            )
                        )
                    )
                }

                REQUEST_IMAGE_CAPTURE_5 -> {
                    val photo = data?.extras?.get("data") as? Bitmap
                    binding.imageView5.setImageBitmap(photo)
                    binding.cardView5.setCardBackgroundColor(
                        ColorStateList.valueOf(
                            ContextCompat.getColor(
                                getApplicationContext(),
                                R.color.teal
                            )
                        )
                    )
                }

                else -> {
                    Toast.makeText(this, "Try again later", Toast.LENGTH_SHORT).show()
                }
            }

            if (count == 5) {
                binding.uploadButton.visibility = View.VISIBLE
            }
        }
    }

}


