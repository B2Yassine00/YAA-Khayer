package com.YAAKHAYRv1.Controllers;

import com.YAAKHAYRv1.Dto.Donresponse;
import com.YAAKHAYRv1.Services.DonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Don")
public class DonController {
    @Autowired
    private final DonServiceImpl donService;

    public DonController(DonServiceImpl donService) {
        this.donService = donService;
    }
    @GetMapping("alldon")
    public List<Donresponse> findAllDon(){
        return donService.findAll();
    }
    @GetMapping("id/{id}")
    public Donresponse findDonById(@PathVariable("id") int id){
       return donService.findDonById(id);
    }


}
