package com.alishangtian.blogadmin.controller;

import com.alishangtian.blogadmin.shellutil.ShellUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maoxiaobing
 */
@RestController
@Log4j2
public class WebHookController {
    /**
     * github webhook
     *
     * @param body
     */
    @PostMapping("/github/webhook")
    public void webhook(@RequestBody String body) {
        ShellUtil.execShell();
        log.info("github webhook triggered,body:{}", body);
    }
}
