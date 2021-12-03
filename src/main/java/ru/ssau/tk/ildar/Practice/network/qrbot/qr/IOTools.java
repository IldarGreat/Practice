package ru.ssau.tk.ildar.Practice.network.qrbot.qr;

import org.json.*;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class IOTools {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    /**
     * Читает и парсит объект JSON с URL
     * @param url откуда нужно парсить
     * @return JSON объект из URL
     * @throws IOException не получается открыть поток
     */
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        }
    }
}
