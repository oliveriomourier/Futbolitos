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

        List<Booking> bookingList = new ArrayList<Booking>();
        cancha.setBookingList(bookingList);

        return cancha;
    }

    public Cancha getCanchaById(Long id) throws CanchaException {
        return canchaRepository.findById(id)
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

    public Long canchaDeleteById(long canchaId) throws UserNotFoundException{
        //verify if the cancha exist
        Cancha cancha = getCanchaById(canchaId);

        // delete user
        canchaRepository.delete(cancha);
        return canchaId;
    }
}
