# What is this?

As the project name suggests it's a SDK for GitHub and it's written for Android/Java. It's built om Retrofit, Auto Value, RxJava and Moshi.

# How do I get it?

Import it with Gradle like this:

<code>compile 'com.github.meisolsson:githubsdk:0.1.0'</code>

#How do I use it?

````
    Observable<User> observable = ServiceGenerator.createService(context, UserService.class).getUser();
````

This gets the currently authenticated user. 