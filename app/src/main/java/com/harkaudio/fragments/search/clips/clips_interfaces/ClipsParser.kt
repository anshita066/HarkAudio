package com.harkaudio.fragments.search.clips.clips_interfaces

import android.util.Log
import com.google.gson.Gson
import com.harkaudio.fragments.search.clips.clips_dataclasses.Answer
import org.json.JSONObject

open class ClipsParser {

    fun parseAnswer(jsonString:String) : ArrayList<Answer>{

        var ansList = ArrayList<Answer>()

        if(jsonString.isNotBlank()){
            val jsonObj = JSONObject(jsonString)
            if (jsonObj.has("results")){
                val resultArray = jsonObj.getJSONArray("results")
                for (i in 0 until resultArray.length()){
                    Log.d("AID", " AnswerId:${resultArray.get(i).toString()}")
                    val dictObject = jsonObj.getJSONObject("dictionary")
                    val ansObj = dictObject.getJSONObject(resultArray.get(i).toString())
                    val answer = Gson().fromJson(ansObj.toString(), Answer::class.java)
                    ansList.add(answer)
                }
            }
        }
        return ansList

    }
}

