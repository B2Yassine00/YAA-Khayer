package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dao.AssociationDao;
import com.YAAKHAYRv1.Dao.OffertDao;
import com.YAAKHAYRv1.Dao.PrendreDao;
import com.YAAKHAYRv1.Dto.*;
import com.YAAKHAYRv1.Models.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrendreServiceImpl implements PrendreService{
    private final PrendreDao prendreDao;
    private final AssociationDao associationDao;
    private final OffertDao offertDao;
    private ModelMapper modelMapper;

    public PrendreServiceImpl(PrendreDao prendreDao, AssociationDao associationDao, OffertDao offertDao, ModelMapper modelMapper) {
        this.prendreDao = prendreDao;
        this.associationDao = associationDao;
        this.offertDao = offertDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public PrendreRespondre save(PrendreRequest prendreRequest) {
        Prendre prendre=modelMapper.map(prendreRequest,Prendre.class);
        PrendreRespondre prendreRespondre=modelMapper.map(prendreDao.save(prendre),PrendreRespondre.class);
        return prendreRespondre;
    }

    @Override
    public List<PrendreRespondre> prendreAll() {
        return  (List)this.prendreDao.findAll().stream().map((el) -> {
            return (PrendreRespondre)this.modelMapper.map(el, PrendreRespondre.class);
        }).collect(Collectors.toList());
    }

    //Liste des offres prenes par une association
    @Override
    public List<OffertResponseDto> prendreByAssociation(Integer id) {
        List<Prendre> prendres=prendreDao.findassociations(id);
        List<OffertResponseDto> offertResponseDtos=new ArrayList<>();
        for(Prendre prendre:prendres){
            Offert offert=offertDao.findById(prendre.getId_offert()).orElse(null);
            OffertResponseDto offertResponseDto=modelMapper.map(offert,OffertResponseDto.class);
            offertResponseDtos.add(offertResponseDto);
        }
        return offertResponseDtos;
    }

    //les association qui ont prend une offre
    @Override
    public List<AssociationResponse> prendreAssociationByOffer(Integer id_offer) {
        List<Prendre> prendres=prendreDao.findAllByOffer(id_offer);
        List<AssociationResponse> associationResponses=new ArrayList<>();
        for(Prendre prendre:prendres){
            association association1=associationDao.findById(prendre.getId_association()).orElse(null);
            AssociationResponse associationResponse=modelMapper.map(association1,AssociationResponse.class);
            associationResponses.add(associationResponse);
        }
        return associationResponses;

    }
}
