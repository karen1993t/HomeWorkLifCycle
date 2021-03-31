package com.calcuate.implicitintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.core.app.ShareCompat

private  lateinit var mWebsiteEditText:EditText
private  lateinit var mLocationEditText:EditText
private  lateinit var mShareTextEditText:EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWebsiteEditText = findViewById(R.id.website_editText)
        mLocationEditText = findViewById(R.id.location_editText)
        mShareTextEditText = findViewById(R.id.share_editText)
    }

    fun openWebsite(view: View) {
        val url = mWebsiteEditText.text.toString()

        val webPage:Uri = Uri.parse(url)
        intent = Intent(Intent.ACTION_VIEW,webPage)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Log.d("ImplicitIntents","Can not handle this !")
        }
    }

    fun openLocation(view: View) {
       val loc = mLocationEditText.text.toString()
        val addressUri = Uri.parse("geo:0,0?q= $loc")
        val intent = Intent(Intent.ACTION_VIEW,addressUri)
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Log.d("ImplicitIntents","Can not handle this intent")
        }
    }

    fun shareText(view: View) {
      val  txt = mShareTextEditText.text.toString()
      val  mimeType = "text/plain"
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setText("Share this text with")
                .setText(txt)
                .startChooser()
    }

    fun capturePicture(view: View) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }

}