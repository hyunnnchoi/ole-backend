package com.example.olebackend.converter;

import com.example.olebackend.domain.File;
import com.example.olebackend.web.dto.FileResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class FileConverter {

    public static FileResponse.getLessonImage toLessonImageDTO(File file) {

        return FileResponse.getLessonImage.builder()
                .id(file.getId())
                .path(getResourceUrl(file.getPath()))
                .name(file.getName())
                .represent(file.isRepresent())
                .build();

    }

    private static String getResourceUrl(String path) {
        // Assuming path is relative to resources/static
        Resource resource = new ClassPathResource("static/" + path);
        try {
            return resource.getURL().toString();
        } catch (IOException e) {
            // Handle exception (e.g., log an error) if URL cannot be obtained
            e.printStackTrace();
            return null;
        }


    }
}
