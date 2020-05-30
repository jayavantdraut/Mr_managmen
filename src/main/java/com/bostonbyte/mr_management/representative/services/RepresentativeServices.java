package com.bostonbyte.mr_management.representative.services;

import com.bostonbyte.mr_management.representative.entity.Drug;
import com.bostonbyte.mr_management.representative.entity.Representative;
import com.bostonbyte.mr_management.representative.repository.DrugRepo;
import com.bostonbyte.mr_management.representative.repository.RepresentativeRepo;
import com.bostonbyte.mr_management.representative.resource.request.RepresentUpdateRequest;
import com.bostonbyte.mr_management.representative.resource.request.RepresentativeRequest;
import com.bostonbyte.mr_management.representative.resource.response.DrugResponse;
import com.bostonbyte.mr_management.representative.resource.response.RegistResponse;
import com.bostonbyte.mr_management.representative.resource.response.RepresentResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RepresentativeServices {

    @Autowired
    private RepresentativeRepo representativeRepo;
    @Autowired
    private DrugRepo drugRepo;
    public RegistResponse saveRepresentative(RepresentativeRequest registration){
        List <Drug> drugs = new ArrayList<>();
        Set<Integer> ids = registration.getDrugIds();
        if(!ids.isEmpty())
            drugs = getDrugs(ids);
        Representative representative = new Representative();
        BeanUtils.copyProperties(registration, representative);
        representative.setDrugs(drugs);
        representative = representativeRepo.saveAndFlush(representative);
        RegistResponse response = new RegistResponse();
     List<DrugResponse> drugResponses= representative.getDrugs().stream().map(drug -> {
             DrugResponse response1 = new DrugResponse();
             response1.setCode(drug.getCode());
             response1.setCompany(drug.getCompany());
             response1.setDescription(drug.getDescription());
             response1.setId(drug.getId());
             response1.setName(drug.getName());
             return response1;
         }).collect(Collectors.toList());
        BeanUtils.copyProperties(representative,response);
        response.setDrugs(drugResponses);

        return  response;
    }

    private  List<Drug> getDrugs(Set<Integer> ids){
        return  ids.stream().map(id-> drugRepo.getOne(id)).collect(Collectors.toList());
    }

    public RegistResponse updateRepresentatives(Integer id, RepresentUpdateRequest registration){
        return representativeRepo.findById(id).map(representative -> {
            representative =  copyRequestToEntity(registration,representative);
            Representative entity = representativeRepo.saveAndFlush(representative);
            RegistResponse response = new RegistResponse();
            List<DrugResponse> drugResponses= entity.getDrugs().stream().map(drug -> {
                DrugResponse response1 = new DrugResponse();
                response1.setCode(drug.getCode());
                response1.setCompany(drug.getCompany());
                response1.setDescription(drug.getDescription());
                response1.setId(drug.getId());
                response1.setName(drug.getName());
                return response1;
            }).collect(Collectors.toList());
            BeanUtils.copyProperties(entity,response);
            response.setDrugs(drugResponses);
            return response;
        }).orElseThrow(()->new RuntimeException("representative not found "));
    }

    private Representative copyRequestToEntity (RepresentUpdateRequest request ,Representative entity){
        List<Drug> drugs = new ArrayList<>();
        if(!request.getDrugIds().isEmpty()){
            drugs=   getDrugs(request.getDrugIds());
        }
        if(request.getAddress()!=null)
            entity.setAddress(request.getAddress());
        if(request.getEmail()!=null)
            entity.setEmail(request.getEmail());
        if(request.getFirstName()!=null)
            entity.setFirstName(request.getFirstName());
        if(request.getLastName()!=null)
            entity.setLastName(request.getLastName());
        if(request.getMobile()!=null)
            entity.setMobile(request.getMobile());
        if(request.getQualification()!=null)
            entity.setQualification(request.getQualification());
        entity.setDrugs(drugs);
        return  entity;
    }

    public List<RepresentResponse> getRepresentatives(){
        return  representativeRepo.findAll().stream().map(representative -> {
            RepresentResponse response = new RepresentResponse();
            BeanUtils.copyProperties(representative,response);
            return  response;
        }).collect(Collectors.toList());
    }

    public Optional<Representative> getRepresentatives(Integer id){
        return  representativeRepo.findById(id);
    }

    public  void deleteRepresentatives(Integer id){
        representativeRepo.deleteById(id);
    }

}
