package com.github.catvod.spider;

import android.content.Context;
import android.widget.Toast;

import com.github.catvod.crawler.SpiderDebug;

public class Init {
    public static void init(Context context) {
        SpiderDebug.log("自定义爬虫代码加载成功！");
        Toast.makeText(context, "2024-01-21", Toast.LENGTH_SHORT).show();
    }
}
