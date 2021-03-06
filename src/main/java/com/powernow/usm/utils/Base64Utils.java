package com.powernow.usm.utils;


import java.io.*;
import java.util.Base64;

/**
 */
public class Base64Utils {

    /** */
    /**
     * cache area size
     */
    private static final int CACHE_SIZE = 1024;

    /**
     * <p>
     * BASE64 String to binarycode
     * </p>
     *
     * @param base64
     * @return
     * @throws Exception
     */
    public static byte[] decode(String base64) {
        return Base64.getDecoder().decode(base64.getBytes());
    }

    public static String decode(byte[] b) {
        return new String(Base64.getDecoder().decode(b));
    }

    /**
     * <p>
     * bianarycode to base64 String
     * </p>
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String encode(byte[] bytes) {
        return new String(Base64.getEncoder().encode(bytes));
    }

    /**
     * <p>
     * File to Base64 String
     * </p>
     * <p>
     * not sugest use of big file because outMemoryStack
     * </p>
     *
     * @param filePath absolutePath
     *
     * @return
     * @throws Exception
     */
    public static String encodeFile(String filePath) throws Exception {
        byte[] bytes = fileToByte(filePath);
        return encode(bytes);
    }

    /**
     * <p>
     * Base64 convert to File
     * </p>
     * @param filePath absolutepath
     * @param base64 Base64 String
     * @throws Exception
     */
    public static void decodeToFile(String filePath, String base64)
            throws Exception {
        byte[] bytes = decode(base64);
        byteArrayToFile(bytes, filePath);
    }

    /**
     * <p>
     * File convert to Base64
     * </p>
     *
     * @param filePath absolutePath
     *
     * @return
     * @throws Exception
     */
    public static byte[] fileToByte(String filePath) throws IOException {
        byte[] data = new byte[0];
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            File file = new File(filePath);
            if (file.exists()) {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream(2048);
                byte[] cache = new byte[CACHE_SIZE];
                int nRead = 0;
                while ((nRead = in.read(cache)) != -1) {
                    out.write(cache, 0, nRead);
                    out.flush();
                }
                data = out.toByteArray();
            }
        } catch (IOException e){

        } finally {
            out.close();
            in.close();
        }
        return data;
    }

    /**
     * <p>
     * write binary date to file
     * </p>
     *
     * @param bytes
     *            binary data
     * @param filePath
     *             file directory
     */
    public static void byteArrayToFile(byte[] bytes, String filePath) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new ByteArrayInputStream(bytes);
            File destFile = new File(filePath);
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            destFile.createNewFile();
            out = new FileOutputStream(destFile);
            byte[] cache = new byte[CACHE_SIZE];
            int nRead = 0;
            while ((nRead = in.read(cache)) != -1) {
                out.write(cache, 0, nRead);
                out.flush();
            }
        } catch (IOException e){

        } finally {
            out.close();
            in.close();
        }
    }

}
