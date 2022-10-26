package com.mycompany.myapp.generator.server.springboot.banner.infrastructure.primary;

import com.mycompany.myapp.generator.server.springboot.banner.application.EntandoBannerApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

import static com.mycompany.myapp.generator.EntandoModuleSlug.BANNER_ENTANDO;
import static tech.jhipster.lite.generator.JHLiteFeatureSlug.BANNER;
import static tech.jhipster.lite.generator.JHLiteModuleSlug.*;

@Configuration
class EntandoBannerModuleConfiguration {

  private static final String GROUP = "Spring Boot - Banner";
  private static final String SERVER = "server";
  private static final String SPRING = "spring";
  private static final String SPRING_BOOT_TAG = "spring-boot";
  private static final String BANNER_TAG = "banner";

  @Bean
  JHipsterModuleResource entandoBannerResource(EntandoBannerApplicationService banners) {
    return JHipsterModuleResource
      .builder()
      .slug(BANNER_ENTANDO)
      .withoutProperties()
      .apiDoc(GROUP, "Add banner Entando")
      .organization(organization())
      .tags(SERVER, SPRING, SPRING_BOOT_TAG, BANNER_TAG)
      .factory(banners::buildEntandoBanner);
  }

  private JHipsterModuleOrganization organization() {
    return JHipsterModuleOrganization.builder().feature(BANNER).addDependency(SPRING_BOOT).build();
  }
}
