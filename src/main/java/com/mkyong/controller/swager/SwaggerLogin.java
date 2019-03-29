package com.mkyong.controller.swager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Create By: Ron Rith
 * Create Date on: 3/29/2019.
 */
@Controller
@ApiIgnore
public class SwaggerLogin {
    @RequestMapping(value = "/swagger")
    private String toSwagger(){
        return "/swagger/swagger-ui";
    }
}
