package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dto.IndividuRequest;
import com.YAAKHAYRv1.Dto.IndividuResponse;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IndividuServiceImplTest {
    @Autowired
    IndividuServiceImpl individuService;

    @Test
    void findById() {
        IndividuResponse individuResponse=individuService.findById(2);
        assertNotNull(individuResponse);
        assertEquals("amine",individuResponse.getName());
        assertEquals("amine@gmail.com",individuResponse.getEmail());
    }

    @Test
    void findAll() {
        List<IndividuResponse> individuResponses=individuService.findAll();
        assertNotEquals(0,individuResponses.size());
    }

    @Test
    void save() {
        IndividuRequest individuRequest=new IndividuRequest("test","test","test@gmail.com","0606060606","test");
        IndividuResponse individuResponse=individuService.save(individuRequest);
        assertEquals(individuRequest.getName(),individuResponse.getName());
    }


}