package com.whj.springbootcode.api.v1;

import com.whj.springbootcode.dto.TokenGetDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class TokenController {
    @PostMapping("")
    public Map<String,String> getToken(
            @RequestBody
            @Validated
            TokenGetDTO userData
    ){
        Map<String,String> map = new HashMap<>();
        String token = null;
        map.put("name","whj");
        map.put("status","ok");
        return map;
    }
}
