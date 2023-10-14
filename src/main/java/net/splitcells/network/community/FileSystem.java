package net.splitcells.network.community;

import net.splitcells.dem.environment.config.framework.OptionI;
import net.splitcells.dem.resource.FileSystemView;

import static net.splitcells.dem.resource.FileSystemViaClassResources.fileSystemViaClassResources;
import static net.splitcells.dem.resource.FileSystemViaClassResources.resourceBasePath;

public class FileSystem extends OptionI<FileSystemView> {
    public FileSystem() {
        super(() -> fileSystemViaClassResources(net.splitcells.system.FileSystem.class
                , resourceBasePath("net.splitcells", "network.community")));
    }
}
