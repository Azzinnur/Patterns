package structure_patterns.proxy.downloader;

import structure_patterns.proxy.media_library.ThirdPartyLibrary;
import structure_patterns.proxy.media_library.ThirdPartyYoutubeLib;
import structure_patterns.proxy.media_library.Video;

import java.util.Map;

public class YouTubeDownloader {
    private ThirdPartyYoutubeLib api;

    public YouTubeDownloader(ThirdPartyYoutubeLib api) {
        this.api = api;
    }

    public void renderVideoPage(String videoId) {
        Video video = api.getVideo(videoId);
        System.out.println("\n-------------------------------");
        System.out.println("Веб-страница с видео (представьте себе шикарную веб-страницу)");
        System.out.println("ID: " + video.getId());
        System.out.println("Название: " + video.getTitle());
        System.out.println("Видео: " + video.getData());
        System.out.println("-------------------------------\n");
    }

    public void renderPopularVideos() {
        Map<String, Video> list = api.popularVideos();
        System.out.println("\n-------------------------------");
        System.out.println("Самые популярные видео на YouTube (представьте себе шикарную веб-страницу)");
        for (Video video : list.values()) {
            System.out.println("ID: " + video.getId() + " / Название: " + video.getTitle());
        }
        System.out.println("-------------------------------\n");
    }
}
