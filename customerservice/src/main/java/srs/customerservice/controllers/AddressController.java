package srs.customerservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import srs.customerservice.Entities.Address;
import srs.customerservice.Services.Abstract.AddressService;
import srs.customerservice.Services.DTOs.Request.Address.AddAddressRequest;
import srs.customerservice.Services.DTOs.Request.Address.DeleteAddressRequest;
import srs.customerservice.Services.DTOs.Response.getAddressResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Address")
public class AddressController {

   private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/addAdres")
    public ResponseEntity<String> addAddress(@Valid @RequestBody AddAddressRequest request) {
        try {
            addressService.addAddress(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("Adres başarıyla eklendi.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Adres eklenirken bir hata oluştu.");
        }
    }


@PutMapping("/{id}")
public ResponseEntity<String> updateAddress(@PathVariable int id, @Valid @RequestBody DeleteAddressRequest request) {
    try {
        boolean updated = addressService.updateAddress(id, request);
        if (updated) {
            return ResponseEntity.ok("Adres başarıyla güncellendi.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adres bulunamadı.");
        }
    } catch (IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Adres güncellenirken bir hata oluştu.");
    }
}

/*

    @GetMapping("/{customerId}")
    public List<Address> getAddress(@PathVariable Long customerId){
       return  addressService.getAddressesByCustomerId(customerId);

    }

 */


    @GetMapping("/{customerId}")
    public ResponseEntity<List<Address>> getAddress(@PathVariable Long customerId) {
        List<Address> addresses = addressService.getAddressesByCustomerId(customerId);
        if (!addresses.isEmpty()) {
            return ResponseEntity.ok(addresses);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }





/*
    @DeleteMapping("/addresses/{addressId}")
    public void deleteAddress(@PathVariable Long addressId) {
        addressService.deleteAddressById(addressId);
    }


 */


    @DeleteMapping("/addresses/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long addressId) {
        try {
            addressService.deleteAddressById(addressId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Adres başarıyla silindi.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Silinecek adres bulunamadı.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Adres silinirken bir hata oluştu.");
        }
    }








}
