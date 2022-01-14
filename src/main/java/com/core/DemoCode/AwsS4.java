package com.core.DemoCode;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @Author: jq.w
 * @Date: 2021/12/23 16:57
 * @Description:
 */
public class AwsS4 {
    private static String accessKeyId = "55DIWBJB0X4U249D8DD0";
    private static String secretKeyId = "52NLJIBoVrGtC25xpIeREclO25pXIdjGEYtM83vT";
    private static String bucketName = "/zqt-data-prod";
    private static String objectKey = "/test/upload-test.zip";
    private static String serviceEndpoint = "https://ods.lianjia.com";
    public static void main(String[] args) {
          generatePreSignedUrl();
          //UploadObject(null);
    }

    /**
     * 生成预签名
     * @return
     */
    public static URL generatePreSignedUrl() {
        try {
            AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(serviceEndpoint,"cn-north-1");
            BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, secretKeyId);
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                    .withEndpointConfiguration(endpointConfiguration)
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

            System.err.println("预签名URL："+url.toString());
            return url;
        } catch (AmazonServiceException e) {
            // 调用已成功传输，但 Amazon S3 无法处理,所以它返回了一个错误响应
            e.printStackTrace();
        } catch (SdkClientException e) {
            // 无法联系 Amazon S3 以获取响应或客户端，无法解析来自 Amazon S3 的响应
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 文件上传
     * @param file
     * @return
     * @throws IOException
     */
    public static void UploadObject(@RequestParam("file") MultipartFile file){
        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(serviceEndpoint,"cn-north-1");
        try {
            BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, secretKeyId);
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withPathStyleAccessEnabled(true)
                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                    .withEndpointConfiguration(endpointConfiguration)
                    .build();
            //这里可以指定文件名称上传
            PutObjectRequest request = new PutObjectRequest(bucketName, objectKey, new File("/Users/qqjqq/Downloads/WX20211227-110836.png"));
            //ObjectMetadata metadata = new ObjectMetadata();
            //metadata.setContentType("application/octet-stream");//文件的content-type
            //metadata.addUserMetadata("title", "someTitle");
            //request.setMetadata(metadata);
            PutObjectResult putObjectResult = s3Client.putObject(request);
            System.err.println(JSONObject.toJSONString(putObjectResult));
        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
    }


}
