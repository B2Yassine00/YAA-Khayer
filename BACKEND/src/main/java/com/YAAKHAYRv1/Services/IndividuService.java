package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dto.*;
import com.YAAKHAYRv1.Models.Individu;

import java.util.List;
import java.util.Optional;

public interface IndividuService {

    IndividuResponse findById(Integer id);
    List<IndividuResponse> findAll();
    IndividuResponse save(IndividuRequest individuRequest);
    List<OffertResponseDto> findallMyOffers(Integer id );
    List<DonnerResponse> findAllMyDon(Integer id);

    DonnerResponse poserUnDon(DonnerRequest donnerRequest);











}
