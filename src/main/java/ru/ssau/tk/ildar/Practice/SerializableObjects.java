package ru.ssau.tk.ildar.Practice;

import java.io.*;

public class SerializableObjects {

    public static void serializableObject(OutputStream outputStream, Object object) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(outputStream));
        out.writeObject(object);
        out.close();
    }
}
