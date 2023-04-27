package com.expedia.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**

 This interface represents the repository for the Hotel entity. It extends the JpaRepository interface provided by
 Spring Data JPA, which provides basic CRUD operations for the entity. By extending this interface, HotelRepository
 gains access to methods that allow it to interact with the underlying database and perform common database
 operations on the Hotel entity such as saving, updating, deleting, and querying.
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {
}
