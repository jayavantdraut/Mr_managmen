package com.bostonbyte.mr_management.representative.services;

import com.bostonbyte.mr_management.representative.entity.Drug;
import com.bostonbyte.mr_management.representative.repository.DrugRepo;
import com.bostonbyte.mr_management.representative.resource.request.DrugRequest;
import com.bostonbyte.mr_management.representative.resource.response.DrugResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrugServices {
    @Autowired
    private DrugRepo drugRepo;
    public DrugResponse saveDrug(DrugRequest request){
        Drug drug = new Drug ();
        BeanUtils.copyProperties(request,drug);
        drug = drugRepo.saveAndFlush(drug);
        DrugResponse response = new DrugResponse();
        BeanUtils.copyProperties(drug,response);
        return  response;
    }

    public  DrugResponse  updateDrug(Integer id,DrugRequest request){
        return   drugRepo.findById(id).map(drug->{
            BeanUtils.copyProperties(request,drug);
            Drug entity =  drugRepo.saveAndFlush(drug);
            DrugResponse response = new DrugResponse();
           BeanUtils.copyProperties(entity,response);
           return  response;
        }).orElseThrow(()->new RuntimeException("Drug Not found"));

    }

    public List<DrugResponse> findDrugs(){
        return  drugRepo.findAll().stream().map(drug -> {
            DrugResponse response = new DrugResponse();
            BeanUtils.copyProperties(drug,response);
            return  response;
        }).collect(Collectors.toList());
    }

    public DrugResponse findDrugs(Integer id){
        return   drugRepo.findById(id).map(drug->{
            DrugResponse response = new DrugResponse();
            BeanUtils.copyProperties(drug,response);
            return  response;
        }).orElseThrow(()->new RuntimeException("Drug Not found"));

    }


    public  void deleteDrug(Integer id){
        drugRepo.deleteById(id);

    }
}
