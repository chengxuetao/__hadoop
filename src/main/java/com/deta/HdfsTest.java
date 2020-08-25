package com.deta;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class HdfsTest {

    public static void main(String[] args) {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
        try (InputStream in = new URL("hdfs://172.16.3.198/test/sample.txt").openStream()) {
            List<String> list = IOUtils.readLines(in, "utf-8");
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
