package com.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/9/1.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")//天氣狀況
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }
}