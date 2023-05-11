package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dto.CompagneRequest;
import com.YAAKHAYRv1.Dto.CompagneResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CompagneServiceImplTest {

    @Autowired
    CompagneServiceImpl compagneService;

    @Test
    void add() {
        CompagneRequest compagneRequest=new CompagneRequest("test","test","test",null,1,0.00,null,1);
        CompagneResponse compagneResponse=compagneService.add(compagneRequest);
        assertEquals(compagneResponse.getTitle(),compagneRequest.getTitle());
    }


    @Test
    void findByAssociation() {
        List<CompagneResponse> compagneResponseList=compagneService.findByAssociation(1);
        assertNotEquals(0,compagneResponseList.size());
    }

}