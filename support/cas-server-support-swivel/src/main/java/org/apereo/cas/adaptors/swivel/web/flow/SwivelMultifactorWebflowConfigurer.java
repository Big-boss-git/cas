package org.apereo.cas.adaptors.swivel.web.flow;

import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.web.flow.configurer.AbstractCasMultifactorWebflowConfigurer;
import org.apereo.cas.web.flow.configurer.CasMultifactorWebflowCustomizer;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;

import java.util.List;
import java.util.Optional;

/**
 * This is {@link SwivelMultifactorWebflowConfigurer}.
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
public class SwivelMultifactorWebflowConfigurer extends AbstractCasMultifactorWebflowConfigurer {

    /**
     * Webflow event id.
     */
    public static final String MFA_SWIVEL_EVENT_ID = "mfa-swivel";

    public SwivelMultifactorWebflowConfigurer(final FlowBuilderServices flowBuilderServices,
                                              final FlowDefinitionRegistry loginFlowDefinitionRegistry,
                                              final FlowDefinitionRegistry flowDefinitionRegistry,
                                              final ConfigurableApplicationContext applicationContext,
                                              final CasConfigurationProperties casProperties,
                                              final List<CasMultifactorWebflowCustomizer> mfaFlowCustomizers) {
        super(flowBuilderServices, loginFlowDefinitionRegistry, applicationContext,
            casProperties, Optional.of(flowDefinitionRegistry), mfaFlowCustomizers);
    }

    @Override
    protected void doInitialize() {
        registerMultifactorProviderAuthenticationWebflow(getLoginFlow(), MFA_SWIVEL_EVENT_ID,
            casProperties.getAuthn().getMfa().getSwivel().getId());
    }
}
