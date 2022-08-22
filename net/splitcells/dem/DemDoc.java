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
 */
public class DemDoc extends Dem {
}
