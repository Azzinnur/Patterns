package structure_patterns.proxy.media_library;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// Сервис-объект приложения
public class ThirdPartyLibrary implements ThirdPartyYoutubeLib{
    private Random random = new Random();
    @Override
    public Map<String, Video> popularVideos() {
        connectToServer("https://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("https://www.youtube.com/"+videoId);
        return getSomeVideo(videoId);
    }

    private void experienceNetworkLatency() {
        int randomLatency = random.nextInt(3, 10);
        for (int i =0; i < randomLatency; i++) {
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void connectToServer(String server) {
        System.out.printf("Устанавливается соединение с %s ... ", server);
        experienceNetworkLatency();
        System.out.println("Соединение с сервером установлено!");
    }

    private Map<String, Video> getRandomVideos() {
        System.out.print("Загружаем популярные видео... ");
        experienceNetworkLatency();
        Map<String, Video> hmap = new HashMap<>();
        hmap.put("catzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
        hmap.put("mkafksangasj", new Video("mkafksangasj", "Dog play with ball.mp4"));
        hmap.put("dancesvideoo", new Video("asdfas3ffasd", "Dancing video.mpq"));
        hmap.put("dlsdk5jfslaf", new Video("dlsdk5jfslaf", "Barcelona vs RealM.mov"));
        hmap.put("3sdfgsd1j333", new Video("3sdfgsd1j333", "Programing lesson#1.avi"));

        System.out.println("Загрузка популярных видео завершена!");
        return hmap;
    }

    private Video getSomeVideo(String videoId) {
        System.out.printf("Загружаем видео c ID %s... ", videoId);

        experienceNetworkLatency();
        Video video = new Video(videoId, "Some video title");

        System.out.println("Загрузка видео завершена!");
        return video;
    }
}
