package com.example.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    
import com.example.beans.Product;    
    
public class ProductDao {    
JdbcTemplate template;    
    
public void setTemplate(JdbcTemplate template) {    
    this.template = template;    
}    
public int save(Product p){    
    String sql="insert into product(name,quantity,price) values('"+p.getName()+"',"+p.getQuantity()+",'"+p.getPrice()+"')";    
    return template.update(sql);    
}    
public int update(Product p){    
    String sql="update product set name='"+p.getName()+"', quantity="+p.getQuantity()+",price='"+p.getPrice()+"' where id="+p.getId()+"";    
    return template.update(sql);    
}    
public int delete(int id){    
    String sql="delete from product where id="+id+"";    
    return template.update(sql);    
}    
public Product getProductById(int id){    
    String sql="select * from product where id=?";    
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Product>(Product.class));    
}    
public List<Product> getProducts(){    
    return template.query("select * from product",new RowMapper<Product>(){    
        public Product mapRow(ResultSet rs, int row) throws SQLException {    
            Product e=new Product();    
            e.setId(rs.getInt(1));    
            e.setName(rs.getString(2));    
            e.setQuantity(rs.getInt(3));    
            e.setPrice(rs.getInt(4));    
            return e;    
        }    
    });    
}    
}   
