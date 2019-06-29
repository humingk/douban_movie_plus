package org.humingk.movie.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.sql.SQLException;

/**
 * 用于初始化 c3p0 pool
 *
 * @author humingk
 */
public class DataSourceInitializer implements ApplicationListener<ContextRefreshedEvent> {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ComboPooledDataSource dataSource=event.getApplicationContext().getBean("dataSource",ComboPooledDataSource.class);
        try {
            dataSource.getConnection().close();
            logger.info("dataSource:连接关闭");
        } catch (SQLException e) {
            logger.error("",e);
        }
    }
}