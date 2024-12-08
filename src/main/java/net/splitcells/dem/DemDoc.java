/*
 * Copyright (c) 2021 Contributors To The `net.splitcells.*` Projects
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU General Public License v2.0 or later
 * which is available at https://www.gnu.org/licenses/old-licenses/gpl-2.0-standalone.html
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0-or-later
 * SPDX-FileCopyrightText: Contributors To The `net.splitcells.*` Projects
 */
package net.splitcells.dem;

import java.util.function.Consumer;

/**
 * TODO IDEA All {@link net.splitcells.dem.environment.config.framework.Option} should have respective static variables,
 * containing the current value,
 * so that code can access these variables via methods in the most efficient way.
 * In this construct {@link Dem#environment()} would be used in order to initialize and update the static variables.
 * For this {@link net.splitcells.dem.environment.config.framework.Option} needs an API to handle this case in a standard way.
 * Currently, ifs via static flags are used in order to trigger access to hard coded values for runtime improvements,
 * but in such a case, such values cannot be set dynamically during {@link Dem#ensuredInitialized()} (Class, Consumer)}.
 * This would also make it possible to create API projects like header files in C.
 */
public class DemDoc extends Dem {
}
