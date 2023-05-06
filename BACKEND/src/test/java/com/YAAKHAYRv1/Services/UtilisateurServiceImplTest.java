package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dto.UtilisateurRequestDao;
import com.YAAKHAYRv1.Dto.UtilisateurResponseDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class UtilisateurServiceImplTest {

    private final UtilisateurServiceImpl utilisateurService;

    @Autowired
    UtilisateurServiceImplTest(UtilisateurServiceImpl utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Test
    void save() {
        UtilisateurRequestDao utilisateur=new UtilisateurRequestDao("imad","imad","imad@gmail.com","0606060606");
        UtilisateurResponseDao utilisateurResponseDao=utilisateurService.save(utilisateur);
        assertNotNull(utilisateurResponseDao);
        assertNotNull(utilisateurResponseDao.getId());
        assertEquals(utilisateurResponseDao.getName(),utilisateur.getName());
        assertEquals(utilisateurResponseDao.getPassword(),utilisateur.getPassword());
        assertEquals(utilisateurResponseDao.getEmail(),utilisateur.getEmail());
        assertEquals(utilisateurResponseDao.getNumero(),utilisateur.getNumero());
    }

    @Test
    void findbylogin(){
        UtilisateurResponseDao utilisateur1=utilisateurService.findbylogin("amine@gmail.com","amine");
        assertNotNull(utilisateur1);
        assertEquals(1,utilisateur1.getId());
        assertEquals("amine",utilisateur1.getName());
        assertEquals("0606060606",utilisateur1.getNumero());

    }
    @Test
    void findbyid(){
        UtilisateurResponseDao utilisateur1=utilisateurService.findById(1);
        assertNotNull(utilisateur1);
        assertEquals("amine@gmail.com",utilisateur1.getEmail());
        assertEquals("amine",utilisateur1.getPassword());
        assertEquals("amine",utilisateur1.getName());
        assertEquals("0606060606",utilisateur1.getNumero());

    }
    @Test
    void update(){
        UtilisateurRequestDao utilisateur= new UtilisateurRequestDao("imad","imad","imad123@gmail.com","0606060606");
        UtilisateurResponseDao utilisateur1=utilisateurService.update(utilisateur,6);
        assertNotNull(utilisateur1);
        assertEquals(utilisateur1.getName(),utilisateur.getName());
        assertEquals(utilisateur1.getPassword(),utilisateur.getPassword());
        assertEquals(utilisateur1.getEmail(),utilisateur.getEmail());
        assertEquals(utilisateur1.getNumero(),utilisateur.getNumero());
    }
    @Test
    void delet(){
        utilisateurService.delete(6);
        UtilisateurResponseDao utilisateur=utilisateurService.findById(6);
        assertEquals(null,utilisateur);
    }

}