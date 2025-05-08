package com.tao.aicodereviewbackend;

import com.tao.aicodereviewbackend.domain.core.service.ICodeReviewService;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.response.ChatResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author GongTao
 * @create 2025-04-24 15:24
 */
@SpringBootTest
public class CodeReviewServiceTest {

    @Autowired
    private ICodeReviewService codeReviewService;

    @Test
    public void test_review() {
        UserMessage userMessage = UserMessage.from("public ChatResponse review(ChatMessage message) {\n" +
                "        OpenAiChatModel model = OpenAiChatModel.builder()\n" +
                "                .baseUrl(\"http://langchain4j.dev/demo/openai/v1\")\n" +
                "                .apiKey(\"demo\")\n" +
                "                .modelName(\"gpt-4o-mini\")\n" +
                "                .build();\n" +
                "        ChatResponse response = model.chat(ChatRequest.builder()\n" +
                "                .messages(new SystemMessage(systemPrompt), message)\n" +
                "                .build());\n" +
                "        return response;\n" +
                "    } \n" +
                "请使用中文回答");

        ChatResponse response = codeReviewService.review(userMessage);
        System.out.println(response.aiMessage().toString());
    }
}
