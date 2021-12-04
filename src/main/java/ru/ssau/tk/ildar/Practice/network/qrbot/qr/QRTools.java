package ru.ssau.tk.ildar.Practice.network.qrbot.qr;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;

@Slf4j
public class QRTools {

    private static final String FILE_FORMAT = "png";
    public static final String CHARSET = "UTF-8";
    private static final QRSize DEFAULT_VERSION = QRSize.MEDIUM;
    private static final HashMap<QRSize, Integer> qrSizes;

    /**
     * @param QRSIze размер QR (SMALL,MEDIUM or LARGE)
     * @return размер QR в int
     */
    private static int getQRSize(QRSize QRSIze) {
        return qrSizes.get(QRSIze);
    }

    /**
     * Изображения хранятся в хранилище telegram
     *
     * @param url адресс
     * @return изображение по url-адресу
     */
    private static BinaryBitmap getBitmapFromUrl(String url) throws IOException {
        BinaryBitmap binaryBitmap;
        try {
            binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                    new BufferedImageLuminanceSource(ImageIO.read(new URL(url)))));
        } catch (IOException e) {
            log.error(String.format("{QRTools.getBitmapFromUrl}: %s", e.getMessage()));
            throw new IOException(String.format("Unable to decrypt QR-code: %s", e.getMessage()));
        }
        return binaryBitmap;
    }

    /**
     * Декодирует изображение в текст
     *
     * @param binaryBitmap изображение
     * @return результат раскодировки
     */
    private static Result decodeBitmap(BinaryBitmap binaryBitmap) {
        Result result;
        try {
            result = new MultiFormatReader().decode(binaryBitmap);
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(String.format("Image does not contain QR-code: %s", e.getMessage()));
        }
        return result;
    }

    /**
     * Кодирует текст в QR-код
     *
     * @param text   отправленный текст
     * @param width  ширина изображения
     * @param height высота изображения
     * @return Полученное изображение сохраняется в файл с уникальным именем, метод возвращает путь к файлу
     */
    public static String encodeText(String text, int width, int height)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Hashtable hashtable = new Hashtable();
        hashtable.put(EncodeHintType.CHARACTER_SET, CHARSET);
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hashtable);
        Path path = FileSystems.getDefault().getPath(String.format("./images/%s.%s", UUID.randomUUID(), FILE_FORMAT));
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        return path.toAbsolutePath().toString();
    }

    /**
     * Кодирует текст в QR-код
     *
     * @param text   отправленный текст
     * @param QRSIze размер QR изображение
     * @return Полученное изображение сохраняется в файл с уникальным именем, метод возвращает путь к файлу
     */
    public static String encodeText(String text, QRSize QRSIze)
            throws WriterException, IOException {
        int size = getQRSize(QRSIze);
        return encodeText(text, size, size);
    }

    /**
     * Кодирует текст в QR-код (предполагается, что размер QR MEDIUM)
     *
     * @param text отправленный текст
     * @return Полученное изображение сохраняется в файл с уникальным именем, метод возвращает путь к файлу
     */
    public static String encodeText(String text)
            throws WriterException, IOException {
        return encodeText(text, DEFAULT_VERSION);
    }

    /**
     * @param url ссылка
     * @return текст, который содержит QR код
     */
    public static String getTextFromQR(String url) throws IOException {
        Result result;
        try {
            result = decodeBitmap(getBitmapFromUrl(url));
        } catch (RuntimeException | MalformedURLException e) {
            log.debug(String.format("decodeQR: %s", e.getMessage()));
            throw new IOException(String.format("Unable to decrypt QR-code: %s", e.getMessage()));
        }
        return result.getText();
    }

    static {
        qrSizes = new HashMap<>(Map.ofEntries(
                new AbstractMap.SimpleEntry<>(QRSize.SMALL, 256),
                new AbstractMap.SimpleEntry<>(QRSize.MEDIUM, 512),
                new AbstractMap.SimpleEntry<>(QRSize.LARGE, 1024))
        );
    }
}
