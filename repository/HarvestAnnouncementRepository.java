package com.example.demo.repository;

import com.example.demo.model.HarvestAnnouncement;
import com.example.demo.model.HarvestStatus;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;

public interface HarvestAnnouncementRepository extends JpaRepository<HarvestAnnouncement, UUID> {
    
    List<HarvestAnnouncement> findByStatus(HarvestStatus status);

    // Requête spatiale PostGIS pour trouver les récoltes à proximité (rayon en mètres)
    @Query(value = "SELECT * FROM harvest_announcements h WHERE ST_DWithin(h.location, :point, :distance)", nativeQuery = true)
    List<HarvestAnnouncement> findNearbyHarvests(@Param("point") Point point, @Param("distance") double distance);
}
