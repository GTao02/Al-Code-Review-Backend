package com.tao.aicodereviewbackend.domain.core.service;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.model.chat.response.ChatResponse;

/**
 * @author GongTao
 * @create 2025-04-24 14:11
 * 代码评审接口
 */
public interface ICodeReviewService {

    ChatResponse review(ChatMessage message);

}
