/*
package com.macys.common.pricing.services.pricechangecalculator.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.macys.common.pricing.services.pricechangecalculator.model.PriceDataManagement;
import com.macys.common.pricing.services.pricechangecalculator.model.PriceDetails;

public class PriceChangeInstructionValidator implements Validator {



  @Override
  public boolean supports(Class<?> clazz) {
    return PriceDataManagement.class.isAssignableFrom(clazz)
        || PriceDetails.class.isAssignableFrom(clazz);
  }



  @Override
  public void validate(Object target, Errors errors) {

    PriceDataManagement request = (PriceDataManagement) target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "header", "header.required",
        "Header is required field.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "priceDetails", "priceDetails.required",
        "PriceDetails is required field");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "header.departmentNumber",
        "header.departmentNumber.required", "Department number is required field");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "header.divisionNumber",
        "header.divisionNumber.required", "Division number is required field");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "header.priceChangeNumber",
        "header.priceChangeNumber.required", "Price change number is required field");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "header.pricingEventId",
        "header.pricingEventId.required", "Pricing Event Id is required field");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "header.messageSequenceNumber",
        "header.messageSequenceNumber.required", "Message sequence number is required field");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "header.rsnId", "header.rsnId.required",
        "RSN Id is required field");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "header.pcSourceID",
        "header.pcSourceID.required", "PC source Id is required field");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "header.startDate",
        ".headerstartDate.required", "Start date is required field");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "header.locations.location.zone",
        "header.locations.required", "Locations is required field");


    if (null != request.getPriceDetails()) {
      for (int i = 0; i < request.getPriceDetails().size(); i++) {
        PriceDetails pd = request.getPriceDetails().get(i);

        if (pd.getVendorNumber() == null || pd.getVendorNumber().isEmpty()) {
          errors.rejectValue("priceDetails[" + i + "].vendorNumber", "vendorNumber.required",
              "Vendor Number is required field");
        }
        if (pd.getMarkStyleNumber() == null || pd.getMarkStyleNumber().isEmpty()) {
          errors.rejectValue("priceDetails[" + i + "].markStyleNumber", "markStyleNumber.required",
              "Mark Style Number is required field");
        }
        if (pd.getNrfColorNumber() == null || pd.getNrfColorNumber().isEmpty()) {
          errors.rejectValue("priceDetails[" + i + "].nrfColorNumber", "nrfColorNumber.required",
              "NRF color number is required field");
        }
        if (pd.getItemColorNumber() == null || pd.getItemColorNumber().isEmpty()) {
          errors.rejectValue("priceDetails[" + i + "].itemColorNumber", "itemColorNumber.required",
              "Item Color Number is required field");
        }
        if (pd.getClassNumber() == null || pd.getClassNumber().isEmpty()) {
          errors.rejectValue("priceDetails[" + i + "].classNumber", "classNumber.required",
              "Class Number is required field");
        }
        if (pd.getGlobalId() == null || pd.getGlobalId().isEmpty()) {
          errors.rejectValue("priceDetails[" + i + "].globalId", "globalId.required",
              "Golobal Id is required field");
        }
        if (pd.getMarkdownStatus() == null || pd.getMarkdownStatus().isEmpty()) {
          errors.rejectValue("priceDetails[" + i + "].markdownStatus", "markdownStatus.required",
              "Mark Down Status is required field");
        }
        if (pd.getEdvFlag() == null || pd.getEdvFlag().isEmpty()) {
          errors.rejectValue("priceDetails[" + i + "].edvFlag", "edvFlag.required",
              "EDV flag is required field");
        }
        if (pd.getNrfSizeNumber() == null || pd.getNrfSizeNumber().isEmpty()) {
          errors.rejectValue("priceDetails[" + i + "].nrfSizeNumber", "nrfSizeNumber.required",
              "NRF size number is required field");
        }
        if (pd.getItemSizeNumber() == null || pd.getItemSizeNumber().isEmpty()) {
          errors.rejectValue("priceDetails[" + i + "].itemSizeNumber", "itemSizeNumber.required",
              "Item size number is required field");
        }
        if (pd.getCurrentFirstTicket() == null) {
          errors.rejectValue("priceDetails[" + i + "].currentFirstTicket",
              "currentFirstTicket.required", "Current First ticket is required field");
        }
        if (pd.getNewFirstTicket() == null) {
          errors.rejectValue("priceDetails[" + i + "].newFirstTicket", "newFirstTicket.required",
              "New first ticket is required field");
        }
        if (pd.getCurrentTicket() == null) {
          errors.rejectValue("priceDetails[" + i + "].currentTicket", "currentTicket.required",
              "Current ticket is required field");
        }
        if (pd.getNewTicket() == null) {
          errors.rejectValue("priceDetails[" + i + "].newTicket", "newTicket.required",
              "New ticket is required field");
        }

      }
    }
  }
}
*/
