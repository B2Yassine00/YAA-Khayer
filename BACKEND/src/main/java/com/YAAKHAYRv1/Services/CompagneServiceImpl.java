package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dao.CompagneDao;
import com.YAAKHAYRv1.Dto.CompagneRequest;
import com.YAAKHAYRv1.Dto.CompagneResponse;
import com.YAAKHAYRv1.Dto.OffertResponseDto;
import com.YAAKHAYRv1.Exception.EntityNotFoundException;
import com.YAAKHAYRv1.Models.Compagne;
import com.YAAKHAYRv1.Models.Offert;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompagneServiceImpl implements CompagneService {

    private final CompagneDao compagneDao;
    private ModelMapper modelMapper;

    public CompagneServiceImpl(CompagneDao compagneDao, ModelMapper modelMapper) {
        this.compagneDao = compagneDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public CompagneResponse add(CompagneRequest compagneRequest) {

        Compagne compagne=modelMapper.map(compagneRequest,Compagne.class);
        int id;
        if(compagneDao.nextid()==null)id=0;
        else id=compagneDao.nextid()+1;
        compagne.setId(id);
        Compagne saved=compagneDao.save(compagne);
        CompagneResponse compagneResponse=modelMapper.map(saved,CompagneResponse.class);
        if(compagneResponse==null) throw new EntityNotFoundException("NOT FOUND");
        else return  compagneResponse;

    }

    @Override
    public Optional<CompagneResponse> findByid(Integer id) {
        Optional<Compagne> compagne=compagneDao.findById(id);
        if(compagne.isPresent()){
            CompagneResponse compagneResponse=modelMapper.map(compagne,CompagneResponse.class);
            return Optional.ofNullable(compagneResponse);
        }
        else {
            throw new EntityNotFoundException("NOT FOUND");
        }
    }

    @Override
    public CompagneResponse update(CompagneRequest compagneRequest, Integer id) {
        Optional <Compagne> compagne=compagneDao.findById(id);
        if(compagne.isPresent()){
            Compagne compagne1=modelMapper.map(compagneRequest,Compagne.class);
            compagne1.setId(id);
            CompagneResponse compagneResponse=modelMapper.map(compagneDao.save(compagne1),CompagneResponse.class);
            return compagneResponse;
        }
        else {
            throw new EntityNotFoundException("NOT FOUND");
        }

    }

    @Override
    public void delete(Integer id) {
        compagneDao.deleteById(id);
    }

    @Override
    public List<CompagneResponse> findAll() {
        return  (List)this.compagneDao.findAll().stream().map((el) -> {
            return (CompagneResponse)this.modelMapper.map(el, CompagneResponse.class);
        }).collect(Collectors.toList());    }

    @Override
    public List<CompagneResponse> findByAssociation(Integer id) {
        return  (List)this.compagneDao.findAllByAssociation(id).stream().map((el) -> {
            return (CompagneResponse)this.modelMapper.map(el, CompagneResponse.class);
        }).collect(Collectors.toList());
    }

    @Override
    public void colturer(Integer id) {
        Optional<Compagne> compagne=compagneDao.findById(id);
        if(compagne.isPresent()){
            CompagneResponse compagneResponse=modelMapper.map(compagne,CompagneResponse.class);
            compagneResponse.setEtat(1);
            Compagne compagne2=modelMapper.map(compagneResponse,Compagne.class);
            compagneDao.save(compagne2);
        }
        else {
            throw  new EntityNotFoundException("NOT FOUND");
        }
    }

    @Override
    public List<CompagneResponse> findNotColturer() {
        return  (List)this.compagneDao.findNotColturer().stream().map((el) -> {
            return (CompagneResponse)this.modelMapper.map(el, CompagneResponse.class);
        }).collect(Collectors.toList());
    }
}
