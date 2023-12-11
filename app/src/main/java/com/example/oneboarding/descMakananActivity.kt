package com.example.oneboarding

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class descMakananActivity : AppCompatActivity() {
    var jumlah = 0;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desc_makanan)

        var text = findViewById<TextView>(R.id.donasi_jumlah_porsi)

        var tambah = findViewById<Button>(R.id.tambah)
        tambah.setOnClickListener{
            jumlah++
            text.text = jumlah.toString()
        }

        var kurang = findViewById<Button>(R.id.kurang)
        kurang.setOnClickListener{
            jumlah--
            text.text = jumlah.toString()
        }
        val buttonDonasi: Button = findViewById(R.id.donasi)
        buttonDonasi.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Konfirmasi Donasi")
            builder.setMessage("Apakah Anda yakin ingin melakukan donasi?")

            builder.setPositiveButton("Ya") { dialog, which ->
                // Kode yang akan dijalankan jika tombol "Ya" ditekan
                // Tambahkan logika atau aksi yang ingin Anda lakukan saat tombol "Ya" ditekan
//                val intent = Intent(this, detailDonateActivity:: class.java)
//                startActivity(intent)
                onBackPressed()
            }

            builder.setNegativeButton("Tidak") { dialog, which ->
                // Kode yang akan dijalankan jika tombol "Tidak" ditekan
                // Tambahkan logika atau aksi yang ingin Anda lakukan saat tombol "Tidak" ditekan
                onBackPressed()
            }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

    }

    fun back(view: View) {
        onBackPressed()
    }

}