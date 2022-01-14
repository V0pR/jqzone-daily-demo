package com.core.domain.finder;

import com.core.DemoCode.thread.AsyncTaskThreadPoolUtils;
import com.core.DemoCode.thread.RunA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: jq.w
 * @Date: 2021/12/6 10:45
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestA {

    @Test
    public void a(){
        try {
            AsyncTaskThreadPoolUtils.INSTANCE.getInstance().execute(new RunA());
        }catch (Exception e){
            System.err.println("我被e了");
        }
    }
}
