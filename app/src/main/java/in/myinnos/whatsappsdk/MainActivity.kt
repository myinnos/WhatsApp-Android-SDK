package `in`.myinnos.whatsappsdk

import `in`.myinnos.whatsappsdk.databinding.ActivityMainBinding
import `in`.myinnos.wpaysdk.WhatsAppInitialization
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);

        binding.btSend.setOnClickListener {

            WhatsAppInitialization.sendMessage(
                "Token", //token
                "version", //v13.0
                "phone_number_id", //103075932423434
                binding.etNumber.text.toString(),
                "template_name", //hello_world
                "language_code", //en_US
            ) { wResult ->

                Handler(Looper.getMainLooper()).post {
                    if (wResult?.getMessage() == null) {
                        Toast.makeText(
                            applicationContext,
                            "something went wrong!",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            applicationContext,
                            wResult.getMessage(),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }
}