package com.example.wanandroid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonAnalyze {

    protected void JsonDataGet_web(String jsonData, List<WebData> list) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONObject jsonObjectData = jsonObject.getJSONObject("data");
            JSONArray jsonArray_Datas = jsonObjectData.getJSONArray("datas");
            for (int i = 0; i < jsonData.length(); i++) {
                JSONObject jsonObjectk = jsonArray_Datas.getJSONObject(i);
                String link = jsonObjectk.getString("link");
                String name = jsonObjectk.getString("name");
                String category = jsonObjectk.getString("category");
                list.add(new WebData(category,link,name));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void JsonDataGet_article(String jsonData, List<UsefulData> list) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray_Data = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonData.length(); i++) {
                JSONObject jsonObjectk = jsonArray_Data.getJSONObject(i);
                String title = jsonObjectk.getString("title");
                String niceDate = jsonObjectk.getString("niceDate");
                String link = jsonObjectk.getString("link");
                String shareUser = jsonObjectk.getString("shareUser");
                String desc = jsonObjectk.getString("desc");
                String author = jsonObjectk.getString("author");
                String chapterName= jsonObjectk.getString("chapterName");
                String superChapterName= jsonObjectk.getString("superChapterName");
                String projectLink= jsonObjectk.getString("projectLink");
                int id= jsonObjectk.getInt("id");
                list.add(new UsefulData(title,niceDate,link,shareUser,desc,author,chapterName,superChapterName,projectLink,id));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
