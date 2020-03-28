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
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;

public class GitHubPaginationInterceptor implements Interceptor {

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        if (response.isSuccessful()) {
            String linkHeader = response.header("link");
            final boolean isArray = response.peekBody(1).string().equals("[");
            String pageJson = null;

            if (linkHeader != null) {
                ArrayList<String> pageItems = new ArrayList<>();
                String[] links = linkHeader.split(",");
                for (String link : links) {
                    String[] pageLink = link.split(";");
                    String page = Uri.parse(pageLink[0].replaceAll("[<>]", "")).getQueryParameter("page");
                    String rel = pageLink[1].replaceAll("\"", "").replace("rel=", "");

                    if (page != null) {
                        pageItems.add(String.format("\"%s\":\"%s\"", rel.trim(), page));
                    }
                }
                if (!pageItems.isEmpty()) {
                    pageJson = TextUtils.join(",", pageItems);
                }
            }

            if (isArray || pageJson != null) {
                MediaType contentType = response.body().contentType();
                Charset charset = contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
                BufferedSource source = response.body().source();
                Buffer newResponse = new Buffer();

                try {
                    source.request(Long.MAX_VALUE);

                    if (isArray) {
                        newResponse.writeString("{\"items\":", charset);
                        newResponse.write(source.getBuffer(), source.getBuffer().size());
                        if (pageJson != null) {
                            newResponse.writeString("," + pageJson, charset);
                        }
                        newResponse.writeString("}", charset);
                    } else {
                        newResponse.write(source.getBuffer(), source.getBuffer().size() - 1);
                        newResponse.writeString("," + pageJson + "}", charset);
                    }
                } finally {
                    Util.closeQuietly(source);
                }
                ResponseBody newBody = ResponseBody.create(contentType, newResponse.size(), newResponse);
                return response.newBuilder().body(newBody).build();
            }
        }
        return response;
    }
}