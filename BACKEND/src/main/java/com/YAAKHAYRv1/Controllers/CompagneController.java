package com.YAAKHAYRv1.Controllers;

import com.YAAKHAYRv1.Dto.CompagneRequest;
import com.YAAKHAYRv1.Dto.CompagneResponse;
import com.YAAKHAYRv1.Services.CompagneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("compagne")
public class CompagneController {
    @Autowired
    private final CompagneServiceImpl compagneService;

    public CompagneController(CompagneServiceImpl compagneService) {
        this.compagneService = compagneService;
    }

    @GetMapping("id/{id}")
    public Optional<CompagneResponse> findById(@PathVariable("id") Integer id){
        return compagneService.findByid(id);
    }
    @GetMapping("allcompagne")
    public List<CompagneResponse> findAllCompagne(){return  compagneService.findAll();}
    @PostMapping("add")
    public CompagneResponse add(@RequestBody CompagneRequest compagneRequest){return compagneService.add(compagneRequest);}
    @DeleteMapping("delet/{id}")
    public void delete(@PathVariable("id") Integer id){compagneService.delete(id);}
    @PutMapping("update/{id}")
    public CompagneResponse update(@RequestBody CompagneRequest compagneRequest,@PathVariable("id") Integer id){return compagneService.update(compagneRequest,id);}
    @GetMapping("colturer/{id}")
    public void colturer(@PathVariable("id") Integer id){compagneService.colturer(id);}
    @GetMapping("notcolture")
    public List<CompagneResponse> findNotColture(){return compagneService.findNotColturer();}
    @GetMapping("findbyassociation/{id}")
    public List<CompagneResponse> findByAssociation(@PathVariable("id") Integer id){return compagneService.findByAssociation(id);}


}
