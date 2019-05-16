package com.macys.common.pricing.services.pricechangecalculator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

//@Component
class InstanceInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("kb_instance",
                Collections.singletonMap("id", System.getenv("INSTANCE_GUID")));
    }
}
