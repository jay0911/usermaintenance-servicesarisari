package com.sarisari;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sarisari.lambda.PropertiesGetter;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class HibernateConfig {
	
	@Value("${db.password}")
    String PROPERTY_NAME_DB_PASSWORD;
    
	@Value("${db.username}")
	String PROPERTY_NAME_DB_USERNAME;
	
	@Value("${db.url}")
    String PROPERTY_NAME_DB_URL;
	
	@Value("${db.driver}")
    String PROPERTY_NAME_DB_DRIVER;
    
	@Value("${hbm.dialect}")
	String PROPERTY_NAME_HBM_DIALECT;
	
	@Value("${hbm.showsql}")
	String PROPERTY_NAME_HBM_SHOWSQL;
	
	@Value("${hbm.formatsql}")
	String PROPERTY_NAME_HBM_FORMAL_SQL;
    
	@Value("${hbm.packagetoscan}")
    String PROPERTY_NAME_HBM_PACKAGE_TO_SCAN;

	@Bean("dataSourceBean")
	public DriverManagerDataSource dataSourceBean(){
		DriverManagerDataSource	dataSourceBean = new DriverManagerDataSource();
		dataSourceBean.setDriverClassName(PROPERTY_NAME_DB_DRIVER);
		dataSourceBean.setUsername(PROPERTY_NAME_DB_USERNAME);
		dataSourceBean.setPassword(PROPERTY_NAME_DB_PASSWORD);
		dataSourceBean.setUrl(PROPERTY_NAME_DB_URL);				
		return dataSourceBean;
	}
	
	@Bean("sessionFactory")
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		PropertiesGetter p =  props();
		sessionFactory.setHibernateProperties(p.getProps());
		sessionFactory.setDataSource(dataSourceBean());
		sessionFactory.setPackagesToScan(new String[] { PROPERTY_NAME_HBM_PACKAGE_TO_SCAN });
		return sessionFactory;
	}
	
	@Bean("transactionManager")
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
	
	private PropertiesGetter props(){
		return ()->getProperties();
	}
	
	private Properties getProperties(){
		Properties p = new Properties();
		p.setProperty(AvailableSettings.DIALECT, PROPERTY_NAME_HBM_DIALECT);
		p.setProperty(AvailableSettings.SHOW_SQL, PROPERTY_NAME_HBM_SHOWSQL);
		p.setProperty(AvailableSettings.FORMAT_SQL, PROPERTY_NAME_HBM_FORMAL_SQL);
		return p;
	}
	
}
