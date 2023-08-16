package com.example.controller;

import com.example.HygResponse;
import com.example.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * \* Created with WXD.
 * \* Date:  2023/8/14
 * \* Description:
 * \* @author 王祥栋
 */
@Slf4j
@RestController
@RequestMapping("/request")
public class RequestController {
    @GetMapping("/getRealIp")
    public HygResponse getRealIp(HttpServletRequest request) {
        String realIp = IpUtil.getRealIp(request);
        return HygResponse.Success(realIp);
    }


}
