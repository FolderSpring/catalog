package com.travelfactory.catalog.controllers;

import com.google.gson.Gson;
import com.travelfactory.catalog.repositories.VendorInfoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
@Api(tags = "catalog", description = "Manage catalog")
public class VendorController {

    @Autowired
    private VendorInfoRepository repository;

    private Gson gson = new Gson();

    private Logger log = LoggerFactory.getLogger(VendorController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
    @ApiOperation(value = "About service", notes = "Show info about service", response = String.class)
    public String root() {
        log.info("requested root");
        return "<h1>REST SERVICE - Vendor Info</h1>" +
                "<p>- <a href='http://localhost:8080/catalog/'>/catalog/</a> - main page with info about service</p>" +
                "<p>- <a href='http://localhost:8080/catalog/booking/21-12-2016'>/catalog/booking/21-12-2016</a> - get info about vendor by date</p>" +
                "<p>- <a href='http://localhost:8080/catalog/booking/21-12-2016/2'>/catalog/booking/21-12-2016/2</a> - get info about vendor by date by id</p>" +
                "</br></br><p>SWAGGER: <a href='http://localhost:8080/swagger-ui.html#/catalog'>http://localhost:8080/swagger-ui.html#/catalog</a></p>";
    }

    @RequestMapping(value = "/{vendor}/{date}", method = RequestMethod.GET)
    @ApiOperation(value = "Get vendor DATA by date", notes = "Retrieves data by vendor name and date", response = String.class)
    public String getVendorByDate(
            @ApiParam( value = "Vendor name", required = true, defaultValue = "booking") @PathVariable("vendor") String vendor,
            @ApiParam( value = "Date", required = true, defaultValue = "21-12-2016") @PathVariable("date") String date) {
        log.info("requested getVendorByDate");
        log.info("PARAMS vendor:" + vendor + ", date:" + date);

        String result = gson.toJson(repository.getAllByVendorAndDate(vendor, date));
        if (result.equals("null")) {
            return "{ \"message\": \"Not Found!\"}";
        }
        return result;
    }

    @RequestMapping(value = "/{vendor}/{date}/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get vendor DATA by date and id", notes = "Retrieves data by vendor name, date and id", response = String.class)
    public String getPetById(
            @ApiParam( value = "Vendor name", required = true, defaultValue = "booking") @PathVariable("vendor") String vendor,
            @ApiParam( value = "Date", required = true, defaultValue = "21-12-2016") @PathVariable("date") String date,
            @ApiParam( value = "Id", required = true, defaultValue = "2") @PathVariable("id") String id) {
        log.info("requested getVendorByDate");
        log.info("PARAMS vendor: " + vendor + ", date:" + date + ", id:" + id);

        String result = gson.toJson(repository.getByVendorAndDateAndId(vendor, date, id));
        if (result.equals("null")) {
            return "{ \"message\": \"Not Found!\"}";
        }
        return result;
    }

}
