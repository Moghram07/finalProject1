package com.example.finalproject.Repository;

import com.example.finalproject.Model.ZoomMeeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoomMeetingRepository extends JpaRepository<ZoomMeeting, Integer> {
    ZoomMeeting findZoomMeetingByMeetingId(Integer meetingId);
}
