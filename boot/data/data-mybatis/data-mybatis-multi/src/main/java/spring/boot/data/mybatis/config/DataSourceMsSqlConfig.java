package spring.boot.data.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "spring.boot.data.mybatis.mapper.mssql", sqlSessionTemplateRef = "msSqlSessionTemplate")
public class DataSourceMsSqlConfig {

    @Bean(name = "msSqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mssql")
    public DataSource msSqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "msSqlSessionFactory")
    public SqlSessionFactory msSqlSessionFactory(@Qualifier("msSqlDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        //  配置文件中指明的xml位置会失效用此方式代替
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/mssql/*.xml"));
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "msSqlTransactionManager")
    public DataSourceTransactionManager msSqlTransactionManager(@Qualifier("msSqlDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "msSqlSessionTemplate")
    public SqlSessionTemplate msSqlSessionTemplate(@Qualifier("msSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
