//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dao.UtilisateurDao;
import com.YAAKHAYRv1.Dto.UtilisateurRequestDao;
import com.YAAKHAYRv1.Dto.UtilisateurResponseDao;
import com.YAAKHAYRv1.Exception.EntityNotFoundException;
import com.YAAKHAYRv1.Models.Utilisateur;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private UtilisateurDao utilisateurDao;
    private ModelMapper modelMapper;

    public UtilisateurServiceImpl(UtilisateurDao utilisateurDao, ModelMapper modelMapper) {
        this.utilisateurDao = utilisateurDao;
        this.modelMapper = modelMapper;
    }

    public UtilisateurResponseDao save(UtilisateurRequestDao utilisateur) {
        Utilisateur utilisateur1 = (Utilisateur)this.modelMapper.map(utilisateur, Utilisateur.class);
        Utilisateur saved = (Utilisateur)this.utilisateurDao.save(utilisateur1);
        return (UtilisateurResponseDao)this.modelMapper.map(saved, UtilisateurResponseDao.class);
    }

    public UtilisateurResponseDao findbylogin(String email, String password) {
        Optional<Utilisateur> utilisateur = this.utilisateurDao.findUtilisateurByLogin(email, password);
        if (utilisateur.isPresent()) {
            return (UtilisateurResponseDao)this.modelMapper.map(utilisateur, UtilisateurResponseDao.class);
        } else {
            throw new EntityNotFoundException("utilistauer not found");
        }
    }

    public UtilisateurResponseDao findById(Integer id) {
        Optional<Utilisateur> utilisateur = this.utilisateurDao.findById(id);
        if (utilisateur.isPresent()) {
            return (UtilisateurResponseDao)this.modelMapper.map(utilisateur, UtilisateurResponseDao.class);
        } else {
            throw new EntityNotFoundException("utilistauer not found");
        }
    }

    public void delete(Integer id) {
        this.utilisateurDao.deleteById(id);
    }

    public UtilisateurResponseDao update(UtilisateurRequestDao utilisateur, Integer id) {
        Optional<Utilisateur> utilisateur1 = this.utilisateurDao.findById(id);
        if (utilisateur1.isPresent()) {
            Utilisateur utilisateur2 = (Utilisateur)this.modelMapper.map(utilisateur, Utilisateur.class);
            utilisateur2.setId(id);
            return (UtilisateurResponseDao)this.modelMapper.map(this.utilisateurDao.save(utilisateur2), UtilisateurResponseDao.class);
        } else {
            throw new EntityNotFoundException("utilistauer not found");
        }
    }

    public List<UtilisateurResponseDao> findAll() {
        return (List)this.utilisateurDao.findAll().stream().map((el) -> {
            return (UtilisateurResponseDao)this.modelMapper.map(el, UtilisateurResponseDao.class);
        }).collect(Collectors.toList());
    }
}
