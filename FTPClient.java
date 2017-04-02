import java.io.*;
import java.net.*;

class FTPClient {

    public static void main(String[] args) throws Exception{

        //Initialize socket
        Socket socket = new Socket(InetAddress.getByName("localhost"), 5000);
        byte[] contents = new byte[10000];

        //Initialize the FileOutputStream to the output file's full path.
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Asus\\Desktop\\FTPCopied.txt");
/*
FileOutputStream- for writing data to a file
Preferable to use byte values
For char data- FileWriter is preferable
*/
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        InputStream is = socket.getInputStream();

        //No of bytes read in one read() call
        int bytesRead = 0;

        while((bytesRead=is.read(contents))!=-1)
            bos.write(contents, 0, bytesRead);

        bos.flush();
        socket.close();

        System.out.println("File saved successfully!");
    }
}

