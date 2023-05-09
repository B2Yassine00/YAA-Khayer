package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dto.AssociationRequest;
import com.YAAKHAYRv1.Dto.AssociationResponse;

import java.util.List;

public interface AssociationService {

    AssociationResponse save(AssociationRequest associationRequest);
    List<AssociationResponse> findAll();
    AssociationResponse update(AssociationRequest associationRequest,Integer id);
    void delete(Integer id);
    AssociationResponse findById(Integer id);
}
