package com.example.finalproject.Service;

import com.example.finalproject.ApiException.ApiException;
import com.example.finalproject.Model.Video;
import com.example.finalproject.Repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public void addVideo(Video video) {
        videoRepository.save(video);
    }

    public Video updateVideo(Integer id, Video video) {
        Video v = videoRepository.findVideoById(id);
        if(video == null) {
            throw new ApiException("Video not found");
        }
        v.setTitle(video.getTitle());
        v.setDescription(video.getDescription());
        v.setPrice(video.getPrice());
        return videoRepository.save(v);
    }

    public void deleteVideo(Integer id) {
        Video v = videoRepository.findVideoById(id);
        if(v == null) {
            throw new ApiException("Video not found");
        }
        videoRepository.deleteById(id);
    }

    // get video by title
    // get document by title
    // get video
}

