package net.splitcells.network.community;

import net.splitcells.dem.environment.config.framework.OptionI;
import net.splitcells.dem.resource.FileSystemView;

import static net.splitcells.dem.resource.FileSystemViaClassResources.fileSystemViaClassResources;

public class NetworkCommunityFileSystem extends OptionI<FileSystemView> {
    public NetworkCommunityFileSystem() {
        super(() -> fileSystemViaClassResources(NetworkCommunityFileSystem.class
                , "net.splitcells", "network.community"));
    }
}
