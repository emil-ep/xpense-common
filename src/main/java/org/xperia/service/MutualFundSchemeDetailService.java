package org.xperia.service;


import org.xperia.entities.mf.MutualFundSchemeDetail;

import java.util.List;

public interface MutualFundSchemeDetailService {

    List<MutualFundSchemeDetail> saveAll(List<MutualFundSchemeDetail> schemes);

    MutualFundSchemeDetail save(MutualFundSchemeDetail scheme);
}
