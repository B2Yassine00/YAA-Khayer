package com.YAAKHAYRv1.Controllers;

import com.YAAKHAYRv1.Dto.IndividuResponse;
import com.YAAKHAYRv1.Dto.OffertRequestDto;
import com.YAAKHAYRv1.Dto.OffertResponseDto;
import com.YAAKHAYRv1.Services.OffertServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("offers")
public class OffertController {
    @Autowired
    private final OffertServiceImpl offertService;

    public OffertController(OffertServiceImpl offertService) {
        this.offertService = offertService;
    }
    @GetMapping("id/{id}")
    public Optional<OffertResponseDto> findById(@PathVariable("id") Integer id){
        return offertService.findOffertById(id);
    }
    @GetMapping("alloffers")
    public List<OffertResponseDto> findAll(){
        return  offertService.findAllOffert();
    }
    @PostMapping("add")
    public  OffertResponseDto save(@RequestBody OffertRequestDto offertRequestDto){
        return offertService.save(offertRequestDto);
    }
    @DeleteMapping("delet/{id}")
    public void delete(@PathVariable("id") Integer id){
        offertService.delete(id);
    }
    @PutMapping("update/{id}")
    public OffertResponseDto update(@RequestBody OffertRequestDto offertRequestDto,@PathVariable("id") Integer id){
        return offertService.update(offertRequestDto,id);
    }

    @GetMapping("alltypes")
    public List<String> findallTypes(){
        return  offertService.findAllTypes();
    }
    @GetMapping("nottaking")
    public List<OffertResponseDto> findnottaken(){return offertService.findNotTaken();};

    @GetMapping("byindividu")
    public List<OffertResponseDto> findbyindividu(@RequestBody IndividuResponse individuResponse){
        return offertService.findAllByIndividu(individuResponse);
    }

}
