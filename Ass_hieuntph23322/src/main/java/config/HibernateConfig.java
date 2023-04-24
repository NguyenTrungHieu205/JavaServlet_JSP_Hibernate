package config;

import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateConfig {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties properties = new Properties();
                properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2008Dialect");
                properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
                properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
                properties.put(Environment.USER, "sa");
                properties.put(Environment.PASS, "123456");
                properties.put(Environment.SHOW_SQL, "true");

                configuration.setProperties(properties);

                configuration.addAnnotatedClass(ChiTietSanPham.class);
                configuration.addAnnotatedClass(KhachHang.class);
                configuration.addAnnotatedClass(ChucVu.class);
                configuration.addAnnotatedClass(CuaHang.class);
                configuration.addAnnotatedClass(DongSanPham.class);
                configuration.addAnnotatedClass(MauSac.class);
                configuration.addAnnotatedClass(NhanVien.class);
                configuration.addAnnotatedClass(NSX.class);
                configuration.addAnnotatedClass(SanPham.class);


                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void main(String[] args) {
        getSessionFactory();
    }
}

