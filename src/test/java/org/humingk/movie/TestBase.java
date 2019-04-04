package org.humingk.movie;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-WishAndSeen,junit
 *
 * 很多测试方法，在测试前需要让程序读入spring-mapper 和 mybatis等配置文件
 * 所以这里就抽离出来一个BaseTest类
 * 只要是测试方法就继承它
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration(locations = {"file:src/main/resources/spring/spring-mapper.xml","file:src/main/resources/spring/spring-service.xml"})

public class TestBase {

}
