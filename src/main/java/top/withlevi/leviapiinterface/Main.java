package top.withlevi.leviapiinterface;

import top.withlevi.leviapiinterface.client.leviClient;
import top.withlevi.leviapiinterface.model.User;

/**
 * Created on 9/21/2023 11:32 AM
 *
 * @author Levi
 */
public class Main {

    public static void main(String[] args) {
        leviClient leviClient = new leviClient();
        String name1 = leviClient.getNameByGet("小米椒");
        String name2 = leviClient.getNameByPost("崽崽");
        User user = new User();
        user.setUserName("椒椒");
        String name3 = leviClient.getUsernameByPost(user);

        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);

    }
}
