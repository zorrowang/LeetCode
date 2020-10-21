# I/O in Java

<!-- MarkdownTOC -->

- [IO and NIO](#io-and-nio)
- [IO Class Overview](#io-class-overview)
- [Streams](#streams)
- [Java I/O: Files](#java-io-files)
  - [Reading Files](#reading-files)
  - [Writing Files](#writing-files)
  - [Random Access to Files](#random-access-to-files)
- [Java I/O: Streams](#java-io-streams)
  - [InputStream](#inputStream)
  - [OutputStream](#outputstream)
  - [Combining Streams](#combining-streams)
- [Java I/O: Pipes](#java-io-pipes)
  - [How to Use a Pipe](#how-to–use–a-pipe)
  
<!-- / MarkdownTOC -->

Java I/O is an API that comes with Java which is targeted at reading and writing data (input and output). Most applications need to process some input and produce some output based on that input. For instance, read data from a file or over network, and write to a file or write a response back over the network.

Java IO mostly concerns itself with the reading of raw data from a source and writing of raw data to a destination. The most typical sources and destinations of data are these:

- Files
- Pipes
- Network Connections
- In-memory Buffers (e.g. arrays)
- System.in, System.out, System.error

## IO and NIO

The Java IO package is primarily focused on input and output to files, network streams, internal memory buffers etc. However, the Java IO package does not contain classes to open network sockets which are necessary for network communication. For that purpose you need to use the Java Networking API. Once you have opened a socket (network connection) though, you read and write data to and from it via Java IO's InputStream and OutputStream classes.

The _java.io_ package doesn't actually address all types of input and output. For instance, input from and output to a GUI or web page is not covered in the Java IO package. Those types of input are covered elsewhere, for instance by the JFC classes in the Swing project, or the Servlet and HTTP packages in the Java Enterprise Edition.

Java also contains another IO API called Java NIO. It contains classes that does much of the same as the Java IO and Java Networking APIs, but Java NIO can work in non-blocking mode. Non-blocking IO can in some situations give a big performance boost over blocking IO.

## IO Class Overview

Java IO contains many subclasses of the _InputStream_, _OutputStream_, _Reader_ and _Writer_ classes. The reason is, that all of these subclasses are addressing various different purposes. That is why there are so many different classes. The purposes addressed are summarized below:

- File Access
- Network Access
- Internal Memory Buffer Access
- Inter-Thread Communication (Pipes)
- Buffering
- Filtering
- Parsing
- Reading and Writing Text (Readers / Writers)
- Reading and Writing Primitive Data (long, int etc.)
- Reading and Writing Objects

|   | Byte Based Input | Byte Based Output | Character Based Input | Character Based Output |
|:-:|:----------------:|:-----------------:|:---------------------:|:----------------------:|
| Basic | InputStream | OutputStream | Reader InputStreamReader | Writer OutputStreamWriter |
| Arrays | ByteArrayInputStream | ByteArrayOutputStream | CharArrayReader | CharArrayWriter |
| Files | FileInputStream RandomAccessFile | FileOutputStream RandomAccessFile | FileReader | FileWriter |
| Pipes | PipedInputStream | PipedOutputStream | PipedReader | PipedWriter |
| Buffering | BufferedInputStream | BufferedOutputStream | BufferedReader | BufferedWriter |
| Filtering | FilterInputStream | FilterOutputStream | FilterReader | FilterWriter |
| Parsing | PushbackInputStream StreamTokenizer | | PushbackReader LineNumberReader |
| Strings | | | | StringReader | StringWriter |
| Data | DataInputStream | DataOutputStream |
| DataFormatted | | PrintStream | | PrintWriter|
| Objects | ObjectInputStream | ObjectOutputStream |
| Utilities | SequenceInputStream |

## Streams

I/O Streams are a core concept in Java I/O. A stream is a conceptually endless flow of data. You can either read from a stream or write to a stream. A stream is connected to a data source or a data destination. Streams in Java IO can be either byte based (reading and writing bytes) or character based (reading and writing characters).

## Java I/O: Files

The Java IO API contains the following classes which are relevant to working with files in Java:

- File
- RandomAccessFile
- FileInputStream
- FileReader
- FileOutputStream
- FileWriter

### Reading Files

If you need to read a file from one end to the other you can use a _FileInputStream_ or a _FileReader_ depending on whether you want to read the file as binary or textual data. These two classes lets you read a file one byte or character at a time from the start to the end of the file, or read the bytes into an array of byte or char, again from start towards the end of the file. You don't have to read the whole file, but you can only read bytes and chars in the sequence they are stored in the file.

### Writing Files

If you need to write a file from one end to the other you can use a _FileOutputStream_ or a _FileWriter_ depending on whether you need to write binary data or characters. You can write a byte or character at a time from the beginning to the end of the file, or write arrays of byte and char. Data is stored sequentially in the file in the order they are written.

### Random Access to Files

The _RandomAccessFile_ class is used to manage random access to files in Java. Random access doesn't mean that you read or write from truly random places. It just means that you can skip around the file and read from or write to it at the same time in any way you want. This is what is meant by "random" - that the next byte read is not determined by the previous byte read. No particular access sequence is enforced. You can access the bytes in the file "at random" - arbitrarily. This makes it possible to overwrite parts of an existing file, to append to it, delete from it, and of course read from the file from wherever you need to read from it.

## Java I/O: Streams

Java IO streams are flows of data you can either read from, or write to. A stream has no concept of an index of the read or written data, like an array does. Nor can you typically move forth and back in a stream, like you can in an array, or in a file using RandomAccessFile. A stream is just a continuous flow of data.

### InputStream

The class _java.io.InputStream_ is the base class for all Java IO input streams. If you are writing a component that needs to read input from a stream, try to make our component depend on an InputStream, rather than any of it's subclasses (e.g. FileInputStream). Doing so makes your code able to work with all types of input streams, instead of only the concrete subclass.

Depending on _InputStream_ only isn't always possible, though. If you need to be able to push back data into the stream, you will have to depend on a _PushbackInputStream_ - meaning your stream variable will be of this type. Otherwise your code will not be able to call the _unread()_ method on the _PushbackInputStream_.

You typically read data from an _InputStream_ by calling the _read()_ method. The _read()_ method returns a int containing the byte value of the byte read. If there is no more data to be read, the _read()_ method typically returns -1;

```java
InputStream input = new FileInputStream("./input-file.txt");

int data = input.read();

while (data != -1) {
    data = input.read();
}
```

### OutputStream

The class _java.io.OutputStream_ is the base class of all Java IO output streams. If you are writing a component that needs to write output to a stream, try to make sure that component depends on an OutputStream and not one of its subclasses.

```java
OutputStream output = new FileOutputStream("c:\\data\\output-file.txt");
output.write("Hello World".getBytes());
output.close();
```

### Combining Streams

You can combine streams into chains to achieve more advanced input and output operations. For instance, reading every byte one at a time from a file is slow. It is faster to read a larger block of data from the disk and then iterate through that block byte for byte afterwards. To achieve buffering you can wrap your InputStream in an _BufferedInputStream_.

Buffering can also be applied to _OutputStream_'s thereby batching the writes to disk (or the underlying stream) up in larger chunks. That provides faster output too. This is done with a _BufferedOutputStream_.

Buffering is just one of the effects you can achieve by combining streams. You can also wrap your _InputStream_ in a _PushbackStream_. That way you can push data back into the stream to be re-read later. This is sometimes handy during parsing. Or, you can combine two _InputStreams_ into one using the _SequenceInputStream_

## Java I/O: Pipes

Pipes in Java IO provides the ability for two threads running in the same JVM to communicate. Therefore pipes can also be sources or destinations of data.

You cannot use a pipe to communicate with a thread in a different JVM (different process). The pipe concept in Java is different from the pipe concept in Unix / Linux, where two processes running in different address spaces can communicate via a pipe. In Java, the communicating parties must be running in the same process, and should be different threads.

### How to Use a Pipe

Creating a pipe using Java IO is done via the _PipedOutputStream_ and _PipedInputStream_ classes. A _PipedInputStream_ should be connected to a _PipedOutputStream_. The data written to the _PipedOutputStream_ by one thread can be read from the connected _PipedInputStream_ by another thread.

```java
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {

    public static void main(String[] args) throws IOException {

        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream  input  = new PipedInputStream(output);


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    output.write("Hello world, pipe!".getBytes());
                } catch (IOException e) {
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int data = input.read();
                    while(data != -1){
                        System.out.print((char) data);
                        data = input.read();
                    }
                } catch (IOException e) {
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
```

You can also connect the two pipe streams using their connect() methods. Both PipedInputStream and PipedOutputStream has a connect() method that can connect one to the other.

## References

- <http://tutorials.jenkov.com/java-io/index.html>
