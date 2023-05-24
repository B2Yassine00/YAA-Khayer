package com.YAAKHAYRv1.Controllers;

import com.YAAKHAYRv1.Dto.AssociationRequest;
import com.YAAKHAYRv1.Dto.AssociationResponse;
import com.YAAKHAYRv1.Services.AssociationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("association")
public class AssociationController {
    @Autowired
    private final AssociationServiceImpl associationService;

    public AssociationController(AssociationServiceImpl associationService) {
        this.associationService = associationService;
    }
    @GetMapping("id/{id}")
    public AssociationResponse findById(@PathVariable("id") Integer id){return associationService.findById(id);}
    @GetMapping("allassociation")
    public List<AssociationResponse> findAll(){return associationService.findAll();}
    @PostMapping("add")
    public AssociationResponse save(@RequestBody AssociationRequest associationRequest){return associationService.save(associationRequest);}
    @PutMapping("update/{id}")
    public AssociationResponse update(@RequestBody AssociationRequest associationRequest,@PathVariable("id") Integer id){return  associationService.update(associationRequest,id);}
    @DeleteMapping("delet/{id}")
    public void delete(@PathVariable("id") Integer id){associationService.delete(id);}
}
