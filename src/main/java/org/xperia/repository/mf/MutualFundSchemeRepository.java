package org.xperia.repository.mf;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xperia.entities.mf.MutualFundScheme;

@Repository
public interface MutualFundSchemeRepository extends JpaRepository<MutualFundScheme, String> {
}
