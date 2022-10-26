package com.mycompany.myapp.generator.server.springboot.banner.domain;

import tech.jhipster.lite.error.domain.Assert;
import tech.jhipster.lite.generator.server.springboot.banner.domain.BannerModuleFactory;
import tech.jhipster.lite.module.domain.JHipsterModule;
import tech.jhipster.lite.module.domain.file.JHipsterDestination;
import tech.jhipster.lite.module.domain.file.JHipsterSource;
import tech.jhipster.lite.module.domain.properties.JHipsterModuleProperties;

import static tech.jhipster.lite.module.domain.JHipsterModule.from;

public class EntandoBannerModuleFactory {

  private static final String SOURCE_FOLDER = "server/springboot/banner";
  private static final String PROPERTIES = "properties";

  public JHipsterModule buildModuleBannerEntando(JHipsterModuleProperties properties) {
    Assert.notNull(PROPERTIES, properties);
    return buildModuleBanner(properties, "banner-entando.txt");
  }

  private JHipsterModule buildModuleBanner(JHipsterModuleProperties properties, String file) {
    // @formatter:off
    return JHipsterModule
      .moduleBuilder(properties)
      .files()
        .add(source().file(file), destination())
        .and()
      .build();
    // @formatter:on
  }

  private JHipsterSource source() {
    return from(SOURCE_FOLDER);
  }

  private JHipsterDestination destination() {
    return new JHipsterDestination("src/main/resources").append("banner.txt");
  }
}
