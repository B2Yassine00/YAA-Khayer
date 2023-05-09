package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dao.IndividuDao;
import com.YAAKHAYRv1.Dao.OffertDao;
import com.YAAKHAYRv1.Dto.*;
import com.YAAKHAYRv1.Exception.EntityNotFoundException;
import com.YAAKHAYRv1.Models.Individu;
import com.YAAKHAYRv1.Models.Offert;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OffertServiceImpl implements  OffertService{

    @Autowired
    private final OffertDao offertDao;
    private final IndividuDao individuDao;
    private ModelMapper modelMapper;

    public OffertServiceImpl(OffertDao offertDao, IndividuDao individuDao, ModelMapper modelMapper) {
        this.offertDao = offertDao;
        this.individuDao = individuDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public OffertResponseDto save(OffertRequestDto offertRequestDto) {

        Offert offert=modelMapper.map(offertRequestDto,Offert.class);
        Offert saved=offertDao.save(offert);
        OffertResponseDto offertResponseDto=modelMapper.map(saved,OffertResponseDto.class);
        if(offertResponseDto==null) throw new EntityNotFoundException("NOT FOUND");
        else return  offertResponseDto;

    }

    @Override
    public List<OffertResponseDto> findAllOffert() {
        return offertDao.findAllO();

    }

    @Override
    public Optional<OffertResponseDto> findOffertById(Integer id) {
        Optional <OffertResponseDto> offert=offertDao.findByid(id);
        if (offert.isPresent()){
            return offert;
        }
        else{
            throw new EntityNotFoundException("OFFERT not found");
        }
    }

    @Override
    public OffertResponseDto update(OffertRequestDto offert1, Integer id) {
        Optional<OffertResponseDto> offert=offertDao.findByid(id);
        if(offert.isPresent()){
            Offert offert2=modelMapper.map(offert1,Offert.class);
            offert2.setId(id);
            OffertResponseDto offertResponseDto=modelMapper.map(offertDao.save(offert2),OffertResponseDto.class);
            return offertResponseDto;
        }
        else{
            throw new EntityNotFoundException("NOT FOUND");
        }
    }

    @Override
    public void delete(Integer id) {
        offertDao.deleteById(id);

    }

    @Override
    public List<OffertResponseDto> findNotTaken() {
        return  (List)this.offertDao.findNottaken().stream().map((el) -> {
            return (OffertResponseDto)this.modelMapper.map(el, OffertResponseDto.class);
        }).collect(Collectors.toList());

    }

    @Override
    public List<String> findAllTypes() {
        return offertDao.findAllTypes();
    }

    @Override
    public List<OffertResponseDto> findAllByIndividu(IndividuResponse individu) {
        Individu individu1=modelMapper.map(individu,Individu.class);
        List<Offert> offertList=offertDao.findAllByIndividu(individu1);
        return  (List)this.offertDao.findAllByIndividu(individu1).stream().map((el) -> {
            return (OffertResponseDto)this.modelMapper.map(el, OffertResponseDto.class);
        }).collect(Collectors.toList());
    }
}
