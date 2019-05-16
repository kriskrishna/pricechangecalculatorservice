/*
package com.macys.common.pricing.services.pricechangecalculator.utils;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.macys.common.pricing.services.pricechangecalculator.model.Header;
import com.macys.common.pricing.services.pricechangecalculator.model.PermPriceInstructionsEntity;
import com.macys.common.pricing.services.pricechangecalculator.model.PriceDetails;

@Configuration
public class PermPriceInstructionsMappingConfig {

  @Bean
  public BeanMappingBuilder beanMappingBuilder() {
    return new BeanMappingBuilder() {
      @Override
      protected void configure() {
        mapping(PriceDetails.class, PermPriceInstructionsEntity.class)

            .fields("vendorNumber", "permPriceInstructionsKey.vendor_num").fields("markStyleNumber", "permPriceInstructionsKey.mark_style_num")
            .fields("nrfColorNumber", "permPriceInstructionsKey.nrf_color_num").fields("itemColorNumber", "item_color_num")
            .fields("classNumber", "class_num").fields("globalId", "global_id")
            .fields("markdownStatus", "markdown_status").fields("edvFlag", "edv_flag")
            .fields("nrfSizeNumber", "permPriceInstructionsKey.nrf_size_num").fields("itemSizeNumber", "item_size_num")
            .fields("markdownStatus", "mark_down_status")
            .fields("currentFirstTicket", "current_first_ticket")
            .fields("newFirstTicket", "new_first_ticket").fields("currentTicket", "current_ticket")
            .fields("newTicket", "new_ticket")
            .fields("lastUpdateTS", "source_last_update_timestamp",
                FieldsMappingOptions.customConverter(StringToTimestampFieldConverter.class));


        mapping(Header.class, PermPriceInstructionsEntity.class)

            .fields("departmentNumber", "permPriceInstructionsKey.department_num").fields("divisionNumber", "division_num")
            .fields("priceChangeNumber", "price_change_num")
            .fields("pricingEventId", "pricing_event_id")
            .fields("messageSequenceNumber", "message_sequence_num").fields("rsnId", "rsn_id")
            .fields("pcSourceID", "pc_source_id")
            .fields("startDate", "permPriceInstructionsKey.start_date",
                FieldsMappingOptions.customConverter(StringToTimestampFieldConverter.class))
            .fields("locations.location.zone", "location_zones");
      }
    };
  }

  @Bean
  public DozerBeanMapper beanMapper() {
    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
    dozerBeanMapper.addMapping(beanMappingBuilder());
    return dozerBeanMapper;
  }

}
*/
