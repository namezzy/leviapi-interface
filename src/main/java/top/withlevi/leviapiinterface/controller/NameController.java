package top.withlevi.leviapiinterface.controller;

import org.springframework.web.bind.annotation.*;
import top.withlevi.leviapiclientsdk.model.User;
import top.withlevi.leviapiclientsdk.utils.SignUtils;


import javax.servlet.http.HttpServletRequest;

/**
 * Created on 9/21/2023 11:07 AM
 *
 * @author Levi
 */

@RestController
@RequestMapping("/name")
public class NameController {


    @GetMapping("/")
    public String getNameByGet(String name) {
        return "Get 你的名字是: " + name;
    }


    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "Post 你的名字是: " + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");


        // todo 实际情况应该要去数据库中进行查询是否已经分配给用户
        if (!accessKey.equals("levi")) {
            throw new RuntimeException("无权限");
        }

        if (Long.parseLong(nonce) > 10000) {
            throw new RuntimeException("无权限");
        }

        // todo 时间和当前时间不能超过5分钟

//        if (timestamp) {
//
//        }

        // todo 实际情况中是从数据库查出 secretKey

        String serverSign = SignUtils.genSign(body, "levi-key");
        if (!sign.equals(serverSign)) {
            throw new RuntimeException("无权限");
        }
        String result = "Post 用户名字是: " + user.getUsername();
        // 调用成功后 次数+1
        return result;
    }
}
