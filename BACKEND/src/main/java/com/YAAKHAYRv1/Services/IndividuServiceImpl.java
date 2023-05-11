package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dao.IndividuDao;
import com.YAAKHAYRv1.Dto.*;
import com.YAAKHAYRv1.Exception.EntityNotFoundException;
import com.YAAKHAYRv1.Models.Individu;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IndividuServiceImpl implements IndividuService{

    @Autowired
    private final IndividuDao individuDao;
    @Autowired
    private  final  UtilisateurServiceImpl utilisateurService;
    private  final OffertServiceImpl offertService;
    private ModelMapper modelMapper;

    public IndividuServiceImpl(IndividuDao individuDao, UtilisateurServiceImpl utilisateurService, OffertServiceImpl offertService, ModelMapper modelMapper) {
        this.individuDao = individuDao;
        this.utilisateurService = utilisateurService;
        this.offertService = offertService;
        this.modelMapper = modelMapper;
    }


    @Override
    public IndividuResponse findById(Integer id) {
       Optional <Individu> individu =individuDao.findById(id);
       if(individu.isPresent()){
           IndividuResponse individuResponse=modelMapper.map(individu,IndividuResponse.class);
           return  individuResponse;
       }
       else {
           throw new EntityNotFoundException("NOT FOUND");
       }

    }

    @Override
    public List<IndividuResponse> findAll() {
        return  (List)this.individuDao.findAll().stream().map((el) -> {
            return (IndividuResponse)this.modelMapper.map(el, IndividuResponse.class);
        }).collect(Collectors.toList());

    }

    @Override
    public IndividuResponse save(IndividuRequest individuRequest) {
        Individu individu=modelMapper.map(individuRequest,Individu.class);
        Individu saved=individuDao.save(individu);
        IndividuResponse individuResponse=modelMapper.map(saved,IndividuResponse.class);
        return individuResponse;

    }

    @Override
    public List<OffertResponseDto> findallMyOffers(Integer id) {
        Optional<Individu> individu=individuDao.findById(id);
        if(individu.isPresent()){

            IndividuResponse individuResponse=modelMapper.map(individu,IndividuResponse.class);
            return offertService.findAllByIndividu(individuResponse);
        }
        else {
            throw  new EntityNotFoundException("NOT FOUND");
        }


    }

    @Override
    public List<DonnerResponse> findAllMyDon(Integer id) {
        return null;
    }

    @Override
    public DonnerResponse poserUnDon(DonnerRequest donnerRequest) {
        return null;
    }
}
