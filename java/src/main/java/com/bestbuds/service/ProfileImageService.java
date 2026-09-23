package com.bestbuds.service;

import com.bestbuds.dao.ProfileImageDao;
import com.bestbuds.model.ProfileImage;
import com.bestbuds.exception.InvalidProfileImageException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

@Service
public class ProfileImageService {

    private static final long MAX_UPLOAD_SIZE =
            5 * 1024 * 1024;

    private static final int MAX_IMAGE_DIMENSION =
            500;

    private static final float JPEG_QUALITY =
            0.85f;

    private final ProfileImageDao profileImageDao;

    public ProfileImageService(
            ProfileImageDao profileImageDao
    ) {
        this.profileImageDao = profileImageDao;
    }

    public ProfileImage getProfileImage(
            int userId
    ) {
        return profileImageDao.getProfileImageByUserId(
                userId
        );
    }

    public ProfileImage saveProfileImage(
            int userId,
            MultipartFile imageFile
    ) {

        validateImageFile(
                imageFile
        );

        byte[] imageData =
                processImage(
                        imageFile
                );

        ProfileImage profileImage =
                new ProfileImage();

        profileImage.setUserId(
                userId
        );

        profileImage.setImageData(
                imageData
        );

        profileImage.setContentType(
                "image/jpeg"
        );

        ProfileImage existingProfileImage =
                profileImageDao.getProfileImageByUserId(
                        userId
                );

        if (existingProfileImage == null) {
            return profileImageDao.createProfileImage(
                    profileImage
            );
        }

        profileImage.setId(
                existingProfileImage.getId()
        );

        return profileImageDao.updateProfileImage(
                profileImage
        );
    }

    public void deleteProfileImage(
            int userId
    ) {
        profileImageDao.deleteProfileImageByUserId(
                userId
        );
    }

    // Check basic upload requirements before processing
    private void validateImageFile(
            MultipartFile imageFile
    ) {

        if (imageFile == null
                || imageFile.isEmpty()) {

            throw new InvalidProfileImageException(
                    "Profile image is required"
            );
        }

        if (imageFile.getSize() > MAX_UPLOAD_SIZE) {

            throw new InvalidProfileImageException(
                    "Profile image must be 5 MB or smaller"
            );
        }
    }

    // Decode, resize, and compress the uploaded image
    private byte[] processImage(
            MultipartFile imageFile
    ) {

        try {
            BufferedImage originalImage =
                    ImageIO.read(
                            imageFile.getInputStream()
                    );

            if (originalImage == null) {
                throw new InvalidProfileImageException(
                        "Uploaded file must be a valid image"
                );
            }

            BufferedImage resizedImage =
                    resizeImage(
                            originalImage
                    );

            return convertToJpeg(
                    resizedImage
            );

        } catch (IOException e) {
            throw new InvalidProfileImageException(
                    "Unable to process profile image",
                    e
            );
        }
    }

    // Resize while preserving the original aspect ratio
    private BufferedImage resizeImage(
            BufferedImage originalImage
    ) {

        int originalWidth =
                originalImage.getWidth();

        int originalHeight =
                originalImage.getHeight();

        double scale =
                Math.min(
                        1.0,
                        (double) MAX_IMAGE_DIMENSION
                                / Math.max(
                                        originalWidth,
                                        originalHeight
                                )
                );

        int newWidth =
                (int) Math.round(
                        originalWidth * scale
                );

        int newHeight =
                (int) Math.round(
                        originalHeight * scale
                );

        BufferedImage resizedImage =
                new BufferedImage(
                        newWidth,
                        newHeight,
                        BufferedImage.TYPE_INT_RGB
                );

        Graphics2D graphics =
                resizedImage.createGraphics();

        try {
            graphics.setColor(
                    Color.WHITE
            );

            graphics.fillRect(
                    0,
                    0,
                    newWidth,
                    newHeight
            );

            graphics.setRenderingHint(
                    RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR
            );

            graphics.drawImage(
                    originalImage,
                    0,
                    0,
                    newWidth,
                    newHeight,
                    null
            );

        } finally {
            graphics.dispose();
        }

        return resizedImage;
    }

    // Store all profile images in one consistent JPEG format
    private byte[] convertToJpeg(
            BufferedImage image
    ) {

        Iterator<ImageWriter> writers =
                ImageIO.getImageWritersByFormatName(
                        "jpeg"
                );

        if (!writers.hasNext()) {
            throw new IllegalStateException(
                    "JPEG image writer is not available"
            );
        }

        ImageWriter writer =
                writers.next();

        try (
                ByteArrayOutputStream outputStream =
                        new ByteArrayOutputStream();

                ImageOutputStream imageOutputStream =
                        ImageIO.createImageOutputStream(
                                outputStream
                        )
        ) {

            writer.setOutput(
                    imageOutputStream
            );

            ImageWriteParam writeParam =
                    writer.getDefaultWriteParam();

            if (writeParam.canWriteCompressed()) {

                writeParam.setCompressionMode(
                        ImageWriteParam.MODE_EXPLICIT
                );

                writeParam.setCompressionQuality(
                        JPEG_QUALITY
                );
            }

            writer.write(
                    null,
                    new IIOImage(
                            image,
                            null,
                            null
                    ),
                    writeParam
            );

            return outputStream.toByteArray();

        } catch (IOException e) {
            throw new InvalidProfileImageException(
                    "Unable to save profile image",
                    e
            );

        } finally {
            writer.dispose();
        }
    }
}