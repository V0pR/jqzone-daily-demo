package com.core.DemoCode;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * @Author: jq.w
 * @Date: 2021/12/23 16:57
 * @Description:
 */
public class AwsS4 {
    /**
     * accessKey – AWS 访问密钥。
     * secretKey – AWS 秘密访问密钥
     */
    private static String accessKeyId = "55DIWBJB0X4U249D8DD0";
    private static String secretKeyId = "52NLJIBoVrGtC25xpIeREclO25pXIdjGEYtM83vT";
    /**
     * bucket
     */
    private static String bucketName = "/zqt-data-daily";

    /**
     * 对象存储路径? 因为直接拼在bucket目录后面
     */
    private static String objectKey = "/test/20220318-001.pdf";
    /**
     * 服务端点
     */
    private static String serviceEndpoint = "https://storage.lianjia.com";

    public static void main(String[] args) throws IOException {
        //generatePreSignedUrl();
        //generatePreSignedUrl2();
        uploadObject(null);
        //getObject();
    }

    /**
     * 生成预签名
     *
     * @return
     */
    public static void generatePreSignedUrl() {
        try {

            AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(serviceEndpoint, "ap-beijing");
            BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, secretKeyId);
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                    .withEndpointConfiguration(endpointConfiguration)
                    .withPathStyleAccessEnabled(true)
                    .disableChunkedEncoding()
                    .build();

            // 签名有效时间
            java.util.Date expiration = new java.util.Date();
            long expTimeMillis = expiration.getTime();
            expTimeMillis += 1000 * 60 * 60;
            expiration.setTime(expTimeMillis);

            // 生成预先签名的 URL。
            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey)
                    .withMethod(HttpMethod.PUT)
                    .withExpiration(expiration);
            URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
            System.err.println("预签名URL：" + url.toString());

        } catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 文件上传
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static void uploadObject(@RequestParam("file") MultipartFile file) {
        //signingRegion 没有实际意义，强迫症可填写成：
        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(serviceEndpoint, "ap-beijing");
        try {
            BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, secretKeyId);
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withPathStyleAccessEnabled(true)
                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                    .withEndpointConfiguration(endpointConfiguration)
                    .build();
            String filePath = "https://esignoss.esign.cn/1111563786/08cdd670-cc21-4efe-a50a-50efcb9ea4c5/%E5%B7%A5%E7%A8%8B%E5%90%88%E5%90%8C.pdf?Expires=1647593244&OSSAccessKeyId=LTAI4G23YViiKnxTC28ygQzF&Signature=gucYjKvoSe83IS5JEe1qfiVdhPI%3D";
            InputStream inputStream = new URL(filePath).openStream();
            //File file1 = new File("/Users/qqjqq/Downloads/7972_20220224102930_4560.pdf");
            //InputStream inputStream = new FileInputStream(file1);
            //这里可以指定文件名称上传
            int available = inputStream.available();
            System.err.println("我是预估长度:" + available);
            ObjectMetadata metadata = new ObjectMetadata();
            //metadata.setContentLength(Long.valueOf(inputStream.available()));
            metadata.setContentType("application/pdf");

            //PutObjectRequest request = new PutObjectRequest(bucketName,"/test/"+"1"+file1.getName(), file1);
            //PutObjectResult putObjectResult = s3Client.putObject();
            //request.setMetadata(metadata);
            //PutObjectRequest request = new PutObjectRequest(bucketName, objectKey, inputStream, metadata);
            PutObjectResult putObjectResult = s3Client.putObject(bucketName, "/test/20220318-007.pdf", inputStream, metadata);
            System.err.println("upload request");
            //System.err.println(JSONObject.toJSONString(request));
            System.err.println("upload success");
            System.err.println(JSONObject.toJSONString(putObjectResult));
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getObject() throws IOException {
        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(serviceEndpoint, "ap-beijing");
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, secretKeyId);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withPathStyleAccessEnabled(true)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withEndpointConfiguration(endpointConfiguration)
                .build();
        S3Object object = s3Client.getObject(bucketName, objectKey);
        InputStream inputStream = object.getObjectContent();
        FileUtils.copyInputStreamToFile(inputStream, new File("/Users/qqjqq/Downloads/aaaa11wwwww1154574154.pdf"));
    }

}
