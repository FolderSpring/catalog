package com.travelfactory.catalog.controllers;

import com.google.gson.Gson;
import com.travelfactory.catalog.repositories.VendorInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class VendorController {

    @Autowired
    private VendorInfoRepository repository;

    private Gson gson = new Gson();

    private Logger log = LoggerFactory.getLogger(VendorController.class);

    /**
     * Shows info about service
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
    public String root() {
        log.info("requested root");
        return "<h1>REST SERVICE - Vendor Info</h1>" +
                "<p>- /catalog/ - main page with info about service</p>" +
                "<p>- /catalog/booking/21-12-2016 - get info about vendor by date</p>" +
                "<p>- /catalog/booking/21-12-2016/2 - get info about vendor by date by id</p>";
    }

    /**
     * Retrieves data by vendor name and date
     *
     * @param vendor
     * @param date
     * @return
     */
    @RequestMapping(value = "/{vendor}/{date}", method = RequestMethod.GET)
    public String getVendorByDate(@PathVariable("vendor") String vendor, @PathVariable("date") String date) {
        log.info("requested getVendorByDate");
        log.info("PARAMS vendor:" + vendor + ", date:" + date);

        String result = gson.toJson(repository.getAllByVendorAndDate(vendor, date));
        if (result.equals("null")) {
            return "{ \"message\": \"Not Found!\"}";
        }
        return result;
    }

    /**
     * Retrieves data by vendor name, date and id
     *
     * @param vendor
     * @param date
     * @param id
     * @return
     */
    @RequestMapping(value = "/{vendor}/{date}/{id}", method = RequestMethod.GET)
    public String getPetById(@PathVariable("vendor") String vendor, @PathVariable("date") String date, @PathVariable("id") String id) {
        log.info("requested getVendorByDate");
        log.info("PARAMS vendor: " + vendor + ", date:" + date + ", id:" + id);

        String result = gson.toJson(repository.getByVendorAndDateAndId(vendor, date, id));
        if (result.equals("null")) {
            return "{ \"message\": \"Not Found!\"}";
        }
        return result;
    }

}
