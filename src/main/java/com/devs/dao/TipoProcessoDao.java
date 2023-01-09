package com.devs.dao;

import com.devs.model.TipoProcesso;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TipoProcessoDao {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public TipoProcessoDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public int save(TipoProcesso tp){
        String sql = "INSERT INTO tipo_processo (nome) VALUES ('"+tp.getNome()+"')";
        return template.update(sql);
    }

    public TipoProcesso getTipoProcessoId(final Integer id){
        String sql = "Select * from tipo_processo where id = "+id;
        ResultSetExtractor<TipoProcesso> extractor = new ResultSetExtractor<TipoProcesso>() {
            public TipoProcesso extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    String nome = rs.getString("nome");
                    return new TipoProcesso(id,nome);
                }
                return null;
            }
        };
        return template.query(sql,extractor);
    }

    public List<TipoProcesso> list(){
        String sql = "Select * from tipo_processo order by id asc";

        RowMapper<TipoProcesso> rowMapper = new RowMapper<TipoProcesso>() {
            public TipoProcesso mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                return new TipoProcesso(id,nome);
            }
        };
        return template.query(sql,rowMapper);
    }


    public int update(TipoProcesso tp){
        String sql = "update tipo_processo set nome = '"+tp.getNome()+"' where id = "+tp.getId();
        return template.update(sql);
    }

    public int delete(TipoProcesso tp){
        String sql = "delete from tipo_processo where id = "+tp.getId();
        return template.update(sql);
    }

    public List<TipoProcesso> getTipoProcesso(){
        return template.query("select * from tipo_processo",new RowMapper<TipoProcesso>(){
            public TipoProcesso mapRow(ResultSet rs, int row) throws SQLException {
                TipoProcesso tp=new TipoProcesso();
                tp.setId(rs.getInt(1));
                tp.setNome(rs.getString(2));
                return tp;
            }
        });
    }
}
