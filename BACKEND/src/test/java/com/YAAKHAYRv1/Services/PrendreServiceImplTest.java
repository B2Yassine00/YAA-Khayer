package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dto.PrendreRequest;
import com.YAAKHAYRv1.Dto.PrendreRespondre;
import com.YAAKHAYRv1.Models.Prendre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PrendreServiceImplTest {
    @Autowired
    PrendreServiceImpl prendreService;

    @Test
    void save() {
        PrendreRequest prendreRequest=new PrendreRequest(1,6,0);
        PrendreRespondre prendreRespondre=prendreService.save(prendreRequest);
        assertNotNull(prendreRespondre);
    }

    @Test
    void prendreAll() {
        assertNotEquals(0,prendreService.prendreAll());
    }


}