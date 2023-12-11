package com.example.oneboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class descUangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desc_uang)

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