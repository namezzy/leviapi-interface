package top.withlevi.leviapiinterface.controller;

import org.springframework.web.bind.annotation.*;
import top.withlevi.leviapiinterface.model.User;

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
    public String getUsernameByPost(@RequestBody User user) {
        return "Post 用户名字是: " + user.getUserName();
    }
}
