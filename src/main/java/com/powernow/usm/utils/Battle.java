package com.powernow.usm.utils;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class Battle {
    static String metamonUrl = "https://metamon-api.radiocaca.com/usm-api/getWalletPropertyList";
    static String battleUrl = "https://metamon-api.radiocaca.com/usm-api/startBattle";
    static String accessToken ="kwy7BX5ri7SGm3wI2kEdNA==";
    static String address = "0xc0836Eddb99E7FF969d304ee356A3a9aA0A97a69";
    // 中级战场 957470  低级战场：186718
    static Integer midToken = 186718;
    // 中级战场：2  低级战场：1
    static Integer battleLevel = 1;

    public static void main(String[] args) {
        HttpResponse response = HttpUtil.createPost(metamonUrl).header("accessToken",accessToken).form("address",address).form("page",1).form("pageSize",100).execute();
        JSONObject jsonObject = JSONObject.parseObject(response.body());
        String metamonList = JSONObject.parseObject(jsonObject.getString("data")).getString("metamonList");
        JSONArray metamonS = JSONArray.parseArray(metamonList);
        for(Object jj:metamonS){
            JSONObject metamon = JSONObject.parseObject(jj.toString());
            int monsterId = metamon.getInteger("id");
            int tear = metamon.getInteger("tear");
            for(int i=0;i<tear;i++){
                HttpResponse battleResp = HttpUtil.createPost(battleUrl).header("accessToken",accessToken).form("address",address).form("monsterA",monsterId).form("monsterB",midToken).form("battleLevel",battleLevel).execute();
                System.out.println(battleResp.body());
            }
        }
    }
}
