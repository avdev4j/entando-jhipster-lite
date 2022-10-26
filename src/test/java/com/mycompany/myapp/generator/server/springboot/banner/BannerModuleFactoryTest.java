package com.mycompany.myapp.generator.server.springboot.banner;

import com.mycompany.myapp.generator.server.springboot.banner.domain.EntandoBannerModuleFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tech.jhipster.lite.UnitTest;

import tech.jhipster.lite.module.domain.JHipsterModule;

import static tech.jhipster.lite.module.domain.JHipsterModulesFixture.testModuleProperties;
import static tech.jhipster.lite.module.infrastructure.secondary.JHipsterModulesAssertions.assertThatModule;

@UnitTest
class BannerModuleFactoryTest {

  private static final EntandoBannerModuleFactory factory = new EntandoBannerModuleFactory();
  private static final String BANNER_TXT = "src/main/resources/banner.txt";

  @Test
  @DisplayName("Banner is present")
  void shouldCreateModuleEntandoBanner() {
    JHipsterModule module = factory.buildModuleBannerEntando(testModuleProperties());

    assertThatModule(module).hasFiles(BANNER_TXT);
  }

  @Test
  @DisplayName("Entando Banner contains the value")
  void shouldContainsExpectedValueModuleEntandoBanner() {
    JHipsterModule module = factory.buildModuleBannerEntando(testModuleProperties());

    assertThatModule(module).hasFile(BANNER_TXT).containing("Welcome ENTANDO!");
  }
}
