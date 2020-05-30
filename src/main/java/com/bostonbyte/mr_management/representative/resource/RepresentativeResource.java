package com.bostonbyte.mr_management.representative.resource;

import com.bostonbyte.mr_management.core.resource.RestResource;
import com.bostonbyte.mr_management.representative.entity.Representative;
import com.bostonbyte.mr_management.representative.resource.request.RepresentUpdateRequest;
import com.bostonbyte.mr_management.representative.resource.request.RepresentativeRequest;
import com.bostonbyte.mr_management.representative.resource.response.RegistResponse;
import com.bostonbyte.mr_management.representative.services.RepresentativeServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/representatives")
@RestController
public class RepresentativeResource extends RestResource {
    @Autowired
    private RepresentativeServices services;
    @PostMapping
    public ResponseEntity saveRepresentative (@RequestBody @Valid RepresentativeRequest representativeRequest){
        try {
            return created(services.saveRepresentative(representativeRequest));
        }
        catch (DataIntegrityViolationException e){
            return confilct("Representative already exists");
        }
    }

    @GetMapping
    public ResponseEntity getRepresentatives(){

        return ok( services.getRepresentatives());
    }

    @PutMapping("/{id}")
    public  ResponseEntity updateRepresentative(@PathVariable Integer id,
                                                @RequestBody RepresentUpdateRequest representativeRequest){
        return ok( services.updateRepresentatives(id,representativeRequest));


    }
    @GetMapping("/{id}")
    public  ResponseEntity getRepresentatives(@PathVariable Integer id){
        Optional<Representative>  user = services.getRepresentatives(id);
        if(user.isPresent()){
             Representative representative1 = user.get();
            RegistResponse response = new RegistResponse();
            BeanUtils.copyProperties(representative1,response);
          return ok(response);
        }
        else
            return  notfound();
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity deleteRepresentative(@PathVariable Integer id){
        try {
            services.deleteRepresentatives(id);
            return  ok();
        }
        catch (Exception e){
            return  new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
