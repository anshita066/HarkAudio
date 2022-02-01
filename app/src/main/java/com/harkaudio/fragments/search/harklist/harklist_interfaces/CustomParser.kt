package com.example.apidemo.interfaces

import android.util.Log
import com.google.gson.Gson
import com.harkaudio.fragments.search.harklist.harklist_dataclasses.Question
import org.json.JSONObject
import kotlin.collections.ArrayList

open class CustomParser{

    //parsing method with parsing logic for com.harkaudio.fragments.search.clips.clips_dataclasses.Question ID

     fun parseQuestion(jsonString:String) : ArrayList<Question>{

     var quesList = ArrayList<Question>()

     if(jsonString.isNotBlank()){
         val jsonObj = JSONObject(jsonString)
         if (jsonObj.has("results")){
             val resultArray = jsonObj.getJSONArray("results")
             for (i in 0 until resultArray.length()){
                 Log.d("QID", " QuesId:${resultArray.get(i).toString()}")
                 val dictObject = jsonObj.getJSONObject("dictionary")
                 val quesObj = dictObject.getJSONObject(resultArray.get(i).toString())
                 val question = Gson().fromJson(quesObj.toString(),Question::class.java)
                 quesList.add(question)
             }
         }
     }
     return quesList

     }


}
