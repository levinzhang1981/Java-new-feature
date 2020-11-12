package com.levinzhang.jdk11;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpClientTest {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, URISyntaxException {
        testSyncGet();
        testAsyncGet();
        testHttp2();
        testPostForm();
    }

    public static void testSyncGet() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.baidu.com"))
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void testAsyncGet() throws ExecutionException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.baidu.com"))
                .build();

        CompletableFuture<String> result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
        System.out.println(result.get());
    }

    public static void testPostForm() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.w3school.com.cn/demo/demo_form.asp"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("name1=value1&name2=value2"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    public static void testHttp2() throws URISyntaxException {
        HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NEVER)
                .version(HttpClient.Version.HTTP_2)
                .build()
                .sendAsync(HttpRequest.newBuilder()
                                .uri(new URI("https://http2.akamai.com/demo"))
                                .GET()
                                .build(),
                        HttpResponse.BodyHandlers.ofString())
                .whenComplete((resp, t) -> {
                    if (t != null) {
                        t.printStackTrace();
                    } else {
                        System.out.println(resp.version());
                        System.out.println(resp.statusCode());
                    }
                }).join();
    }

}
