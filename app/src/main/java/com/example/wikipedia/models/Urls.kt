package com.example.wikipedia.models

object Urls {
    val BaseUrl= "https://en.wikipedia.org/w/api.php"

    fun getSearchUrl(term: String, skip: Int, take: Int) : String{
        return BaseUrl + "?action=query" +
                "&formatversion=2" +
                "&generator=prefixsearch" +
                "&gpsearch=$term" +
                "&gpslimit=$take" +
                "&gpsoffset=$skip" +
                "&prop=pageimage|info" +
                "piprop=thumbnail|url" +
                "&pithumbsize=200" +
                "&wbptterms=description" +
                "&format=json" +
                "&inprop=url"

    }

    fun getRandomUrl(take: Int) : String{
        return BaseUrl + "?action=query" +
                "format=json" +
                "&formatversion=2" +
                "&generator=random" +
                "&grnnamespace= 0" +
                "&prop=pageimages|info" +
                "&grnlimit=$take" +
                "&inprop=url" +
                "&pithumbsize=200"

    }



}