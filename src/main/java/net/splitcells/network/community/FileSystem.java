package net.splitcells.network.community;

import net.splitcells.dem.environment.config.framework.OptionI;
import net.splitcells.dem.resource.FileSystemView;

import static net.splitcells.dem.resource.FileSystemViaClassResources.fileSystemViaClassResources;

public class FileSystem extends OptionI<FileSystemView> {
    public FileSystem() {
        super(() -> fileSystemViaClassResources(net.splitcells.system.FileSystem.class
                , "net.splitcells", "network.community"));
    }
}
