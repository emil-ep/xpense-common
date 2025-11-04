package org.xperia.repository.mf;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.xperia.entities.mf.MutualFundSchemeDetail;

public interface MutualFundSchemeDetailRepository extends JpaRepository<MutualFundSchemeDetail, String> {

    Page<MutualFundSchemeDetail> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
