
package com.portfolio.dac.Controller;

import com.portfolio.dac.Dto.dtobanner;
import com.portfolio.dac.Entity.banner;
import com.portfolio.dac.Security.Controller.Mensaje;
import com.portfolio.dac.Service.Sbanner;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banner")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins ="https://frontenddac.web.app/")

public class Cbanner {
    @Autowired
    Sbanner sbanner;
    
    @GetMapping("/lista")
    public ResponseEntity<List<banner>> list(){
        List<banner> list = sbanner.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<banner> getById(@PathVariable("id")int id){
        if(!sbanner.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        banner banner = sbanner.getOne(id).get();
        return new ResponseEntity(banner, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sbanner.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sbanner.delete(id);
        return new ResponseEntity(new Mensaje("información eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtobanner dtobanner){
        if(StringUtils.isBlank(dtobanner.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sbanner.existsByNombreE(dtobanner.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        banner banner = new banner(
                dtobanner.getNombreE(), dtobanner.getDescripcionE()
            );
        sbanner.save(banner);
        return new ResponseEntity(new Mensaje("información creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtobanner dtobanner){
        if(!sbanner.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sbanner.existsByNombreE(dtobanner.getNombreE()) && sbanner.getByNmbreE(dtobanner.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtobanner.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        banner banner = sbanner.getOne(id).get();
        
        banner.setNombreE(dtobanner.getNombreE());
        banner.setDescripcionE(dtobanner.getDescripcionE());
        
        sbanner.save(banner);
        
        return new ResponseEntity(new Mensaje("Información actualizada"), HttpStatus.OK);
    }
}