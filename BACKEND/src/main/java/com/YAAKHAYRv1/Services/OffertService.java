package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dto.IndividuResponse;
import com.YAAKHAYRv1.Dto.OffertRequestDto;
import com.YAAKHAYRv1.Dto.OffertResponseDto;

import java.util.List;
import java.util.Optional;

public interface OffertService {


    OffertResponseDto save(OffertRequestDto offertRequestDto);
    List<OffertResponseDto> findAllOffert();
    Optional<OffertResponseDto> findOffertById(Integer id);
    OffertResponseDto update(OffertRequestDto offert1,Integer id);
    void delete(Integer id);
    List<OffertResponseDto> findNotTaken();
    List<String> findAllTypes();
    List<OffertResponseDto> findAllByIndividu(IndividuResponse individu);
}
