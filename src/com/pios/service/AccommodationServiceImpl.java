package com.pios.service;

import com.pios.persistence.dao.AccommodationDao;
import com.pios.persistence.model.Accommodation;
import com.pios.persistence.model.Image;
import com.pios.web.dto.AccommodationDTO;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Matija on 3/8/2017.
 */
@Service("accommodationService")
public class AccommodationServiceImpl implements AccommodationService {

    @Autowired
    AccommodationDao accommodationDao;

    @Autowired
    ServletContext context;



    @Transactional
    @Override
    public Accommodation addAccommodation(AccommodationDTO accommodationDTO) {

        //dodati smještaj u bazu
        Accommodation accommodation = accommodationDao.addAccommodation(accommodationDTO);
        //spremiti slike u bazu i na server

        Image image;
        String fileName;

        for(MultipartFile tmp : accommodationDTO.getImages()){
            image = new Image();
            image.setAccommodation(accommodation);
            fileName = generateFileName(tmp);
            image.setName(fileName);

            accommodationDao.addImage(image);
            saveImageOnServer(tmp, fileName);
        }


        //MultipartFile images[] = accommodationDao.addImages(accommodationDTO.getImages());



        return accommodation;
    }

    @Transactional
    @Override
    public Accommodation getAccommodation(int accommodationId) {
        return accommodationDao.getAccommodation(accommodationId);
    }

    @Transactional
    @Override
    public List<Accommodation> fetchAllAccommodations() {
        return accommodationDao.getAllAccommodations();
    }

    private void saveImageOnServer(MultipartFile image, String fileName) {
        if (!image.isEmpty()) {
            try {
                File file = new File(context.getRealPath("/") + "/uploads/"
                        + fileName);

                FileUtils.writeByteArrayToFile(file, image.getBytes());
                System.out.println("Go to the location:  " + file.toString()
                        + " on your computer and verify that the image has been stored.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String generateFileName(MultipartFile tmp) {
        Timestamp timestamp;
        String fileName = new String();
        try {
            byte[] image = tmp.getBytes();
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(image);
            String hashString = new BigInteger(1, digest).toString(16);
            //System.out.println("File hash: " + hashString);
            timestamp = new Timestamp(System.currentTimeMillis());
            fileName = hashString + "_" +timestamp.getTime() + ".jpg";


        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }
}
