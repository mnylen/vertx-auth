/*
 * Copyright 2015 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */
package io.vertx.ext.auth.jdbc;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * @deprecated Please use {@code vertx-auth-sql-client} instead.
 *
 * Options configuring JDBC authentication.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@Deprecated
@DataObject(generateConverter = true)
public class JDBCAuthorizationOptions {
  /**
   * The default query to retrieve all roles for the user
   */
  private final static String DEFAULT_ROLES_QUERY = "SELECT ROLE FROM USER_ROLES WHERE USERNAME = ?";

  /**
   * The default query to retrieve all permissions for the role
   */
  private final static String DEFAULT_PERMISSIONS_QUERY = "SELECT PERM FROM ROLES_PERMS RP, USER_ROLES UR WHERE UR.USERNAME = ? AND UR.ROLE = RP.ROLE";

  private String rolesQuery;
  private String permissionsQuery;

  public JDBCAuthorizationOptions() {
    this.rolesQuery = DEFAULT_ROLES_QUERY;
    this.permissionsQuery = DEFAULT_PERMISSIONS_QUERY;
  }

  public JDBCAuthorizationOptions(JsonObject json) {
    this();
    JDBCAuthorizationOptionsConverter.fromJson(json, this);
  }

  public String getRolesQuery() {
    return rolesQuery;
  }

  /**
   * Set the roles query to use. Use this if you want to override the default
   * roles query.
   *
   * @param rolesQuery the roles query
   * @return a reference to this, so the API can be used fluently
   */
  public JDBCAuthorizationOptions setRolesQuery(String rolesQuery) {
    this.rolesQuery = rolesQuery;
    return this;
  }

  public String getPermissionsQuery() {
    return permissionsQuery;
  }

  /**
   * Set the permissions query to use. Use this if you want to override the
   * default permissions query.
   *
   * @param permissionsQuery the permissions query
   * @return a reference to this, so the API can be used fluently
   */
  public JDBCAuthorizationOptions setPermissionsQuery(String permissionsQuery) {
    this.permissionsQuery = permissionsQuery;
    return this;
  }

}
