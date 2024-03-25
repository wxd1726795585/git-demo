package com.example.controller;

import com.example.service.AllKindsTestService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2023/6/1
 * \* Description:
 * \* @author 王祥栋
 */
@Slf4j
@RestController
@RequestMapping("/all/kinds")
public class AllKindsTestController {
    @Autowired
    private AllKindsTestService allKindsTestService;

    @PostMapping("/test01")
    public void test01(@RequestParam(value = "name") String name) throws InterruptedException {
        allKindsTestService.asyncTest();
    }

    @PostMapping("/test02")
    public void test02(@RequestBody @Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            String defaultMessage = allErrors.get(0).getDefaultMessage();
            log.info(defaultMessage);
        }
        log.info("进来了......");

    }


}

@Data
class Student {
    @NotBlank(message = "名字不能为空")
    private String name;
}
