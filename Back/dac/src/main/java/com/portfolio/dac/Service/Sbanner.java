package com.portfolio.dac.Service;
import com.portfolio.dac.Entity.banner;
import com.portfolio.dac.Repository.Rbanner;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Sbanner {
    @Autowired
    Rbanner rbanner;
    
    public List<banner> list(){
        return rbanner.findAll();
    }
    
    public Optional<banner> getOne(int id){
        return rbanner.findById(id);
    }
    
    public Optional<banner> getByNmbreE(String nombreE){
        return rbanner.findByNombreE(nombreE);
    }
    
    public void save(banner banner){
        rbanner.save(banner);
    }
    
    public void delete(int id){
        rbanner.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rbanner.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rbanner.existsByNombreE(nombreE);
    }
}