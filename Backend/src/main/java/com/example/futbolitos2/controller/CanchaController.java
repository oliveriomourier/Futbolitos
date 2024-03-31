package com.example.futbolitos2.controller;

import com.example.futbolitos2.entity.Cancha;
import com.example.futbolitos2.request.CreateCanchaRequest;
import com.example.futbolitos2.response.CanchaResponse;
import com.example.futbolitos2.service.CanchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CanchaController {
    @Autowired
    CanchaService canchaService;

    @QueryMapping
    public CanchaResponse cancha(@Argument Integer canchaId){
        Cancha cancha = canchaService.getCanchaById(canchaId);
        return new CanchaResponse(cancha);
    }

    @MutationMapping
    public CanchaResponse canchaCreate(@Argument CreateCanchaRequest createCanchaRequest){
        Cancha cancha = canchaService.canchaCreate(createCanchaRequest);
        return new CanchaResponse(cancha);
    }

    @QueryMapping
    public List<CanchaResponse> canchaGetAll(){
        return canchaService.getAllCancha();
    }

    @MutationMapping
    public Integer canchaDelete(@Argument Integer canchaId){
        return canchaService.canchaDeleteById(canchaId);
    }
}
