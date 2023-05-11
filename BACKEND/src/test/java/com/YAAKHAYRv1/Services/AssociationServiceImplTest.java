package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dto.AssociationRequest;
import com.YAAKHAYRv1.Dto.AssociationResponse;
import com.YAAKHAYRv1.Dto.IndividuRequest;
import com.YAAKHAYRv1.Dto.IndividuResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AssociationServiceImplTest {

    @Autowired
    AssociationServiceImpl associationService;

    @Test
    void save() {
        AssociationRequest associationRequest=new AssociationRequest("test","test","test@gmail.com","06060606","test","test","test","test");
        AssociationResponse associationResponse=associationService.save(associationRequest);
        assertEquals(associationRequest.getName(),associationResponse.getName());
    }



    @Test
    void findById() {
        List<AssociationResponse> associationResponses=associationService.findAll();
        assertNotEquals(0,associationResponses.size());

    }
}