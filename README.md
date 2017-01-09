# What is this?

As the project name suggests it's a SDK for GitHub and it's written for Android(/Java). It's built om Retrofit, Auto Value, RxJava and Moshi.

# How do I get it?

Import it with Gradle like this:

<code>compile 'com.github.meisolsson:githubsdk:0.2.0'</code>

#How do I use it?

Firstly we init JodaTimeAndroid
```java
    JodaTimeAndroid.init(this);
```

Next we get a token and add it to the TokenStore
```java
    ServiceGenerator.createAuthService()
            .getToken(request)
            .subscribe(new ObserverAdapter<GitHubToken>() {
                @Override
                public void onError(Throwable e) {
                    //TODO: Handle error
                }

                @Override
                public void onNext(GitHubToken token) {
                    if (token.accessToken() != null) {
                        TokenStore.getInstance(context).saveToken(token);
                    } else if (token.error() != null) {
                        //TODO: Handle error
                    }
                }
            });
```

After saving the token we can start fetching data! (This gets the currently authenticated user)
```java
    Observable<User> observable = ServiceGenerator.createService(context, UserService.class).getUser();
```
