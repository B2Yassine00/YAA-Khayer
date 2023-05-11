package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dao.DonDao;
import com.YAAKHAYRv1.Dto.Donresponse;
import com.YAAKHAYRv1.Dto.IndividuResponse;
import com.YAAKHAYRv1.Exception.EntityNotFoundException;
import com.YAAKHAYRv1.Models.Don;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DonServiceImpl implements DonService{

    @Autowired
    private final DonDao donDao;
    private ModelMapper modelMapper;

    public DonServiceImpl(DonDao donDao, ModelMapper modelMapper) {
        this.donDao = donDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Donresponse> findAll() {
        return  (List)this.donDao.findAll().stream().map((el) -> {
            return (Donresponse)this.modelMapper.map(el, Donresponse.class);
        }).collect(Collectors.toList());
    }

    @Override
    public Donresponse findDonById(int id) {

        Optional <Don> don=donDao.findById(id);
        if(don.isPresent()){
            Donresponse donresponse=modelMapper.map(don,Donresponse.class);
            return  donresponse;
        }
        else{
            throw new EntityNotFoundException("NOT FOUND");
        }

    }
}
