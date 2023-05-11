package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dao.AssociationDao;
import com.YAAKHAYRv1.Dto.AssociationRequest;
import com.YAAKHAYRv1.Dto.AssociationResponse;
import com.YAAKHAYRv1.Dto.IndividuResponse;
import com.YAAKHAYRv1.Dto.UtilisateurResponseDao;
import com.YAAKHAYRv1.Exception.EntityNotFoundException;
import com.YAAKHAYRv1.Models.Utilisateur;
import com.YAAKHAYRv1.Models.association;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssociationServiceImpl implements AssociationService{
    private final AssociationDao associationDao;
    private ModelMapper modelMapper;

    public AssociationServiceImpl(AssociationDao associationDao, ModelMapper modelMapper) {
        this.associationDao = associationDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public AssociationResponse save(AssociationRequest associationRequest) {
        association association1=modelMapper.map(associationRequest,association.class);
        association saved=associationDao.save(association1);
        AssociationResponse associationResponse=modelMapper.map(saved,AssociationResponse.class);
        return  associationResponse;

    }

    @Override
    public List<AssociationResponse> findAll() {
        return  (List)this.associationDao.findAll().stream().map((el) -> {
            return (AssociationResponse)this.modelMapper.map(el, AssociationResponse.class);
        }).collect(Collectors.toList());
    }

    @Override
    public AssociationResponse update(AssociationRequest associationRequest, Integer id) {
        Optional<association> association1 = this.associationDao.findById(id);
        if (association1.isPresent()) {
            association association2 = (association) this.modelMapper.map(associationRequest, association.class);
            association2.setId(id);
            return (AssociationResponse) this.modelMapper.map(this.associationDao.save(association2), AssociationResponse.class);
        } else {
            throw new EntityNotFoundException("utilistauer not found");
        }
    }

    @Override
    public void delete(Integer id) {
        associationDao.deleteById(id);
    }

    @Override
    public AssociationResponse findById(Integer id) {
        Optional<association> association1=associationDao.findById(id);
        if(association1.isPresent()){
            AssociationResponse associationResponse=modelMapper.map(association1,AssociationResponse.class);
            return  associationResponse;
        }
        else {
            throw  new EntityNotFoundException("NOT FOUND");
        }
    }
}
