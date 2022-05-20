package test;


import static org.junit.Assert.assertEquals; 

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:DataSourceTest.xml"})
public class PruebaJDBC {

    private static Log logger = LogFactory.getLog("PruebaJDBC");
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        logger.info("Inicio de PruebaJDBC");

        int noPersonas = jdbcTemplate.queryForInt("select count(*) from persona");

        logger.info("Numero de personas:" + noPersonas);

        assertEquals(4, noPersonas);

        logger.info("Fin del PruebaJDBC");

    }
}
