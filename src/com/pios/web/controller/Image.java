package com.pios.web.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static java.lang.System.in;

/**
 * Created by Matija on 15.4.2017..
 */
@Controller
@RequestMapping("/image")
public class Image {

    @GetMapping(
            value = "/{name}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody
    byte[] getImageWithMediaType(@PathVariable String name) throws IOException {

        String imagePath = System.getProperty("catalina.home") + "\\uploads\\images\\" + name + ".jpg";

        InputStream in = new FileInputStream(imagePath);
        return IOUtils.toByteArray(in);
    }


}
