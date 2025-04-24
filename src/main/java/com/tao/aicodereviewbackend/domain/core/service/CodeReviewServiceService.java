package com.tao.aicodereviewbackend.domain.core.service;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

/**
 * @author GongTao
 * @create 2025-04-24 14:14
 * 代码评审服务
 */
@Service
public class CodeReviewServiceService implements ICodeReviewService {

    private final String systemPrompt = "You are a professional code reviewer, please review the code and give me detailed feedback.";

    @Override
    public ChatResponse review(ChatMessage message) {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();
        ChatResponse response = model.chat(ChatRequest.builder()
                .messages(new SystemMessage(systemPrompt), message)
                .build());
        return response;
    }
}
