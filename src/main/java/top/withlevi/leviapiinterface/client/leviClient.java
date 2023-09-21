package top.withlevi.leviapiinterface.client;


import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import top.withlevi.leviapiinterface.model.User;

import java.util.HashMap;

/**
 * Created on 9/21/2023 11:16 AM
 *
 * @author Levi
 */
public class leviClient {


    public String getNameByGet(String name) {

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        String result = HttpUtil.get("http://localhost:8123/api/name/", paramMap);
        System.out.println(result);
        return result;
    }


    public String getNameByPost(@RequestParam String name) {

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        String result = HttpUtil.post("http://localhost:8123/api/name/", paramMap);
        System.out.println(result);
        return result;
    }


    public String getUsernameByPost(@RequestBody User user) {


        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post("http://localhost:8123/api/name/user")
                .body(json)
                .execute();
        System.out.println("Status Code: " + httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);

        return result;
    }


}
