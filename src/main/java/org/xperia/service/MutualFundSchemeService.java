package org.xperia.service;


import org.xperia.entities.mf.MutualFundScheme;

import java.util.List;
import java.util.Optional;

public interface MutualFundSchemeService {

    void saveAllSchemes(List<MutualFundScheme> schemes);

    Optional<List<MutualFundScheme>> findAllSchemes();
}
