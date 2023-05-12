package com.expedia.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**

 This interface represents the repository for the Hotel entity. It extends the JpaRepository interface provided by
 Spring Data JPA, which provides basic CRUD operations for the entity. By extending this interface, HotelRepository
 gains access to methods that allow it to interact with the underlying database and perform common database
 operations on the Hotel entity such as saving, updating, deleting, and querying.
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {
    @Query("SELECT h FROM Hotel h WHERE (:location IS NULL OR h.location.name = :locationName) "
            + "AND (:checkinDate IS NULL OR h.checkinDate = :checkinDate) "
            + "AND (:checkoutDate IS NULL OR h.checkoutDate = :checkoutDate) "
            + "AND (:minPrice IS NULL OR h.totalPrice >= :minPrice) "
            + "AND (:maxPrice IS NULL OR h.totalPrice <= :maxPrice) ")
    List<Hotel> getHotelsByFilter(@Param("location") String locationName,
                                  @Param("checkinDate") Date checkinDate,
                                  @Param("checkoutDate") Date checkoutDate,
                                  @Param("minPrice") Float minPrice,
                                  @Param("maxPrice") Float maxPrice);
}
