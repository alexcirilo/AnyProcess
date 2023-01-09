import com.devs.dao.TipoProcessoDao;
import com.devs.model.TipoProcesso;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class TipoProcessoDaoTest {

    private void getConnection(){
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.17.0.2:3306/anyprocess");
        dataSource.setUsername("root");
        dataSource.setPassword("qwe123");
        dao = new TipoProcessoDao(dataSource);
    }
    private DriverManagerDataSource dataSource;
    private TipoProcessoDao dao;
    @Test
    void testSave() {
        getConnection();
        TipoProcesso tipoProcesso = new TipoProcesso("Tipo Processo Test");
        int result = dao.save(tipoProcesso);

        assertTrue(result > 0);
    }
    @Test
    void testGet(){
        getConnection();
        Integer id = 1;
        TipoProcesso tipoProcesso = dao.getTipoProcessoId(id);
        if(tipoProcesso != null){
            System.out.println(tipoProcesso);
        }

        assertNotNull(tipoProcesso);
    }
    @Test
    void testList(){
        getConnection();
        List<TipoProcesso> list = dao.list();

        for (TipoProcesso processo : list){
            System.out.println(processo);
        }

        assertFalse(list.isEmpty());
    }

    @Test
    void testEdit(){
        getConnection();
        TipoProcesso processo = new TipoProcesso(1,"Teste Tipo Processo Edit");
        int result = dao.update(processo);

        assertTrue(result >0);
    }



}
