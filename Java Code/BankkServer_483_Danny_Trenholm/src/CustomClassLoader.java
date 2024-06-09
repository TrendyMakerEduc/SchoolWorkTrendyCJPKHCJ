import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class CustomClassLoader extends ClassLoader {

    public Class<?> defineClass(byte[] classBytes) {
        return defineClass(null, classBytes, 0, classBytes.length);
    }

    public byte[] loadClassBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int data;
        while ((data = inputStream.read()) != -1) {
            buffer.write(data);
        }
        return buffer.toByteArray();
    }
}

