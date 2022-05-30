package `in`.myinnos.wpaysdk.retro

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface WAPI {

    @POST("/{version}/{phoneNumberID}/messages")
    suspend fun sendMessage(
        @Header("Authorization") bearerToken: String,
        @Path("version") version: String,
        @Path("phoneNumberID") phoneNumberID: String,
        @Body requestBody: RequestBody
    ): Response<ResponseBody>

}