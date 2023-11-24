package structure_patterns.proxy.proxy;

import structure_patterns.proxy.media_library.ThirdPartyLibrary;
import structure_patterns.proxy.media_library.ThirdPartyYoutubeLib;
import structure_patterns.proxy.media_library.Video;

import java.util.HashMap;
import java.util.Map;

public class YouTubeCacheProxy implements ThirdPartyYoutubeLib {
    private ThirdPartyLibrary thirdPartyLibrary;
    private Map<String, Video> cachePopular = new HashMap<>();
    private Map<String, Video> cacheAll = new HashMap<>();

    public YouTubeCacheProxy() {
        this.thirdPartyLibrary = new ThirdPartyLibrary();
    }

    @Override
    public Map<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular= thirdPartyLibrary.popularVideos();
        } else {
            System.out.println("Получен список видео из кэша");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = thirdPartyLibrary.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.printf("Видео %s получено из кэша%n", video.getTitle());
        }
        return video;
    }

    public void reset() {
        cacheAll.clear();
        cachePopular.clear();
    }
}
