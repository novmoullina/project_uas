package com.noviam.project_uas


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.detailkuliner.*


class detilobject  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailkuliner)
        if (intent.hasExtra("namanya")){
            val nama : String = this.intent.getStringExtra("namanya").toString()
            val keterangan : String = this.intent.getStringExtra("keterangannya").toString()
            val gambar : String = this.intent.getStringExtra("fotonya").toString()

            setDetil(nama, keterangan, gambar)
        }
    }

    fun setDetil(nama: String, keterangan:String, gambar: String) {
        val requestOp = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        nama.text = nama
        keterangan.text = keterangan
        Glide.with(this)
            .load(gambar)
            .apply(requestOp)
            //.centerCrop()
            .into(gambar_detil)

    }
}
