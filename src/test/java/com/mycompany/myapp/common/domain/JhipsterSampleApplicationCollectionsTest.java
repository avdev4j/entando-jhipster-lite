package com.mycompany.myapp.common.domain;

import static org.assertj.core.api.Assertions.*;

import com.mycompany.myapp.UnitTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@UnitTest
class JhipsterSampleApplicationCollectionsTest {

  @Nested
  @DisplayName("Collections")
  class JhipsterSampleApplicationCollectionsCollectionsTest {

    @Test
    void shouldGetEmptyImmutableCollectionFromNullCollection() {
      Collection<Object> input = null;
      Collection<Object> collection = JhipsterSampleApplicationCollections.immutable(input);

      assertThat(collection).isEmpty();
      assertThatThrownBy(() -> collection.clear()).isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void shouldGetImmutableCollectionFromMutableCollection() {
      Collection<String> input = new ArrayList<>();
      input.add("value");
      Collection<String> collection = JhipsterSampleApplicationCollections.immutable(input);

      assertThat(collection).containsExactly("value");
      assertThatThrownBy(() -> collection.clear()).isExactlyInstanceOf(UnsupportedOperationException.class);
    }
  }

  @Nested
  @DisplayName("Set")
  class JhipsterSampleApplicationCollectionsSetTest {

    @Test
    void shouldGetEmptyImmutableCollectionFromNullCollection() {
      Set<Object> input = null;
      Set<Object> set = JhipsterSampleApplicationCollections.immutable(input);

      assertThat(set).isEmpty();
      assertThatThrownBy(() -> set.clear()).isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void shouldGetImmutableCollectionFromMutableCollection() {
      Set<String> input = new HashSet<>();
      input.add("value");
      Set<String> set = JhipsterSampleApplicationCollections.immutable(input);

      assertThat(set).containsExactly("value");
      assertThatThrownBy(() -> set.clear()).isExactlyInstanceOf(UnsupportedOperationException.class);
    }
  }

  @Nested
  @DisplayName("List")
  class JhipsterSampleApplicationCollectionsListTest {

    @Test
    void shouldGetEmptyImmutableCollectionFromNullCollection() {
      List<Object> input = null;
      List<Object> list = JhipsterSampleApplicationCollections.immutable(input);

      assertThat(list).isEmpty();
      assertThatThrownBy(() -> list.clear()).isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void shouldGetImmutableCollectionFromMutableCollection() {
      List<String> input = new ArrayList<>();
      input.add("value");
      List<String> list = JhipsterSampleApplicationCollections.immutable(input);

      assertThat(list).containsExactly("value");
      assertThatThrownBy(() -> list.clear()).isExactlyInstanceOf(UnsupportedOperationException.class);
    }
  }
}
