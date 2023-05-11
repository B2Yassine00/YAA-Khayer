package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dto.OffertRequestDto;
import com.YAAKHAYRv1.Dto.OffertResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OffertServiceImplTest {

    @Autowired
    OffertServiceImpl offertService;

    @Test
    void save() {
        OffertRequestDto offertRequestDto=new OffertRequestDto("test","test","test",1,1,"test",2);
        OffertResponseDto offertResponseDto=offertService.save(offertRequestDto);
        assertEquals(offertResponseDto.getTitle(),offertRequestDto.getTitle());
    }

    @Test
    void findAllOffert() {
        List<OffertResponseDto> offertResponseDto=offertService.findAllOffert();
        assertNotEquals(offertResponseDto.size(),0);
    }



    @Test
    void findAllTypes() {
        List<String> types=offertService.findAllTypes();
        assertNotEquals(types.size(),0);
    }

}