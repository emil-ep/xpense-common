package org.xperia.service;


import org.springframework.data.domain.Page;
import org.xperia.entities.mf.MutualFundSchemeDetail;
import org.xperia.models.MFSchemeDetailSearchUIResponseModel;

import java.util.List;

public interface MutualFundSchemeDetailService {

    List<MutualFundSchemeDetail> saveAll(List<MutualFundSchemeDetail> schemes);

    MutualFundSchemeDetail save(MutualFundSchemeDetail scheme);

    Page<MFSchemeDetailSearchUIResponseModel> fetchDetails(int pageNo, int size, String search);
}
