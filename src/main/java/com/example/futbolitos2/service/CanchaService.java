package com.example.futbolitos2.service;

import com.example.futbolitos2.entity.Booking;
import com.example.futbolitos2.entity.Cancha;
import com.example.futbolitos2.entity.User;
import com.example.futbolitos2.exception.CanchaException;
import com.example.futbolitos2.exception.UserNotFoundException;
import com.example.futbolitos2.repository.CanchaRepository;
import com.example.futbolitos2.request.CreateCanchaRequest;
import com.example.futbolitos2.response.CanchaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CanchaService {
    @Autowired
    CanchaRepository canchaRepository;

    public Cancha canchaCreate(CreateCanchaRequest createCanchaRequest){
        Cancha cancha = new Cancha(createCanchaRequest);
        canchaRepository.save(cancha);

        return cancha;
    }

    public Cancha getCanchaById(Integer id) throws CanchaException {
        return canchaRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new UserNotFoundException("Cancha with id: " + id + " doesn't exist"));
    }

    public List<CanchaResponse> getAllCancha(){
        List<Cancha> canchaList = canchaRepository.findAll();
        List<CanchaResponse> canchaResponseList = new ArrayList<>();

        for (Cancha cancha: canchaList) {
            CanchaResponse canchaResponse = new CanchaResponse(cancha);
            canchaResponseList.add(canchaResponse);
        }

        return canchaResponseList;
    }

    public Integer canchaDeleteById(Integer canchaId) throws UserNotFoundException{
        Cancha cancha = getCanchaById(canchaId);

        canchaRepository.delete(cancha);
        return canchaId;
    }
}
