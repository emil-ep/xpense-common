package org.xperia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xperia.entities.mf.MutualFundScheme;
import org.xperia.repository.mf.MutualFundSchemeRepository;
import org.xperia.service.MutualFundSchemeService;

import java.util.List;

@Service
public class MutualFundSchemeServiceImpl implements MutualFundSchemeService {

    @Autowired
    private MutualFundSchemeRepository mfSchemeRepository;

    @Override
    public void saveAllSchemes(List<MutualFundScheme> schemes) {
        mfSchemeRepository.saveAll(schemes);
    }
}
