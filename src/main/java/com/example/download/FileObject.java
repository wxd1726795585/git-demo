package com.example.download;

/**
 * @author yutongwang
 * @date 2023/1/9 9:43 上午
 * @description
 */
public class FileObject {
    private String fileName;
    private String address;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fileName='" + fileName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
