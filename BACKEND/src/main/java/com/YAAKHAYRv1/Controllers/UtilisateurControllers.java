//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.YAAKHAYRv1.Controllers;

import com.YAAKHAYRv1.Dto.UtilisateurRequestDao;
import com.YAAKHAYRv1.Dto.UtilisateurResponseDao;
import com.YAAKHAYRv1.Services.UtilisateurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"utilisateurs"})
public class UtilisateurControllers {
    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurControllers(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping({"allusers"})
    public List<UtilisateurResponseDao> getUtilisateur() {
        return this.utilisateurService.findAll();
    }

    @PostMapping({"add"})
    public UtilisateurResponseDao save(@RequestBody UtilisateurRequestDao utilisateurRequestDao) {
        return this.utilisateurService.save(utilisateurRequestDao);
    }

    @GetMapping({"login/email={email}&&password={password}"})
    public UtilisateurResponseDao findbylogin(@PathVariable("email") String email, @PathVariable("password") String password) {
        return this.utilisateurService.findbylogin(email, password);
    }

    @DeleteMapping({"delete/{id}"})
    public void delter(@PathVariable Integer id) {
        this.utilisateurService.delete(id);
    }

    @PutMapping({"update/{id}"})
    public UtilisateurResponseDao update(@RequestBody UtilisateurRequestDao utilisateurRequestDao, @PathVariable Integer id) {
        return this.utilisateurService.update(utilisateurRequestDao, id);
    }
}
