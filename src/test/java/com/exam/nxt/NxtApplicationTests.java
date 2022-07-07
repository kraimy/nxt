package com.exam.nxt;

import com.exam.nxt.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class NxtApplicationTests {
    @Resource
    UserServiceImpl service;
    @Test
    void contextLoads() {
        List list=new ArrayList();
        list.add("15515");
        list.add("jjijmk");
        JSONArray jsonArray=new JSONArray(list);
        System.out.println(jsonArray.toString());
    }

}
