package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dto.CompagneResponse;
import com.YAAKHAYRv1.Dto.DonnerRequest;
import com.YAAKHAYRv1.Dto.DonnerResponse;
import com.YAAKHAYRv1.Dto.IndividuResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DonnerServiceImplTest {
    @Autowired
    DonnerServiceImpl donnerService;

    @Test
    void findAllDon() {
        List<DonnerResponse> donnerResponses=donnerService.findAllDon();
        assertNotEquals(0,donnerResponses.size());
    }
    

    @Test
    void findDonByCompagne() {
        List<IndividuResponse> donnerResponses=donnerService.findDonByCompagne(5);
        assertNotEquals(0,donnerResponses.size());
    }

    @Test
    void save() {
        DonnerRequest donnerRequest=new DonnerRequest(2,5,0.00);
        DonnerResponse donnerResponse=donnerService.save(donnerRequest);
        assertEquals(donnerResponse.getId_compagne(),donnerRequest.getId_compagne());
        assertEquals(donnerResponse.getId_donneur(),donnerRequest.getId_donneur());
        assertEquals(donnerResponse.getMontant(),donnerRequest.getMontant());


    }
}