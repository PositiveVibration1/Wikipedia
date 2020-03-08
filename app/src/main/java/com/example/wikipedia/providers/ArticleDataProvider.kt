package com.example.wikipedia.providers

import com.example.wikipedia.models.Urls
import com.example.wikipedia.models.WikiResult
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize
import java.io.Reader
import kotlinx.android.synthetic.main.activity_main.*

class ArticleDataProvider {

    init {
        FuelManager.instance.baseHeaders= mapOf("User-Agent" to "Jackson Wikipedia")
    }

    fun search (term: String, skip: Int, take: Int, responseHandler: (result: WikiResult) -> Unit?){
        Urls.getSearchUrl(term, skip, take).httpGet()
            .responseObject(WikipediaDataDeserializer()){_, _,result ->




                val(data, _)= result
                responseHandler.invoke(data as WikiResult)
            }
    }

    fun getRandom(take: Int, responseHandler: (result: WikiResult) -> Unit?){
        Urls.getRandomUrl(take).httpGet()
            .responseObject(WikipediaDataDeserializer()){_, _, result->



                val(data, _)= result
                responseHandler.invoke(data as WikiResult)

            }
    }

    class WikipediaDataDeserializer : ResponseDeserializable<WikiResult> {
        override fun deserialize(reader: Reader): WikiResult? {
            return Gson().fromJson(reader, WikiResult::class.java)}

    }



}