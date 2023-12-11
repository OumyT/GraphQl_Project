package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;
@SpringBootApplication
@Service
public class CreatorVideoService  {
    public static void main(String[] args) {

        SpringApplication.run(CreatorVideoService.class, args);
    }

    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {
            String[] names = {"Oum", "Nouha"};
            String[] emails = {"oum@gmail.com", "nouha@gmail.com"};

            List<Creator> creators = new ArrayList<>();
            IntStream.range(0, names.length)
                    .forEach(i -> {
                        Creator creator = new Creator();
                        creator.setName(names[i]);
                        creator.setEmail(emails[i]);
                        creators.add(creator);
                    });

            creatorRepository.saveAll(creators);

            Date currentDate = new Date();

            List<Video> videos = new ArrayList<>();
            IntStream.range(0, names.length)
                    .forEach(i -> {
                        Video video = new Video();
                        video.setName("v" + (i + 1));
                        video.setUrl("v" + (i + 1) + ".com");
                        video.setDatePublication(currentDate);
                        video.setDescription("this is video " + (i + 1));
                        video.setCreator(creators.get(i));
                        videos.add(video);
                    });

            videoRepository.saveAll(videos);
        };
    }

}
