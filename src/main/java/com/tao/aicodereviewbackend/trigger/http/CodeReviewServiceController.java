package com.tao.aicodereviewbackend.trigger.http;

import com.tao.aicodereviewbackend.domain.core.service.ICodeReviewService;
import dev.langchain4j.data.message.UserMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GongTao
 * @create 2025-04-24 15:35
 */
@RestController
@RequestMapping("/code")
public class CodeReviewServiceController {

    private final ICodeReviewService codeReviewService;

    public CodeReviewServiceController(ICodeReviewService codeReviewService) {
        this.codeReviewService = codeReviewService;
    }

    @PostMapping("/review")
    public String review(@RequestBody String message) {
        UserMessage userMessage = UserMessage.from(message);
        return codeReviewService.review(userMessage).aiMessage().toString();
    }

}
