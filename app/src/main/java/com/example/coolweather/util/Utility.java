package com.example.coolweather.util;

import android.text.TextUtils;

import com.example.coolweather.db.City;
import com.example.coolweather.db.County;
import com.example.coolweather.db.County;
import com.example.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/8/31.
 */

public class Utility {
    /*
    解析處理服務器返回的省級數據
     */
    public static boolean handleProvinceResponse(String response){
     if(!TextUtils.isEmpty(response)){
         try {
             JSONArray allProvinces=new JSONArray(response);
             for(int i=0;i<allProvinces.length();i++){
                 JSONObject provinceObject=allProvinces.getJSONObject(i);
                 Province province=new Province();
                 province.setProvinceName(provinceObject.getString("name"));
                 province.setProvinceCode(provinceObject.getInt("id"));
                 province.save();
             }
             return true;
         }catch (JSONException e){
             e.printStackTrace();
         }
     }
     return false;
    }
    public static boolean handleCityResonse(String resonse,int provinceId){
        if(!TextUtils.isEmpty(resonse)){
            try {
                JSONArray allCities=new JSONArray(resonse);
                for (int i=0;i<allCities.length();i++){
                    JSONObject cityObject=allCities.getJSONObject(i);
                    City city=new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }return false;
    }
    public static boolean handleCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCountries=new JSONArray(response);
                for(int i=0;i<allCountries.length();i++){
                    JSONObject countyObject=allCountries.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }return false;
    }
}