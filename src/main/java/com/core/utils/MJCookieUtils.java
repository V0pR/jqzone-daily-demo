package com.core.utils;

import com.google.common.collect.Lists;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class MJCookieUtils {

    public static Cookie generateCookie(String name, String value, String path, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        return cookie;
    }

    public static Map<String, String> fetchCookieValueMapDefault(HttpServletRequest request, String cookieNames, String defaultValue) {

        Set<String> names = new HashSet(Lists.newArrayList(cookieNames.split(",")));
        Cookie[] cookies = request.getCookies();
        Map map = new HashMap();

        for (Cookie cookie : cookies) {
            if (names.contains(cookie.getName())) {
                map.put(cookie.getName(), cookie.getValue());
                names.remove(cookie.getName());
            }
        }

        for (String name : names) {
            map.put(name, defaultValue);
        }
        return map;
    }
}
