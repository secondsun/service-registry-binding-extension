package com.redhat.cloud.service.registry.binding.extension.deployment;

import com.redhat.cloud.service.binding.runtime.ServiceRegistryBindingConverter;

import io.quarkus.deployment.Capabilities;
import io.quarkus.deployment.Capability;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.nativeimage.ServiceProviderBuildItem;

class ServiceRegistryBindingExtensionProcessor {

    @BuildStep
    void registerServiceBinding(Capabilities capabilities,
            BuildProducer<ServiceProviderBuildItem> serviceProvider) {
        if (capabilities.isPresent(Capability.KUBERNETES_SERVICE_BINDING)) {
            serviceProvider.produce(
                    new ServiceProviderBuildItem("com.redhat.cloud.service.binding.runtime.ServiceBindingConverter",
                            ServiceRegistryBindingConverter.class.getName()));
        }
    }
}
