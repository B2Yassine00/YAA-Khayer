package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dto.DonnerResponse;
import com.YAAKHAYRv1.Dto.Donresponse;

import java.util.List;

public interface DonService {

    List<Donresponse> findAll();
    Donresponse findDonById(int id);



}
