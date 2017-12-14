package com.springJDBCTemplate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springJDBCTemplate.Model.Emp;
import com.springJDBCTemplate.data.EmpDao;

@RestController
@Transactional(rollbackFor = Exception.class)
public class EmpController {
	
	@Autowired  
    EmpDao dao;  
      
	
   public EmpController( EmpDao dao)
{
	   this.dao=dao;
	   }

   @RequestMapping("/empform")  
   public ModelAndView showform(){  
       return new ModelAndView("empform","command",new Emp());  
   }  
   
	@RequestMapping(value="/viewemp/{pageID}")  
    public ModelAndView edit(@PathVariable("pageID") int pageId){
        int total=5;  
        if(pageId==1){}  
        else{  
        	pageId=(pageId-1)*total+1;  
        }  
        List<Emp> list=dao.getEmployeesByPage(pageId,total);  
          
        return new ModelAndView("viewemp","list",list);
        //return list.toString();
    }  
	
	@RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("emp") Emp emp){  
        dao.save(emp);  
        return new ModelAndView("redirect:/viewemp/1");//will redirect to viewemp request mapping  
    }  
  
	@RequestMapping(value="/editemp/{id}")  
    public ModelAndView edit1(@PathVariable int id){  
        Emp emp=dao.getEmpById(id);  
        return new ModelAndView("empeditform","command",emp);  
    } 
	
	/* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
        dao.delete(id);  
        return new ModelAndView("redirect:/viewemp/1");  
    }  
    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("emp") Emp emp){  
        dao.update(emp);  
        return new ModelAndView("redirect:/viewemp/1");  
    }
    
}
