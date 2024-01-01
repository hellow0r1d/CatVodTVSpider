package com.github.catvod.spider;

import android.content.Context;

import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.utils.okhttp.OkHttpUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Author: Panda
 */
public class Panda extends Spider {

    private String siteUrl = "http://127.0.0.1";
    private String extString = "";

    @Override
    public void init(Context context, String extend) {
        super.init(context);
        this.siteUrl = extend;
    }

    private HashMap<String, String> getHeaders(String url) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Connection", "Keep-Alive");
        headers.put("User-Agent", "okhttp/4.0.1");
        return headers;
    }

    @Override
    public String homeContent(boolean filter) {
        try {
            JSONObject jsonObject = new JSONObject(OkHttpUtil.string(siteUrl + "/home_nav", getHeaders(siteUrl)));

            // JSONObject result = new JSONObject();

            return jsonObject.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }

    @Override
    public String homeVideoContent() {
        try {
            String url = siteUrl + "/home_data";
            JSONObject jsonObject = new JSONObject(OkHttpUtil.string(url, getHeaders(url)));

            // JSONObject result = new JSONObject();

            return jsonObject.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }

    @Override
    public String categoryContent(String tid, String pg, boolean filter, HashMap<String, String> extend) {
        try {
            String url = siteUrl + "/vod_list?page=" + pg + "&id=" + tid;
            Set<String> keys = extend.keySet();
            for (String key : keys) {
                url += "&" + key + "=" + URLEncoder.encode(extend.get(key));
            }
            JSONObject jsonObject = new JSONObject(OkHttpUtil.string(url, getHeaders(url)));

            // JSONObject result = new JSONObject();

            return jsonObject.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }

    @Override
    public String detailContent(List<String> ids) {
        try {
            String url = siteUrl + "/vod_detail?token=&id=" + ids.get(0) + "&ac=vod_detail";
            JSONObject jsonObject = new JSONObject(OkHttpUtil.string(url, getHeaders(url)));

            // JSONObject result = new JSONObject();

            return jsonObject.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }


    @Override
    public String playerContent(String flag, String id, List<String> vipFlags) {
        try {
            JSONObject result = new JSONObject();
            result.put("parse", 0);
            result.put("playUrl", "");
            result.put("url", id);
            return result.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }

    @Override
    public String searchContent(String key, boolean quick) {
        if (quick)
            return "";
        try {
            String url = siteUrl + "/search_result?video_name=" + URLEncoder.encode(key);
            JSONObject jsonObject = new JSONObject(OkHttpUtil.string(url, getHeaders(url)));

            // JSONObject result = new JSONObject();

            return jsonObject.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }
}