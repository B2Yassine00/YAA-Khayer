//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.YAAKHAYRv1.Services;

import com.YAAKHAYRv1.Dto.UtilisateurRequestDao;
import com.YAAKHAYRv1.Dto.UtilisateurResponseDao;
import java.util.List;

public interface UtilisateurService {
    UtilisateurResponseDao save(UtilisateurRequestDao utilisateur);

    UtilisateurResponseDao findbylogin(String email, String password);

    UtilisateurResponseDao findById(Integer id);

    void delete(Integer id);

    UtilisateurResponseDao update(UtilisateurRequestDao utilisateur, Integer id);

    List<UtilisateurResponseDao> findAll();
}
