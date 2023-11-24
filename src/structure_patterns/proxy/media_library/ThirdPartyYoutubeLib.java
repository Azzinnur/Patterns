package structure_patterns.proxy.media_library;

import java.util.Map;

// Интерфейс, который определяет прокси и стандартный объект
public interface ThirdPartyYoutubeLib {
    Map<String, Video> popularVideos();

    Video getVideo(String VideoId);

}
