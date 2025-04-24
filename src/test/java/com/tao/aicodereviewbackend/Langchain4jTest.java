package com.tao.aicodereviewbackend;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author GongTao
 * @create 2025-04-24 14:04
 */
@SpringBootTest
public class Langchain4jTest {

    @Test
    public void test_hello(){
        // String apiKey = System.getenv("OPENAI_API_KEY");
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();
        String answer = model.chat("Say 'Hello World'");
        System.out.println(answer); // Hello World
    }
}
