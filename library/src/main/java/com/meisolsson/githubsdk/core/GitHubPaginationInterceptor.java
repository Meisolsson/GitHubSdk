/*
 * Copyright 2015 Henrik Olsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.meisolsson.githubsdk.core;

import android.net.Uri;
import android.text.TextUtils;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class GitHubPaginationInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        if (response.isSuccessful()) {
            String linkHeader = response.header("link");
            final boolean isArray = response.peekBody(1).string().equals("[");
            final ArrayList<String> pageJson;

            if (linkHeader != null) {
                pageJson = new ArrayList<>();
                String[] links = linkHeader.split(",");
                for (String link : links) {
                    String[] pageLink = link.split(";");
                    String page = Uri.parse(pageLink[0].replaceAll("[<>]", "")).getQueryParameter("page");
                    String rel = pageLink[1].replaceAll("\"", "").replace("rel=", "");

                    if (page != null)
                        pageJson.add(String.format("\"%s\":\"%s\"", rel.trim(), page));
                }
            } else {
                pageJson = null;
            }

            final boolean hasPageInfo = pageJson != null && !pageJson.isEmpty();
            if (isArray || hasPageInfo) {
                final String json;
                if (isArray) {
                    json = String.format("{%s%s\"items\":%s}",
                            hasPageInfo ? TextUtils.join(",", pageJson) : "",
                            hasPageInfo ? ", " : "",
                            response.body().string());
                } else {
                    json = String.format("{%s, %s",
                            TextUtils.join(", ", pageJson),
                            response.body().string().substring(1));
                }
                return response.newBuilder().body(ResponseBody.create(response.body().contentType(), json)).build();
            }
        }
        return response;
    }
}