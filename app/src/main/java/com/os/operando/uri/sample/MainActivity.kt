package com.os.operando.uri.sample

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.os.operando.uri.sample.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.url.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    val uri = Uri.parse(s.toString())
                    binding.scheme.text = "scheme => " + uri.scheme
                    binding.host.text = "host => " + uri.host
                    binding.path.text = "path => " + uri.path
                    binding.lastPathSegment.text = "lastPathSegment => " + uri.lastPathSegment
                    binding.pathSegments.text = "pathSegments => " + uri.pathSegments.toString()
                    binding.query.text = "query => " + uri.query
                    binding.QueryParameter.text = "getQueryParameter => " + uri.getQueryParameter("os")
                    binding.QueryParameterNames.text = "queryParameterNames => " + uri.queryParameterNames.toString()
                    binding.fragment.text = "fragment => " + uri.fragment
                    binding.SchemeSpecificPart.text = "schemeSpecificPart => " + uri.schemeSpecificPart
                } catch (e: Exception) {
                }
            }
        })

        binding.url.setText("https://google.com/android/test?os=10&color=red#yo")
    }
}