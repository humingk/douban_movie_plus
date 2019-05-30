package org.humingk.movie;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * junit启动的时候自动加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
                "classpath:spring/spring-*.xml",
        "classpath:mybatis/mybatis-config.xml"})
@WebAppConfiguration
public class baseTest {

}
