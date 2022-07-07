package com.exam.nxt;

import com.exam.nxt.common.GenerateId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
    public void main() {
        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.forEach(val-> System.out.println(val));
    }
}
