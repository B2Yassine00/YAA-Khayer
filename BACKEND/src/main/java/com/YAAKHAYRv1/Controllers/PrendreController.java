package com.YAAKHAYRv1.Controllers;

import com.YAAKHAYRv1.Dto.AssociationResponse;
import com.YAAKHAYRv1.Dto.OffertResponseDto;
import com.YAAKHAYRv1.Dto.PrendreRequest;
import com.YAAKHAYRv1.Dto.PrendreRespondre;
import com.YAAKHAYRv1.Models.Prendre;
import com.YAAKHAYRv1.Services.PrendreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prendre")
public class PrendreController {
    @Autowired
    private final PrendreService prendreService;

    public PrendreController(PrendreService prendreService) {
        this.prendreService = prendreService;
    }
    @PostMapping("add")
    public PrendreRespondre save(@RequestBody PrendreRequest prendreRequest){
        return prendreService.save(prendreRequest);
    }
    @GetMapping("prendreall")
    public List<PrendreRespondre> prendreAll(){return prendreService.prendreAll();}
    @GetMapping("takenbyassoication/{id}")
    public List<OffertResponseDto> prendreByAssociation(@PathVariable("id") Integer id){ return prendreService.prendreByAssociation(id);}
    @GetMapping("offerttakenby/{id_offer}")
    public List<AssociationResponse> prendreAssociationByOffer(@PathVariable("id_offer") Integer id_offer){return prendreService.prendreAssociationByOffer(id_offer);}


}
