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

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

public class TokenStore {

    private static final String KEY_TOKEN = "token";

    private static TokenStore instance;

    private SharedPreferences preferences;

    public static TokenStore getInstance(Context context) {
        if(instance == null)
            instance = new TokenStore(context);

        return instance;
    }

    private TokenStore(Context context) {
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            String name = ai.metaData.getString("com.github.pockethub.githubsdk.client_id");
            preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getToken(){
        return preferences.getString(KEY_TOKEN, null);
    }

    public void saveToken(String key){
        preferences.edit().putString(KEY_TOKEN, key).apply();
    }


}
