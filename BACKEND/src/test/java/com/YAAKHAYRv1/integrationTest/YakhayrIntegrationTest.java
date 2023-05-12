package com.YAAKHAYRv1.integrationTest;


import com.YAAKHAYRv1.Dto.*;
import com.YAAKHAYRv1.Models.Prendre;
import com.YAAKHAYRv1.Services.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class YakhayrIntegrationTest {
    @Autowired
    IndividuServiceImpl individuService;
    @Autowired
    AssociationServiceImpl associationService;
    @Autowired
    OffertServiceImpl offertService;
    @Autowired
    CompagneServiceImpl compagneService;
    @Autowired
    DonnerServiceImpl donnerService;
    @Autowired
    PrendreServiceImpl prendreService;


    @Test
    void IndividuScenario(){
        //create an individu
        IndividuRequest individuRequest=new IndividuRequest("aminetest","aminetest","aminetest@gmail.com","0606060606","aminetest");
        IndividuResponse individuResponse=individuService.save(individuRequest);
        //test if the individu has been created
        assertEquals(individuRequest.getName(),individuResponse.getName());
        //the indicidu will create an offer of laptop for poor students
        OffertRequestDto offertRequestDto=new OffertRequestDto("offerttest","Laptopts TEST","test",0,10,"LaptopTest",individuResponse.getId());
        OffertResponseDto offertResponseDto=offertService.save(offertRequestDto);
        //test if the offert has been created
        assertEquals(offertResponseDto.getTitle(),offertRequestDto.getTitle());
        assertEquals(offertResponseDto.getIndividuId(),individuResponse.getId());

        //create an Association
        AssociationRequest associationRequest=new AssociationRequest("associationtest","associationtest","test@gmail.com","06060606","associationtest","test","associationtest","associationtesttest");
        AssociationResponse associationResponse=associationService.save(associationRequest);
        //test if the assoication has been created
        assertEquals(associationRequest.getName(),associationResponse.getName());

        //the compagne will create a compagne of donation
        CompagneRequest compagneRequest=new CompagneRequest("compagne_test","compagne_test","compagne_test",null,0,1000000.00,null,associationResponse.getId());
        //test if the compagne has been created
        CompagneResponse compagneResponse=compagneService.add(compagneRequest);
        assertEquals(compagneResponse.getTitle(),compagneRequest.getTitle());
        assertEquals(compagneResponse.getAssociationId(),associationResponse.getId());

        //So the individu will give a donnation to this compagne

        DonnerRequest donnerRequest=new DonnerRequest(individuResponse.getId(),compagneResponse.getId(),100000.00);
        DonnerResponse donnerResponse=donnerService.save(donnerRequest);
        //Test if the donnation has been done
        assertEquals(donnerResponse.getId_compagne(),donnerRequest.getId_compagne());
        assertEquals(donnerResponse.getId_donneur(),donnerRequest.getId_donneur());
        assertEquals(donnerResponse.getMontant(),donnerRequest.getMontant());

        //The association will take a part of the offert
        PrendreRequest prendreRequest=new PrendreRequest(associationResponse.getId(),offertResponseDto.getId(),5);
        PrendreRespondre prendreRespondre=prendreService.save(prendreRequest);
        //Test if the association has been taken a part of that offert
        assertNotNull(prendreRespondre);
        assertEquals(prendreRespondre.getId_association(),associationResponse.getId());
        assertEquals(prendreRequest.getId_offert(),offertResponseDto.getId());

    }


}
