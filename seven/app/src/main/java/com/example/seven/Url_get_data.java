package com.example.seven;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Url_get_data {
    private String title;
    private String shower;
    private String link;

    public Url_get_data(String title, String shower, String link) {
        this.title = title;
        this.shower = shower;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShower() {
        return shower;
    }

    public void setShower(String shower) {
        this.shower = shower;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private void JsonDataGet(String jsonData){
        try{
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONObject jsonObjectData=jsonObject.getJSONObject("data");
            JSONArray jsonArray_Datas=jsonObjectData.getJSONArray("datas");
            for(int i=0;i<jsonData.length();i++){
                JSONObject jsonObjectk=jsonArray_Datas.getJSONObject(i);
                String title=jsonObjectk.getString("title");
                String shower=jsonObjectk.getString("shower");
                String link=jsonObjectk.getString("link");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
