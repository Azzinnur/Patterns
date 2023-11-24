package structure_patterns.facade.media_library;

public class CodecFactory {
    public static Codec extract (VideoFile videoFile) {
        String type = videoFile.getCodecType();
        if (type.equals(Mpeg4CompressionCodec.type)) {
            System.out.println("Codec Factory: extracting mpeg audio...");
            return new Mpeg4CompressionCodec();
        } else if (type.equals(OggCompressionCodec.type)) {
            System.out.println("Codec Factory: extracting ogg audio...");
            return new OggCompressionCodec();
        } else {
            throw new RuntimeException("There is no such codec in Media Library!");
        }
    }
}
