# Send WhatsApp Messages using the SDK

Use this Android SDK to Send WhatsApp Messages using the WhatsApp API

[![](https://jitpack.io/v/myinnos/WhatsApp-Android-SDK.svg)](https://jitpack.io/#myinnos/WhatsApp-Android-SDK) [![MyInnos website](https://img.shields.io/badge/visit-website-red.svg?logo=firefox)](https://www.myinnos.in/) [![](https://jitpack.io/v/jitpack/maven-simple/month.svg)](https://jitpack.io/#myinnos/WhatsApp-Android-SDK) <a href="#"><img alt="Android Language Badge" src="https://badgen.net/badge/OS/Android?icon=https://raw.githubusercontent.com/androiddevnotes/awesome-jetpack-compose-android-apps/master/assets/android.svg&color=3ddc84"/></a>

**Note:** please follow [#medium](https://myinnos.medium.com/send-whatsapp-messages-using-the-android-sdk-dd3b8bb9ab6a) / [#hashnode](https://prabhakarthota.dev/send-whatsapp-messages-using-the-android-sdk) / [#dev.to](https://dev.to/myinnos/send-whatsapp-messages-using-the-android-sdk-129j) article to generate token and other information in fb developer account

![maxresdefault](https://user-images.githubusercontent.com/15339591/170928516-1232e15a-0f8a-485c-bc7b-8e9d572972cf.jpeg)

#### Kindly use the following links to use this library:

In settings.gradle (Project)
```kotlin
dependencyResolutionManagement {
    repositories {
        …….
        maven { url 'https://jitpack.io' }
    }
}
```
And then in the other gradle file(may be your app gradle or your own module library gradle, but never add in both of them to avoid conflict.)
```kotlin	
dependencies {
	implementation 'com.github.myinnos:WhatsApp-SDK:<latest-version>'
}
```
How to use
-----
**Step 2:** implement App Icon Name Changer method : [#Example - MainActivity.kt](https://github.com/myinnos/WhatsApp-Android-SDK/blob/main/app/src/main/java/in/myinnos/whatsappsdk/MainActivity.kt)
```kotlin
WhatsAppInitialization.sendMessage(
                "token", //token
                "version", //ex: v13.0
                "phone_number_id", //ex: 103075932423434
                "customer_phone_number",
                "template_name", //ex: hello_world
                "language_code", //ex: en_US
            ) { wResult ->
                Handler(Looper.getMainLooper()).post {
                    if (wResult?.getMessage() == null) {
                        // failed results
                    } else {
                        // success results
                        Log.d("RESULTS", wResult.getMessage())
                    }
                }
            }
```

##### Any Queries? or Feedback, please let me know by opening a [new issue](https://github.com/myinnos/WhatsApp-Android-SDK/issues/new)!

## Contact
#### Prabhakar Thota
* :globe_with_meridians: Website: [myinnos.in](http://www.myinnos.in "Prabhakar Thota")
* :email: e-mail: contact@myinnos.in
* :mag_right: LinkedIn: [PrabhakarThota](https://www.linkedin.com/in/prabhakarthota "Prabhakar Thota on LinkedIn")
* :thumbsup: Twitter: [@myinnos](https://twitter.com/myinnos "Prabhakar Thota on Twitter")   
* :camera: Instagram: [@prabhakar_t_](https://www.instagram.com/prabhakar_t_/ "Prabhakar Thota on Instagram")   

>⚡ If you appreciate my work, consider buying me a cup of :coffee: to keep me recharged :metal: by [GitHub](https://github.com/sponsors/myinnos) or [PayPal](https://www.paypal.me/fansfolio)

License
-------

    Copyright 2022 MyInnos

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
