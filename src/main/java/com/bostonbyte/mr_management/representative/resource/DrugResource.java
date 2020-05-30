package com.bostonbyte.mr_management.representative.resource;

import com.bostonbyte.mr_management.core.resource.RestResource;
import com.bostonbyte.mr_management.representative.resource.request.DrugRequest;
import com.bostonbyte.mr_management.representative.services.DrugServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/drugs")
public class DrugResource extends RestResource {

    @Autowired
   private DrugServices drugServices;
    @PostMapping
    public ResponseEntity saveDrug(@RequestBody  @Valid  DrugRequest request){
        try {
            return created(drugServices.saveDrug(request));
        }
        catch (DataIntegrityViolationException e){
            return confilct("Drug already exists");
        }
    }

    @GetMapping
    public ResponseEntity getDrug(){
        return ok( drugServices.findDrugs());
    }

    @GetMapping("/{id}")
    public  ResponseEntity getDrug(@PathVariable Integer id){
        return ok(drugServices.findDrugs(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity updateDrug(@PathVariable Integer id,
                                     @RequestBody DrugRequest request){
        return ok(drugServices.updateDrug(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDrug(@PathVariable Integer id){
        drugServices.deleteDrug(id);
        return ok();
    }


}
