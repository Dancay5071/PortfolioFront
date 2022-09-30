package com.portfolio.dac.Repository;

import com.portfolio.dac.Entity.banner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rbanner extends JpaRepository<banner, Integer>{
    public Optional<banner> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
