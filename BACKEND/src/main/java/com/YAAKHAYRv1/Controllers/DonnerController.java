package com.YAAKHAYRv1.Controllers;

import com.YAAKHAYRv1.Dto.CompagneResponse;
import com.YAAKHAYRv1.Dto.DonnerRequest;
import com.YAAKHAYRv1.Dto.DonnerResponse;
import com.YAAKHAYRv1.Dto.IndividuResponse;
import com.YAAKHAYRv1.Models.Donner;
import com.YAAKHAYRv1.Services.DonnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("donner")
public class DonnerController {
    @Autowired
    private final DonnerService donnerService;

    public DonnerController(DonnerService donnerService) {
        this.donnerService = donnerService;
    }
    //tous les donners
    @GetMapping("alldonner")
    public List<DonnerResponse> findAlldonner(){return donnerService.findAllDon();}
    //les compagnes qu'un personne fait le donner
    @GetMapping("findbyindividu/{id}")
    public List<CompagneResponse> findAlldonnerbyindividu(@PathVariable("id") Integer id){return  donnerService.findDonByIndividu(id);}
    //les individus qui font un donner pour une compagne specifique
    @GetMapping("findbycompagne/{id}")
    public List<IndividuResponse> findAlldonnerbycompagne(@PathVariable("id") Integer id){return donnerService.findDonByCompagne(id);}
    //ajouter un donner
    @PostMapping("add")
    public DonnerResponse save(@RequestBody DonnerRequest donnerRequest){return  donnerService.save(donnerRequest);}

}
