import com.devs.dao.ProcessoDao;
import com.devs.dao.TipoProcessoDao;
import com.devs.model.Processo;
import com.devs.model.TipoProcesso;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class ProcessoDaoTest {
    private DriverManagerDataSource dataSource;
    ProcessoDao dao;
    private void getConnection(){
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.17.0.2:3306/anyprocess");
        dataSource.setUsername("root");
        dataSource.setPassword("qwe123");
        dao = new ProcessoDao(dataSource);
    }
    @Test
    public void testGet() {
        getConnection();
        Integer id = 4;
        List<Processo> contact = dao.get(id);

        if (contact != null) {
            System.out.println(contact);
        }
        assertNotNull(contact);

    }

}
