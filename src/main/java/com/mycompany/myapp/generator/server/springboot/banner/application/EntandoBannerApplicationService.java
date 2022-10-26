package com.mycompany.myapp.generator.server.springboot.banner.application;

import com.mycompany.myapp.generator.server.springboot.banner.domain.EntandoBannerModuleFactory;
import org.springframework.stereotype.Service;
import tech.jhipster.lite.module.domain.JHipsterModule;
import tech.jhipster.lite.module.domain.properties.JHipsterModuleProperties;

@Service
public class EntandoBannerApplicationService {

  private final EntandoBannerModuleFactory factory;

  public EntandoBannerApplicationService() {
    this.factory = new EntandoBannerModuleFactory();
  }

  public JHipsterModule buildEntandoBanner(JHipsterModuleProperties properties) {
    return factory.buildModuleBannerEntando(properties);
  }
}
