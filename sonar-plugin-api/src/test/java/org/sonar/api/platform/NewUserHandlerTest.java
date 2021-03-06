/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2008-2012 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.api.platform;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.Assertions.assertThat;

public class NewUserHandlerTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void build_context() {
    NewUserHandler.Context context = NewUserHandler.Context.builder().setLogin("marius").setName("Marius").setEmail("marius@lesbronzes.fr").build();

    assertThat(context.getLogin()).isEqualTo("marius");
    assertThat(context.getName()).isEqualTo("Marius");
    assertThat(context.getEmail()).isEqualTo("marius@lesbronzes.fr");
  }

  @Test
  public void login_is_mandatory() {
    thrown.expect(NullPointerException.class);

    NewUserHandler.Context.builder().setName("Marius").build();
  }
}
