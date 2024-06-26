package srs.customerservice.Services.Mappers;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import srs.customerservice.Entities.BillingAccount;
import srs.customerservice.Services.DTOs.Request.BillingAccountRequest.createBillingAccountRequest;
import srs.customerservice.Services.DTOs.Request.BillingAccountRequest.updateBillingAccountRequest;
import srs.customerservice.Services.DTOs.Response.BillingAccountResponse.*;

public interface BillingAccountMapper {

    BillingAccountMapper INSTANCE = Mappers.getMapper(BillingAccountMapper.class);

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "address.id", target = "addressId")
    getBillingAccountResponse getBillingAccountResponseFromBillingAccount(BillingAccount billingAccount);


    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "address.id", target = "addressId")
    getAllBillingAccountResponse getAllBillingAccountResponse(BillingAccount billingAccount);

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "address.id", target = "addressId")
    @Mapping(source = "accountNumber", target = "accountNumber")
    createdBillingAccountResponse createdBillingAccountResponseFromBillingAccount(BillingAccount billingAccount);

    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "addressId", target = "address.id")
    BillingAccount billingAccountFromCreateBillingAccountRequest(createBillingAccountRequest createBillingAccountRequest);

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "address.id", target = "addressId")
    updateBillingAccountResponse updatedBillingAccountResponseFromBillingAccount(BillingAccount billingAccount);


    BillingAccount billingAccountFromUpdateBillingAccountRequest(updateBillingAccountRequest updateBillingAccountRequest);

    deleteBillingAccountResponse deletedBillingAccountResponseFromBillingAccount(BillingAccount deletedBillingAccount);
}
