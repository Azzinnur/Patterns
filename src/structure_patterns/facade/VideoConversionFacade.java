package structure_patterns.facade;

import structure_patterns.facade.media_library.AudioMixer;
import structure_patterns.facade.media_library.BitrateReader;
import structure_patterns.facade.media_library.Codec;
import structure_patterns.facade.media_library.CodecFactory;
import structure_patterns.facade.media_library.Mpeg4CompressionCodec;
import structure_patterns.facade.media_library.OggCompressionCodec;
import structure_patterns.facade.media_library.VideoFile;

import java.io.File;

public class VideoConversionFacade {
    public File convertVideo(String fileName, String format){
        System.out.printf("VideoConversionFacade: conversion to %s started.%n", format);
        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec = format.equals(Mpeg4CompressionCodec.type) ? new Mpeg4CompressionCodec()
                : new OggCompressionCodec();
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.printf("Video conversion to %s was competed!%n", format);
        return result;
    }
}
