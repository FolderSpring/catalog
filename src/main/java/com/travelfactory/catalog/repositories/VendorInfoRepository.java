package com.travelfactory.catalog.repositories;

import com.travelfactory.catalog.dao.VendorInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VendorInfoRepository extends MongoRepository<VendorInfo, String> {

    @Query(value = "{ 'vendor' : ?0 }", fields = "{ 'vendor' : 1 }")
    List<VendorInfo> getAllByVendor(String vendor);

    @Query(value = "{ 'vendor' : ?0, 'date' : ?1 }")
    List<VendorInfo> getAllByVendorAndDate(String vendor, String date);

    @Query(value = "{ 'vendor' : ?0, 'date' : ?1 , 'id' : ?2 }")
    VendorInfo getByVendorAndDateAndId(String vendor, String date, String id);

}