package com.macys.common.pricing.services.pricechangecalculator.service;

import com.macys.common.pricing.services.pricechangecalculator.model.PromotionRule;
import com.macys.common.pricing.services.pricechangecalculator.repository.PromotionRuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PromotionRuleCrudService extends AbstractCrudService<PromotionRuleRepository, PromotionRule> {

}