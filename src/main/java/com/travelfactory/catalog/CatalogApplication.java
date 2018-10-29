package com.travelfactory.catalog;

import com.travelfactory.catalog.controllers.VendorController;
import com.travelfactory.catalog.dao.VendorInfo;
import com.travelfactory.catalog.repositories.VendorInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CatalogApplication implements CommandLineRunner {

    @Autowired
    private VendorInfoRepository repository;

    private Logger log = LoggerFactory.getLogger(VendorController.class);

//    public static void main(String[] args) {
//        SpringApplication.run(CatalogApplication.class, args);
//    }

    public static void main(String[] args) {
        new SpringApplicationBuilder() //
                .sources(CatalogApplication.class)//
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Clear DB...");
        repository.deleteAll();

        // Save a couple of vendor info
        repository.save(new VendorInfo("2", "Palace Hotel", "1932", "booking", "21-12-2016"));
        repository.save(new VendorInfo("2", "Palace Hotel2", "1933", "booking", "22-12-2016"));
        repository.save(new VendorInfo("3", "Béatrice Impérial Hotel", "164", "booking", "21-12-2016"));
        repository.save(new VendorInfo("4", "Dan Boutique", "88", "booking", "21-12-2016"));
        repository.save(new VendorInfo("2", "Dan Boutique2", "888", "vendor", "21-12-2016"));
        repository.save(new VendorInfo("3", "Dan Boutique3", "898", "vendor", "21-12-2016"));

        // Fetch all Vendors info
        log.info("Get all default Vendors info...");
        for (VendorInfo vendorInfo : repository.findAll()) {
            log.info(vendorInfo.toString());
        }
    }

}
