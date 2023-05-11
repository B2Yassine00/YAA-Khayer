package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dto.AssociationResponse;
import com.YAAKHAYRv1.Dto.OffertResponseDto;
import com.YAAKHAYRv1.Dto.PrendreRequest;
import com.YAAKHAYRv1.Dto.PrendreRespondre;
import com.YAAKHAYRv1.Models.Prendre;

import java.util.List;

public interface PrendreService {
    PrendreRespondre save(PrendreRequest prendreRequest);
    List<PrendreRespondre> prendreAll();
    List<OffertResponseDto> prendreByAssociation(Integer id);
    List<AssociationResponse> prendreAssociationByOffer(Integer id_offer);

}
