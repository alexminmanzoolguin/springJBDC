package test;

//librerias
import static org.junit.Assert.assertEquals; //para_referenciar_metodos/atributos_que_comprueba

import org.apache.commons.logging.Log;//quita_las_dependencias_en el tiempo_de_compilacion,o_ejecucion_a_cualquier_paquete
import org.apache.commons.logging.LogFactory;//es_la_factoria_de_ojetos_log
import org.junit.Test;//libreria de prueba para la anotacion test
import org.junit.runner.RunWith;//permite disponer de dicho patrón dentro del entorno de la ejecución de tests de JUnit
import org.springframework.beans.factory.annotation.Autowired;//Sustituye la declaración de los atributos del bean en el xml.
import org.springframework.jdbc.core.JdbcTemplate;//permite dividir una funcionalidad en partes reutilizables y realizar una implementación por defecto
import org.springframework.test.context.ContextConfiguration;//puede utilizar para declarar cualquiera de ubicaciones basado en ruta del recurso 
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; //proporciona la funcionalidad del Spring TestContext Framework a las pruebas estándar de JUnit
 
@RunWith(SpringJUnit4ClassRunner.class)//se_crean_tantas_instancias_y_se_ejecutaran_tantas_veces_los_metodos_como_parametros_devolvamos
@ContextConfiguration(locations = {"classpath:DataSourceTest.xml"})//indica_los_ficheros_de_configuracion_de_spring_que_configura_el_contexto_en_el_ambito_de_este_test
public class PruebaJDBC {//es la planilla para hacer el programa prueba

    private static Log logger = LogFactory.getLog("PruebaJDBC");//nos permite crear una nueva instancia de Logger, pero proporciona dos métodos estáticos para obtener un objeto Logger
    @Autowired//como una mega factoria de objetos
    JdbcTemplate jdbcTemplate;//elimina todos los problemas mencionados anteriormente de la API de JDBC. Le proporciona métodos para escribir las consultas directamente, por lo que ahorra mucho trabajo y tiempo

    @Test//dice a JUnit que el public voidmétodo al que está adjunto se puede ejecutar como un caso de prueba
    public void test() {//clase de la anotacion test
        logger.info("Inicio de PruebaJDBC");//se usa para imprimir el mensaje

        int noPersonas = jdbcTemplate.queryForInt("select count(*) from persona");//JDBCTemplate a través del patrón repositorio  y el código es  muy sencillo y se centra en la funcionalidad p/e aqui se centra en consultar las personas.

        logger.info("Numero de personas:" + noPersonas);//imprimir los objetos que estan registrados
        assertEquals(4, noPersonas);//validamos_el_numero_de_personas

        
        logger.info("Fin del PruebaJDBC");//se imprime la salida del mensaje

    }
}
