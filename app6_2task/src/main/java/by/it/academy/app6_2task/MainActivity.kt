package by.it.academy.app6_2task

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val PERMISSION_CODE_REQUEST = 112

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ImageThumbnailAdapter
    private val values = mutableListOf<Uri>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFindViewByIds()
        checkPermission()

        recyclerView.layoutManager = GridLayoutManager(this, 3,
                GridLayoutManager.VERTICAL, false)

        adapter = ImageThumbnailAdapter(values)
        recyclerView.adapter = adapter

        adapter.onThumbnailClickListener = {
            intent = Intent(this, FullSizeImageActivity::class.java)
            intent.putExtra("uri", it)
            startActivity(intent)
        }

    }

    private fun getImages() {

        applicationContext.contentResolver.query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null)
                ?.use { cursor ->
                    while (cursor.moveToNext()) {
                        val id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID))
                        values.add(Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "" + id))
                    }
                }
    }

    private fun initFindViewByIds() {
        recyclerView = findViewById(R.id.recyclerView)
    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), PERMISSION_CODE_REQUEST)
        } else {
            getImages()
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_CODE_REQUEST && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            getImages()
        } else {
            Toast.makeText(this, "READ_EXTERNAL_STORAGE permission denied", Toast.LENGTH_SHORT).show()
        }
    }
}