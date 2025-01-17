package com.mikotech.Reciept.Generator.service.Cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mikotech.Reciept.Generator.exceptions.MediaUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
//@RequiredArgsConstructor
public class CloudinaryUploadImpl implements UploadProduct{
    private final Cloudinary cloudinary;

    public CloudinaryUploadImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String uploadProductImage(MultipartFile file) throws MediaUploadException{
        try {
            Map<?, ?> uploadResponse = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("folder", "okinbead"));
            return (String) uploadResponse.get("secure_url");
        } catch (IOException theException) {
            throw new MediaUploadException(theException.getMessage());
        }
    }
}
