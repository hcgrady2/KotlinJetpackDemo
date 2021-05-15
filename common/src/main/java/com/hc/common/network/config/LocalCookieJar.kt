package com.hc.common.network.config

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

/**
 * Created by hcw  on 2021/5/15
 * 类描述：
 * all rights reserved
 */


/** 2020-02-07
 * 用于持久化的cookieJar实现类
 * internal 修饰类的方法，表示这个类方法只适合当前module使用，如果其他module使用的话，会找不到这个internal方法或者报错。
 */
internal class LocalCookieJar : CookieJar {
    //cookie的本地化存储
    private val cache = mutableListOf<Cookie>()

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        //过期的Cookie
        val invalidCookies: MutableList<Cookie> = ArrayList()
        //有效的Cookie
        val validCookies: MutableList<Cookie> = ArrayList()

        for (cookie in cache) {
            if (cookie.expiresAt < System.currentTimeMillis()) {
                //判断是否过期
                invalidCookies.add(cookie)
            } else if (cookie.matches(url)) {
                //匹配Cookie对应url
                validCookies.add(cookie)
            }
        }

        //缓存中移除过期的Cookie
        cache.removeAll(invalidCookies)

        //返回List<Cookie>让Request进行设置
        return validCookies
    }

    /**
     * 将cookie保存
     */
    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        cache.addAll(cookies)
    }
}
