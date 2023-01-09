package com.devs.dao;

import com.devs.model.Processo;
import com.devs.model.TipoProcesso;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ProcessoDao {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public ProcessoDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public int save(Processo p){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String date = f.format(p.getData_entrada());
        String sql = "insert into processo (numero_processo,data_entrada, valor_recurso, objetivo, tipo_processo_id) " +
                "values("+p.getNumero_processo()+",'"+date+"','"+p.getValor_recurso()+"','"+p.getObjetivo()+"',"+p.getTipoProcessoId()+")";

        return template.update(sql);
    }
    public int update(Processo p){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(p.getData_entrada());

        String sql="update processo set numero_processo="+p.getNumero_processo()+",data_entrada='"+date+"',valor_recurso='" + p.getValor_recurso() +"'," +
                " objetivo='"+p.getObjetivo()+"', tipo_processo_id = "+p.getTipoProcessoId()+" where id="+p.getId();
        return template.update(sql);
    }


    public int delete(Processo p){
        String sql="delete from processo where id="+p.getId()+"";
        return template.update(sql);
    }

    public Processo getProcessoById(int id){
        String sql="select * from processo where id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Processo>(Processo.class));
    }

    public List<Processo> list(){
        String sql = "Select * from processo order by id asc";

        RowMapper<Processo> rowMapper = new RowMapper<Processo>() {
            public Processo mapRow(ResultSet rs, int rowNum) throws SQLException {
                Processo p =  new Processo();
                p.setId(rs.getInt(1));
                p.setNumero_processo(rs.getInt(2));
                p.setData_entrada(rs.getDate(3));
                p.setValor_recurso(rs.getFloat(4));
                p.setObjetivo(rs.getString(5));
                p.setTipoProcessoId(rs.getInt(6));
                p.setTipoProcesso(new TipoProcesso(rs.getInt(7),rs.getString(8)));

                return p;
            }
        };
        return template.query(sql,rowMapper);
    }

    public List<Processo> get(Integer id){
        String sql = "select tp.id, tp.nome from processo p inner join tipo_processo tp on p.tipo_processo_id = tp.id where p.id ="+id;
        RowMapper<Processo> rowMapper = new RowMapper<Processo>() {

            public Processo mapRow(ResultSet rs, int rowNum) throws SQLException {
                Processo p =  new Processo();

                p.setTipoProcesso(new TipoProcesso(rs.getInt(1),rs.getString(2)));

                return p;
            }
        };

        return template.query(sql, rowMapper);

    }

    public List<Processo> getProcesso(){
        return template.query("select p.id,p.numero_processo ,p.data_entrada ,p.valor_recurso ,p.objetivo,tp.id,tp.nome \n" +
                "from processo p inner join tipo_processo tp on tp.id = p.tipo_processo_id",new RowMapper<Processo>(){
            public Processo mapRow(ResultSet rs, int row) throws SQLException {
                Processo p=new Processo();
                p.setId(rs.getInt(1));
                p.setNumero_processo(rs.getInt(2));
                p.setData_entrada(rs.getDate(3));
                p.setValor_recurso(rs.getFloat(4));
                p.setObjetivo(rs.getString(5));

                p.setTipoProcesso(new TipoProcesso(rs.getInt(6),rs.getString(7)));

                return p;
            }
        });

    }
    public List<Processo> getProcessoPorNumero(String numero){
        String sql="select * from processo inner join tipo_processo on tipo_processo.id = processo.tipo_processo_id where numero_processo LIKE '" + numero + "'";
        return template.query(sql,new RowMapper<Processo>(){
            public Processo mapRow(ResultSet rs, int row) throws SQLException {
                Processo p=new Processo();
                p.setId(rs.getInt(1));
                p.setNumero_processo(rs.getInt(2));
                p.setData_entrada(rs.getDate(3));
                p.setValor_recurso(rs.getFloat(4));
                p.setObjetivo(rs.getString(5));
                p.setTipoProcessoId(rs.getInt(6));
                p.setTipoProcesso(new TipoProcesso(rs.getInt(7),rs.getString(8)));
                return p;
            }
        });
    }

    public boolean existsProcessoByNumero(Integer numero){
        List<Processo> list = getProcesso();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumero_processo() == numero){
                return true;
            }
        }
        return false;
    }

}
