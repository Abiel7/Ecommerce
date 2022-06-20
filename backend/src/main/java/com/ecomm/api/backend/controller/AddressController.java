package com.ecomm.api.backend.controller;

import com.ecomm.api.backend.hateoas.AddressRepresentation;
import com.ecomm.api.backend.service.AddressService;
import com.ecommerce.api.AddressApi;
import com.ecommerce.api.model.AddAddressReq;
import com.ecommerce.api.model.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class AddressController implements AddressApi {

    private  AddressService addressService;
    private final AddressRepresentation addressRepresentationAssembler;


    public AddressController(AddressService addressService, AddressRepresentation addressRepresentationAssembler) {
        this.addressService = addressService;
        this.addressRepresentationAssembler = addressRepresentationAssembler;
    }

    @Override
    public Mono<ResponseEntity<Address>> createAddress(Mono<AddAddressReq> addAddressReq, ServerWebExchange exchange) {
        return addressService.createAddress(addAddressReq)
                .map(a -> addressRepresentationAssembler.toModel(a))
                .map(e -> status(HttpStatus.CREATED).body(e));
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteAddressById(String id, ServerWebExchange exchange) {
        addressService.deleteAddressById(id);
        return accepted().build();
    }

    @Override
    public Mono<ResponseEntity<Address>> getAddressById(String id, ServerWebExchange exchange) {
       return addressService.getAddressById(id).map(addressRepresentationAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(notFound().build());

    }

    @Override
    public Mono<ResponseEntity<Flux<Address>>> getAddresses(ServerWebExchange exchange) {
        return null;
    }

    /*
   @Override
   public ResponseEntity<Address> createAddress(AddAddressReq addAddressReq) {
      return status(HttpStatus.CREATED).body(addressService.createAddress(addAddressReq).map(addressRepresentationAssembler::toModel).get());
   }

   @Override
   public  Mono<ResponseEntity<Void>>  deleteAddressById(String id) {
       addressService.deleteAddressById(id);
      return accepted().build();
   }

@Override
   public ResponseEntity<Address> getAddressById(String id) {
      return addressService.getAddressById(id)
              .map(addressRepresentationAssembler::toModel)
              .map(ResponseEntity::ok)
              .orElse(notFound().build());
   }

   @Override
   public ResponseEntity<List<Address>> getAddresses() {
      return ok(addressRepresentationAssembler.toListModel(addressService.getAllAddresses()));
   }

     */
}
