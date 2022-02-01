package com.harkaudio.fragments.search.profiles.profiles_interfaces

import Member
import android.util.Log
import com.google.gson.Gson
import com.harkaudio.data.Profile
import org.json.JSONObject

open class ProfilesParser{

     fun parseProfiles(jsonString:String) : ArrayList<Member>{

     var profilesList = ArrayList<Member>()

     if(jsonString.isNotBlank()){
         val jsonObj = JSONObject(jsonString)
         if (jsonObj.has("results")){
             val resultArray = jsonObj.getJSONArray("results")
             for (i in 0 until resultArray.length()){
                 Log.d("QID", " QuesId:${resultArray.get(i).toString()}")
                 val dictObject = jsonObj.getJSONObject("dictionary")
                 val profileObj = dictObject.getJSONObject(resultArray.get(i).toString())
                 val profile = Gson().fromJson(profileObj.toString(), Member::class.java)
                 profilesList.add(profile)
             }
         }
     }
     return profilesList

     }


}
