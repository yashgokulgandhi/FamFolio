package com.example.FamFolio_Backend.AdharVerification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aadhaar")
public class AadhaarController {

    @Autowired
    private AadhaarService aadhaarService;

    @PostMapping("/verify")
    public ResponseEntity<?> verifyAadhaarAndSendOtp(@RequestBody String aadhaarNumber) {
  	  aadhaarNumber = aadhaarNumber.replaceAll("^\"|\"$", "").trim();

        return aadhaarService.verifyAadhaarAndSendOtp(aadhaarNumber);
    }

    @PostMapping("/validateOtp")
    public ResponseEntity<?> validateOtp(@RequestBody OtpValidationRequest request) {
        return aadhaarService.validateOtp(request.getAadhaarNumber(), request.getOtp());
    }
}
