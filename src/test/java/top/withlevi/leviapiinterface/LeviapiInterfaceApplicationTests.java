package top.withlevi.leviapiinterface;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.withlevi.leviapiclientsdk.client.LeviApiClient;
import top.withlevi.leviapiclientsdk.model.User;

import javax.annotation.Resource;

@SpringBootTest
class LeviapiInterfaceApplicationTests {

    @Resource
    private LeviApiClient leviApiClient;

    @Test
    void contextLoads() {
        String xmj1 = leviApiClient.getNameByGet("小米椒");
        String xmj2 = leviApiClient.getNameByPost("崽崽");

        User user = new User();
        user.setUserName("xiaomijiao");

        String xmj3 = leviApiClient.getUsernameByPost(user);

        System.out.println(xmj1);
        System.out.println(xmj2);
        System.out.println(xmj3);
    }

}
