package structure_patterns.proxy.downloader;

public class DownloaderTester {
    private DownloaderTester(){}

    public static long test(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // Поведение пользователя в приложении:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Кэширование помогает ускорить загрузку, если человек заходит в одни и те же видео.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");
        downloader.renderVideoPage("dancevideoo");
        downloader.renderVideoPage("anothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }

}
