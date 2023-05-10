package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dto.CompagneResponse;
import com.YAAKHAYRv1.Dto.DonnerRequest;
import com.YAAKHAYRv1.Dto.DonnerResponse;
import com.YAAKHAYRv1.Dto.IndividuResponse;
import com.YAAKHAYRv1.Models.Donner;

import java.util.List;

public interface DonnerService {
    List<DonnerResponse> findAllDon();
    List<CompagneResponse> findDonByIndividu(Integer individuId);
    List<IndividuResponse> findDonByCompagne(Integer compagneId);
    DonnerResponse save(DonnerRequest donnerRequest);


}
