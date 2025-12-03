package test.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.demo.entity.Video;
import test.demo.repository.VideoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService { // Có thể viết thẳng class không cần interface để tiết kiệm thời gian
    @Autowired VideoRepository videoRepo;

    public List<Video> findAll() { return videoRepo.findAll(); }
    public Optional<Video> findById(String id) { return videoRepo.findById(id); }
    public Video save(Video video) { return videoRepo.save(video); }
    public void deleteById(String id) { videoRepo.deleteById(id); }
    public List<Video> findByTitle(String keyword) { return videoRepo.findByTitleContaining(keyword); }
}