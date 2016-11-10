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

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class GitHubPaginationInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        if(response.isSuccessful() && response.peekBody(1).string().equals("[")) {
            String json = "{";

            String link = response.header("link");
            if(link != null) {
                String[] links = link.split(",");
                for (String link1 : links) {
                    String[] pageLink = link1.split(";");
                    String page = Uri.parse(pageLink[0].replaceAll("[<>]", "")).getQueryParameter("page");
                    String rel = pageLink[1].replaceAll("\"", "").replace("rel=", "");

                    if (page != null)
                        json += String.format("\"%s\":\"%s\",", rel.trim(), page);
                }
            }

            json += String.format("\"items\":%s}", response.body().string());
            return response.newBuilder().body(ResponseBody.create(response.body().contentType(), json)).build();
        }
        return response;
    }
}
