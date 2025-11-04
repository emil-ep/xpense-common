package org.xperia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.xperia.entities.mf.MutualFundSchemeDetail;
import org.xperia.models.MFSchemeDetailSearchUIResponseModel;
import org.xperia.repository.mf.MutualFundSchemeDetailRepository;
import org.xperia.service.MutualFundSchemeDetailService;

import java.util.List;

@Service
public class MutualFundSchemeDetailServiceImpl implements MutualFundSchemeDetailService {

    @Autowired
    private MutualFundSchemeDetailRepository repository;

    @Override
    public List<MutualFundSchemeDetail> saveAll(List<MutualFundSchemeDetail> schemes) {
        if (!schemes.isEmpty()){
            return repository.saveAll(schemes);
        }
        return List.of();
    }

    @Override
    public MutualFundSchemeDetail save(MutualFundSchemeDetail scheme) {
        return null;
    }

    @Override
    public Page<MFSchemeDetailSearchUIResponseModel> fetchDetails(int pageNo, int size, String search) {

        Page<MutualFundSchemeDetail> details;
        Pageable pageable = PageRequest.of(pageNo, size);
        if (search != null && !search.isEmpty()){
            details = repository.findByNameContainingIgnoreCase(search, pageable);
        }else{
            details = repository.findAll(pageable);
        }
        return details.map(scheme -> new MFSchemeDetailSearchUIResponseModel(
                scheme.getCode(),
                scheme.getType(),
                scheme.getCategory(),
                scheme.getFundHouse(),
                scheme.getName(),
                scheme.getGrowth(),
                scheme.getGrowthPercent()
        ));
    }
}
