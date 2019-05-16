/*
package com.macys.common.pricing.services.pricechangecalculator.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macys.common.pricing.services.pricechangecalculator.model.PermPriceInstructionsEntity;
import com.macys.common.pricing.services.pricechangecalculator.model.PriceDataManagement;
import com.macys.common.pricing.services.pricechangecalculator.model.PriceDetails;
import com.macys.common.pricing.services.pricechangecalculator.repository.CatalogElementRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PricingService implements CrudService<PriceDataManagement, PermPriceInstructionsEntity, Integer> {

	@Autowired
    CatalogElementRepository pricingRepository;

	@Autowired
	DozerBeanMapper mapper;

	public static final String DataBaseDownMessage = "The cassandra database is down.";

	public Mono<PriceDataManagement> createOrUpate(PriceDataManagement info) {
		List<PermPriceInstructionsEntity> permPriceChangeInstructions = mapEntity(info);
		pricingRepository.saveAll(permPriceChangeInstructions).subscribe();

		*/
/*
		 * if (!id.equals(entity.getId())) { throw new
		 * DataBaseDownMessage(DataBaseDownMessage); }
		 *//*


		return Mono.just(info);
	}

	public List<PermPriceInstructionsEntity> mapEntity(PriceDataManagement info) {

		List<PermPriceInstructionsEntity> permPriceEntities = new ArrayList<PermPriceInstructionsEntity>();
		PermPriceInstructionsEntity pInfo;

		for (PriceDetails priceDetail : info.getPriceDetails()) {

			pInfo = new PermPriceInstructionsEntity();
			mapper.map(priceDetail, pInfo);
			mapper.map(info.getHeader(), pInfo);
			permPriceEntities.add(pInfo);
			Mono<PermPriceInstructionsEntity> data = pricingRepository.findById(pInfo.getPermPriceInstructionsKey());
			if (null != data && null != data.map(t -> t.getPermPriceInstructionsKey()).block()) {
				pInfo.setDate_updated(new Date(System.currentTimeMillis()));
				pInfo.setDate_created(data.map(t -> t.getDate_created()).block());
			} else {
				pInfo.setDate_updated(new Date(System.currentTimeMillis()));
				pInfo.setDate_created(new Date(System.currentTimeMillis()));
			}

		}
		return permPriceEntities;

	}

	public Flux<PermPriceInstructionsEntity> getAll() {

		return pricingRepository.findAll();

	}

}
*/
