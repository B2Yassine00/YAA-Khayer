package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dto.CompagneRequest;
import com.YAAKHAYRv1.Dto.CompagneResponse;

import java.util.List;
import java.util.Optional;

public interface CompagneService {

    CompagneResponse add(CompagneRequest compagneRequest);
    Optional<CompagneResponse> findByid(Integer id);

    CompagneResponse update(CompagneRequest compagneRequest,Integer id);
    void delete(Integer id);
    List<CompagneResponse> findAll();

    List<CompagneResponse> findByAssociation(Integer id);

    void colturer(Integer id);
    List<CompagneResponse> findNotColturer();


}
