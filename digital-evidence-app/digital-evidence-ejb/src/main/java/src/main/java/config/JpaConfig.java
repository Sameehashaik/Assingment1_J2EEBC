package src.main.java.config;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "src.main.java.repository")
@EnableJpaAuditing
public class JpaConfig {

    @Bean
    public DataSource dataSource() throws Exception {
        javax.naming.Context ctx = new javax.naming.InitialContext();
        return (DataSource) ctx.lookup("java:/jdbc/DigitalEvidenceDS");
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("ca.evidence.model");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        
        Properties jpaProps = new Properties();
        jpaProps.put("hibernate.hbm2ddl.auto", "update");
        jpaProps.put("hibernate.show_sql", "true");
        
        emf.setJpaProperties(jpaProps);
        
        return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
