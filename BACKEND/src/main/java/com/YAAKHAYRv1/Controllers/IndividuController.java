package com.YAAKHAYRv1.Controllers;


import com.YAAKHAYRv1.Dto.IndividuRequest;
import com.YAAKHAYRv1.Dto.IndividuResponse;
import com.YAAKHAYRv1.Dto.OffertResponseDto;
import com.YAAKHAYRv1.Services.IndividuServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("individu")
public class IndividuController {

    private final IndividuServiceImpl individuService;

    public IndividuController(IndividuServiceImpl individuService) {
        this.individuService = individuService;
    }

    @GetMapping("allindividu")
    public List<IndividuResponse> findAllIndividu(){
        return individuService.findAll();
    }
    @PostMapping("add")
    public IndividuResponse save(@RequestBody IndividuRequest individuRequest){
        return  individuService.save(individuRequest);
    }
    @GetMapping("id/{id}")
    public IndividuResponse findById(@PathVariable("id") Integer id){
        return individuService.findById(id);
    }
    @GetMapping("myoffers/{id}")
    public List<OffertResponseDto> findallmyoffers(@PathVariable("id") Integer id){
        return individuService.findallMyOffers(id);
    }




}
