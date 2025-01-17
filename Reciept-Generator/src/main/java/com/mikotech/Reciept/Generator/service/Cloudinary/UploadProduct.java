package com.mikotech.Reciept.Generator.service.Cloudinary;

import org.springframework.web.multipart.MultipartFile;

public interface UploadProduct {
    String uploadProductImage(MultipartFile file);
}
