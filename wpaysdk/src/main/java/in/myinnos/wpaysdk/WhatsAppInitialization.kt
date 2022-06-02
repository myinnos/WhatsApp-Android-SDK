package `in`.myinnos.wpaysdk

import `in`.myinnos.wpaysdk.model.WResults
import `in`.myinnos.wpaysdk.retro.RetrofitHelper
import `in`.myinnos.wpaysdk.retro.WAPI
import android.util.Log
import androidx.annotation.NonNull
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject


class WhatsAppInitialization {

    @DelicateCoroutinesApi
    companion object {
        fun sendMessage(
            @NonNull bearerToken: String,
            @NonNull version: String,
            @NonNull phoneNumberID: String,
            @NonNull toPhoneNumber: String,
            @NonNull templateName: String,
            @NonNull languageCode: String,
            @NonNull callback: (wResult: WResults?) -> Unit
        ) {
            val wPayAPI = RetrofitHelper.getInstance().create(WAPI::class.java)

            // Create JSON using JSONObject
            val jsonObject = JSONObject()
            jsonObject.put("messaging_product", "whatsapp")
            jsonObject.put("to", toPhoneNumber)
            jsonObject.put("type", "template")

            val jsonTemplateObject = JSONObject()
            jsonTemplateObject.put("name", templateName)
            val jsonLanguageObject = JSONObject()
            jsonLanguageObject.put("code", languageCode)
            jsonTemplateObject.put("language", jsonLanguageObject)

            jsonObject.put("template", jsonTemplateObject)

            // Convert JSONObject to String
            val jsonObjectString = jsonObject.toString()
            // Create RequestBody ( We're not using any converter, like GsonConverter, MoshiConverter e.t.c, that's why we use RequestBody )
            val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())
            //Log.d("WHATSAPP_SDK", jsonObjectString)

            GlobalScope.launch {
                val result = wPayAPI.sendMessage(
                    "Bearer $bearerToken",
                    version,
                    phoneNumberID,
                    requestBody
                )
                //Log.d("WHATSAPP_SDK", result.raw().request.url.toString())
                //Log.d("WHATSAPP_SDK", result.raw().request.headers.toString())
                Log.d("WHATSAPP_SDK", "RESPONSE_CODE: ${result.code()}")

                val wResults = WResults()
                if (result.code() == 400) {
                    val jsonObj = JSONObject(result.errorBody()!!.charStream().readText())
                    Log.d("WHATSAPP_SDK", "ERROR_MESSAGE: $jsonObj")
                    wResults.setMessage("MESSAGE SENT FAILED: CHECK THE LOGS")
                } else {
                    Log.d("WHATSAPP_SDK", "MESSAGE_SENT")
                    wResults.setMessage("MESSAGE SUCCESSFULLY SENT!")
                }

                callback(wResults)
            }
        }
    }
}