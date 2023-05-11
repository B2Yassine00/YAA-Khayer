package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dao.CompagneDao;
import com.YAAKHAYRv1.Dao.DonnerDao;
import com.YAAKHAYRv1.Dao.IndividuDao;
import com.YAAKHAYRv1.Dto.*;
import com.YAAKHAYRv1.Models.Compagne;
import com.YAAKHAYRv1.Models.Donner;
import com.YAAKHAYRv1.Models.Individu;
import com.YAAKHAYRv1.Models.Offert;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DonnerServiceImpl implements DonnerService {
    private final DonnerDao donnerDao;
    private final IndividuDao individuDao;
    private  final CompagneDao compagneDao;
    private ModelMapper modelMapper;

    public DonnerServiceImpl(DonnerDao donnerDao, IndividuDao individuDao, CompagneDao compagneDao, ModelMapper modelMapper) {
        this.donnerDao = donnerDao;
        this.individuDao = individuDao;
        this.compagneDao = compagneDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DonnerResponse> findAllDon() {
        return  (List)this.donnerDao.findAll().stream().map((el) -> {
            return (DonnerResponse)this.modelMapper.map(el, DonnerResponse.class);
        }).collect(Collectors.toList());    }

    //les compagnes que j'ai fait le don
    @Override
    public List<CompagneResponse> findDonByIndividu(Integer individuId) {

        List<Donner> donners=donnerDao.findAllByIndividu(individuId);
        List<CompagneResponse> compagneResponses=new ArrayList<>();
        for(Donner donner:donners){
            Compagne compagne=compagneDao.findById(donner.getId_compagne()).orElse(null);
            CompagneResponse compagneResponse=modelMapper.map(compagne,CompagneResponse.class);
            compagneResponses.add(compagneResponse);
        }
        return compagneResponses;


    }

    @Override
    public List<IndividuResponse> findDonByCompagne(Integer compagneId) {

        List<Donner> donners=donnerDao.findAllByCompagne(compagneId);
        List<IndividuResponse> individuResponses=new ArrayList<>();
        for(Donner donner:donners){
            Individu individu=individuDao.findById(donner.getId_donneur()).orElse(null);
            IndividuResponse individuResponse=modelMapper.map(individu,IndividuResponse.class);
            individuResponses.add(individuResponse);
        }
        return individuResponses;

    }



    @Override
    public DonnerResponse save(DonnerRequest donnerRequest) {
            Donner donner=modelMapper.map(donnerRequest,Donner.class);
            DonnerResponse donnerResponse=modelMapper.map(donnerDao.save(donner),DonnerResponse.class);
            return donnerResponse;

    }
}
