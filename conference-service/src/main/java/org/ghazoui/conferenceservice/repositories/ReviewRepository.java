package org.ghazoui.conferenceservice.repositories;

import org.ghazoui.conferenceservice.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
