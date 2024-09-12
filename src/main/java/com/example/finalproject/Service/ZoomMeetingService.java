package com.example.finalproject.Service;

import com.example.finalproject.ApiException.ApiException;
import com.example.finalproject.Model.ZoomMeeting;
import com.example.finalproject.Repository.ZoomMeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZoomMeetingService {

    private final ZoomMeetingRepository zoomRepository;

    public List<ZoomMeeting> getAllZoomMeetings() {
        return zoomRepository.findAll();
    }

    public void addZoom(ZoomMeeting zoom) {
        zoomRepository.save(zoom);
    }

    public ZoomMeeting updateZoom(Integer id, ZoomMeeting zoom) {
        ZoomMeeting z = zoomRepository.findZoomMeetingByMeetingId(id);
        if(zoom == null) {
            throw new ApiException("Zoom meeting not found");
        }
        z.setPrice(zoom.getPrice());
        z.setUrl(zoom.getUrl());
        return zoomRepository.save(z);
    }

    public void deleteZoom(Integer id) {
        ZoomMeeting z = zoomRepository.findZoomMeetingByMeetingId(id);
        if (z == null) {
            throw new ApiException("Zoom meeting not found");
        }
        zoomRepository.deleteById(id);
    }

    // assign zoom to a session
}

