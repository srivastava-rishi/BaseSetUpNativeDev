//package com.rishi.zmovie.network
//
//import com.google.gson.Gson
//import com.google.gson.GsonBuilder
//import okhttp3.Interceptor
//import okhttp3.OkHttpClient
//import okhttp3.Request
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.Date
//
//class ZMovieClient {
//
//    private var retrofit: Retrofit? = null
//    private val okHttpClient: OkHttpClient? = null
//
//    private fun newInstance(
//        appServerUrl: String,
//    ): Retrofit {
//        if (okHttpClient == null) {
//            buildOkHttpClient()
//        }
//        if (retrofit == null) {
//            retrofit = okHttpClient?.let {
//                Retrofit.Builder()
//                    .client(it)
//                    .baseUrl(appServerUrl)
//                    .addConverterFactory(GsonBuilder().create()))
//                    .build()
//            }
//        }
//        return retrofit!!
//    }
//
//    private fun buildOkHttpClient(): OkHttpClient {
//        val headerInterceptor = Interceptor { chain ->
//            val original: Request = chain.request()
//            val request: Request = original.newBuilder()
//                .header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3Y2ZlYzAzYjE0ZDgzOWNlZjBlYjVhOWYyNWMzYWJiZSIsIm5iZiI6MTcyNDUzMzk3Ni4yNzgwODQsInN1YiI6IjYzZjRmYjUwYTI0YzUwMTMzOWUzNDE5OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.3B9zQVognZ8vkrpt3P4aMwJDiPqUKV7jahXbnD9dChk")
//                .header("Accept", "application/json")
//                .build()
//            chain.proceed(request)
//        }
//
//        return OkHttpClient.Builder()
//            .addInterceptor(headerInterceptor)
//            .build()
//    }
//
//    fun getGson(): Gson {
//        val gsonBuilder = GsonBuilder()
//
//        // Register an adapter to manage the date types as long values
//        gsonBuilder.registerTypeAdapter(Date::class.java, WhizDMDateTypeAdapter())
//        gsonBuilder.setLenient()
//        return gsonBuilder.create()
//    }
//
//}