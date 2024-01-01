package com.github.catvod.spider;

import android.content.Context;
import android.widget.Toast;

import com.github.catvod.crawler.SpiderDebug;

public class Init {
    public static void init(Context context) {
        SpiderDebug.log("自定义爬虫代码加载成功666！");
        Toast.makeText(context, "1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9", Toast.LENGTH_SHORT).show();
    }
}
