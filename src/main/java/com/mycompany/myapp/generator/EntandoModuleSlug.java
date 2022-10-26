package com.mycompany.myapp.generator;

import tech.jhipster.lite.module.domain.resource.JHipsterModuleSlugFactory;

public enum EntandoModuleSlug implements JHipsterModuleSlugFactory {
  BANNER_ENTANDO("banner-entando");

  private final String slug;

  EntandoModuleSlug(String slug) {
    this.slug = slug;
  }

  @Override
  public String get() {
    return slug;
  }
}
