package com.harkaudio.fragments.search.podcasts.podcast_interfaces

import Expected
import android.util.Log
import com.google.gson.Gson
import org.json.JSONObject
import kotlin.collections.ArrayList

open class PodcastParser{

     fun parsePodcast(jsonString:String) : ArrayList<Expected>{

     var podcastList = ArrayList<Expected>()

     if(jsonString.isNotBlank()){
         val jsonObj = JSONObject(jsonString)
         if (jsonObj.has("results")){
             val resultArray = jsonObj.getJSONArray("results")
             for (i in 0 until resultArray.length()){
                 Log.d("QID", " QuesId:${resultArray.get(i).toString()}")
                 val dictObject = jsonObj.getJSONObject("dictionary")
                 val podcastObj = dictObject.getJSONObject(resultArray.get(i).toString())
                 val podcast = Gson().fromJson(podcastObj.toString(),Expected::class.java)
                 podcastList.add(podcast)
             }
         }
     }
     return podcastList

     }


}
