package com.springJDBCTemplate.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springJDBCTemplate.Model.Emp;
@Transactional(rollbackFor = Exception.class)
@Repository
public class EmpDao {
	@Autowired
	JdbcTemplate template;  
	
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	  
	public List<Emp> getEmployeesByPage(int pageid,int total){  
	    String sql="select * from employee limit "+(pageid-1)+","+total;  
	    return template.query(sql,new RowMapper<Emp>(){  
	        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
	            Emp e=new Emp();  
	            e.setId(rs.getInt(1));  
	            e.setName(rs.getString(2));  
	            e.setSalary(rs.getFloat(3));  
	            return e;  
	        }  
	    });  
	} 
	@Transactional(rollbackFor=Exception.class)
	public int save(Emp p){  
		
	    String sql="insert into employee(Id,Name,Salary) values(?,?,?)"; 
	    int succ=	    template.update(sql,p.getId(),p.getName(),p.getSalary()); // success scenario 1 fail 0
	    
	    if(succ ==1 ){
	    	//insert
	    	 String sql1="insert into info(Id,Address,Phone) values(?,?,?)"; 
	 	       template.update(sql1,p.getId(),p.getAddress(),p.getPhone());
	    }
	    
	    
	    return 1;  
		
	}  
	public int update(Emp p){  
	    String sql="update employee set name='"+p.getName()+"', salary="+p.getSalary()+"where id="+p.getId();  
	    return template.update(sql);  
	}  
	
	@Transactional(rollbackFor=Exception.class)
	public int delete(int id){  
	    String sql="delete from employee where id="+id+"";  
	    return template.update(sql);  
	   /* if(suc==1)
	    {
	    	 String sql1="insert into employee(id,name,salary) values(?,?,?)"; 	
	    	 template.update(sql1,240,"add",2112);
	    }*/
	  
	}  
	
	public Emp getEmpById(int id){  
	    String sql="select * from employee where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));  
	}  
	
	
	
}
