package com.example.controller;

import com.example.HygResponse;
import com.example.test.TestCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2024/1/12
 * \* Description:
 * \* @author 王祥栋
 */
@Slf4j
@RestController
public class AllTestController {

    /**
     *
     * @param list
     * @return
     */
    @PostMapping("/test/format")
    public HygResponse testFormat(List<String> list) {
        log.info("请求参数:{}", list);
        return HygResponse.Success(list);
    }


    @PostMapping("/test/check")
    public HygResponse testCheck(@RequestBody @Valid TestCheck testCheck) {
        log.info("请求参数:{}", testCheck);
        return HygResponse.Success(testCheck);
    }

}


